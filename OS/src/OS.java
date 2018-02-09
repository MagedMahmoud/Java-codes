import java.util.*;

public class os {

	static HashMap<Integer, Job> jobTable; //job table to keep track of what's in core
	static int[] memory; //the free space table
	static int jobWaitingForMemory; //number of job selected to be put into memory
	static HashMap<Integer, Job> jobQueue; //jobs waiting for main memory
	static Job runningJob; //pointer to the running job
	static int currentlyRunning; //number of job currently using CPU
	static int currentlyRunningIO; //number of job currently using IO
	static HashMap<Integer, Job> CPU_Queue; //jobs waiting to use CPU
	static HashMap<Integer, Job> IO_Queue; //jobs waiting to use IO
	static boolean drumBusy;

    public static void startup() {
    	jobTable = new HashMap<Integer,Job>();
    	memory = new int [100]; //allocate 100k memory available in 1k blocks

    	//initialize all memory to empty (0)
    	for (int i=0; i<100; i++)
    		memory[i] = 0;

    	jobWaitingForMemory = 0;
    	currentlyRunning = 0;
    	currentlyRunningIO = 0;
    	CPU_Queue = new HashMap<Integer, Job>();
    	IO_Queue = new HashMap<Integer, Job>();
    	jobQueue = new HashMap<Integer, Job>();
    	runningJob = null;
    	drumBusy = false;
    }

    //handles new incoming jobs
    public static void Crint (int[] a, int[] p){
		BookKeep(p[5]);

    	Job newJob = new Job(p[1], p[2], p[3], p[4], p[5]); //create a new Job object with all the job data
    	jobTable.put(p[1], newJob);	//put the new job into the job table
    	jobQueue.put(p[1], newJob); //put the new job into the job queue

    	//put a new job into memory if there's no job waiting for memory
    	if (jobWaitingForMemory == 0)
    		swapper();

    	runCPU(a,p);
    }

    //drum has finished swapping a job in or out of memory
	//p[5] is the only parameter and it is the current time
	public static void Drmint (int[] a, int[] p) {
		BookKeep(p[5]);
		
		drumBusy = false;

		if (jobWaitingForMemory != 0) { //check if drum was swapping in
			jobTable.get(jobWaitingForMemory).inCore = true; //set the job's inCore flag to true in the job table
			//jobWaitingForMemory.inCore = true; //set the inCore flag to true
			Job currentJob = jobQueue.remove(jobWaitingForMemory); //remove job that finished being placed in memory from job queue
			jobWaitingForMemory = 0;

			CPU_Queue.put(currentJob.number, currentJob); //place it into CPU queue
		}

		swapper(); //let a new job into memory or swap out of memory

		runCPU(a,p);
	}

    //disk finished an I/O operation, I/O has been finished at top of I/O queue
    //p[5] is the only parameter
	public static void Dskint (int[] a, int[] p) {
		//System.out.println("dskint");
		
		BookKeep(p[5]);

		Job firstJob = IO_Queue.remove(currentlyRunningIO); //remove the job from IO queue that finished running IO
		firstJob.runningIO = false; //set the runningIO flag of the job removed to false
		currentlyRunningIO = 0; //no jobs currently running IO

		//if finished job was blocked
		if (firstJob.blocked == true) {
			CPU_Queue.put(firstJob.number, firstJob); //add it back to queue to run CPU again
			firstJob.blocked = false; //unblock job since it's finished IO
		}

		//remove job from memory if job's killbit is true
		if (firstJob.killBit == true) {
			for (int i=firstJob.startAddress; i<firstJob.startAddress+firstJob.size; i++) //remove from memory
				memory[i] = 0;
		}

		//run another job in the IO queue if it isn't empty
		for (int jobNum: IO_Queue.keySet()) {
			sos.siodisk(IO_Queue.get(jobNum).number); //run it on the disk
			currentlyRunningIO = jobNum; //set currentlyRunningIO to the job number
			break;
		}

		runCPU(a,p);
	}

	//running job has run out of time, terminate if it reached its maxCPUtime
	//p[5] is the only parameter
	public static void Tro (int[] a, int[] p) {
		BookKeep(p[5]);

		if (runningJob.timeRan == runningJob.maxCPUtime) { //check if job has reached its max CPU time
			a[0] = 1; //stop CPU
			jobTable.remove(runningJob.number); //remove job from job table
			CPU_Queue.remove(runningJob.number); //remove job from CPU queue

			//remove job from memory if job isn't doing IO
			//otherwise set killbit to true to remove it from memory when it's finished IO
			if (!runningJob.runningIO) {
				for (int i=runningJob.startAddress; i<runningJob.startAddress+runningJob.size; i++)
					memory[i] = 0;
			}
			else
				runningJob.killBit = true;

			runningJob =  null; //no job currently running

			swapper(); //let another job into memory or swap out of memory
		}

		runCPU(a,p);
	}

	//running job wants service
	public static void Svc (int[] a, int[] p) {
		BookKeep(p[5]);

		if (a[0] == 5) { //job wants to terminate
			//remove job from memory if job isn't still doing IO
			//otherwise set the killbit to true to remove it from memory when it's finished IO
			if (!runningJob.runningIO) {
				for (int i=runningJob.startAddress; i<runningJob.startAddress+runningJob.size; i++)
					memory[i] = 0;
			}
			else
				runningJob.killBit = true;

			jobTable.remove(runningJob.number); //remove job from job table
			CPU_Queue.remove(runningJob.number); //remove job from CPU queue

			a[0] = 1; //stop CPU
			runningJob = null; //no job currently running

			swapper(); //let a new job into memory or swap out of memory

			runCPU(a,p);
		}
		else if (a[0] == 6) { //job is requesting another disk I/O
			IO_Queue.put(runningJob.number, runningJob); //add to IO queue

			//if the job is blocked and in the CPU queue, remove it from CPU queue
			if (runningJob.blocked && !CPU_Queue.isEmpty())
				CPU_Queue.remove(runningJob.number);

			//run another job on IO if disk isn't busy
			if (currentlyRunningIO == 0) {
				for (int jobNum: IO_Queue.keySet()) {
					sos.siodisk(jobNum); //run the job on disk
					currentlyRunningIO = runningJob.number; //set currentlyRunningIO to the job number
					IO_Queue.get(jobNum).runningIO = true; //set runningIO flag for the job to true
					break;
				}
			}

			runningJob.runningIO = true; //set runningIO to true even if the running job is waiting in queue for IO

			runCPU(a,p);
		}
		else if (a[0] == 7) { //job is requesting to be blocked
			//stop running job on CPU if it's currently running IO
			if (runningJob.runningIO == true) {
				if (!CPU_Queue.isEmpty())
					CPU_Queue.remove(runningJob.number); //remove from CPU queue
				a[0] = 1; //stop CPU
				runningJob.blocked = true; //set blocked flag of running job to true
				runningJob = null; //no job currently running
			}

			runCPU(a,p);
		}
	}

	public static void swapper() {
		if (drumBusy) //exit if the drum is busy
			return;

		int lowestCPUtime = 99999; //initialize to a really high number
		Job selectedJob = null; //the job to swap in

		//check if there are any jobs waiting for memory and select the job with the least CPU time
		for (int jobNum: jobQueue.keySet()) {
			Job currentJob = jobQueue.get(jobNum);
			if (currentJob.maxCPUtime < lowestCPUtime) { //compare to lowest CPU time
				lowestCPUtime = currentJob.maxCPUtime; //set it as the new lowest CPU time
				selectedJob = currentJob; //set selectedJob to the job with the current lowest CPU time
			}
		}

		//exit if there are no jobs to swap in
		if (selectedJob == null)
			return;

		int start = 0; //starting address
		int count = 0; //keeps a count of how many contiguous blocks of memory
		for (int i=0; i<100; i++) {
			//checks if there is enough free memory available for the job
			if (memory[i] == 0) {
				count++;
			}
			else {
				start = i+1;
				count = 0;
			}
			//if there is enough memory, allocate it for the job
			if (selectedJob.size == count) {
				selectedJob.startAddress = start; //set the start address of the job
				jobWaitingForMemory = selectedJob.number; //set the current job in process of being swapped in
				//set the memory blocks to the job's number
				for (int j=start; j<count+start; j++)
					memory[j] = selectedJob.number;
				drumBusy = true; //set drum to busy
				sos.siodrum(selectedJob.number, selectedJob.size, start, 0); //swap the job into memory
				break;
			}
		}

		//if there was not enough space for any jobs (drum isn't busy), swap a job out for a smaller job
		int shortestTime = 99999; //initialize to really high number
		Job shortestJob = null; //job with shortest CPU time waiting for memory
		if (!drumBusy) {
			//find the shortest job in the job table that's not in memory
			for (int jobNum: jobTable.keySet()) {
				if (!jobTable.get(jobNum).inCore && (jobTable.get(jobNum).maxCPUtime-jobTable.get(jobNum).timeRan) < shortestTime)
					shortestJob = jobTable.get(jobNum);
			}
			//if a job waiting for memory was found, swap out a longer job in memory that has at least 1000 more CPU time remaining
			if (shortestJob != null) {
				//find if there's a job bigger 
				for (int jobNum: CPU_Queue.keySet()) {
					 //check if there's a job shorter by 1000 CPU time and not currently running IO
					if ((CPU_Queue.get(jobNum).maxCPUtime-CPU_Queue.get(jobNum).timeRan) > (shortestJob.maxCPUtime-shortestJob.timeRan+1000) && currentlyRunningIO != CPU_Queue.get(jobNum).number) {
						//remove the job from memory table
						for (int i=CPU_Queue.get(jobNum).startAddress; i<CPU_Queue.get(jobNum).startAddress+CPU_Queue.get(jobNum).size; i++)
							memory[i] = 0;
						drumBusy = true; //set drum to busy
						//remove it from IO queue if it's in there
						if (IO_Queue.containsKey(jobNum))
							IO_Queue.remove(jobNum);
						sos.siodrum(CPU_Queue.get(jobNum).number, CPU_Queue.get(jobNum).size, CPU_Queue.get(jobNum).startAddress, 1); //swap the job out
						jobQueue.put(jobNum, CPU_Queue.get(jobNum)); //put it back into the job queue
						CPU_Queue.remove(jobNum); //remove job from CPU queue
						shortestJob.inCore = false; //set the swapped in job's inCore flag to true
						break;
					}
				}
			}
		}
	}

	//keep track of the time ran and current time for the currently running job
	public static void BookKeep(int currentTime)
	{
		if (runningJob != null) {
			runningJob.timeRan += (currentTime - runningJob.lastTime);
			runningJob.lastTime = currentTime;
		}
	}

	public static void runCPU(int[] a, int[] p)
    {
		boolean foundJob = false;
		//find another job in CPU queue to run
	   	for (int jobNum: CPU_Queue.keySet()) {
			Job job = CPU_Queue.get(jobNum);
		    if (!job.blocked) {
		    	foundJob = true;
			    //run the job
			    a[0] = 2; //run CPU
			    p[2] = job.startAddress; //start address of job
			    p[3] = job.size; //size of job
			    p[4] = job.maxCPUtime - job.timeRan; //time slice
			    job.lastTime = p[5]; //set the current time for the job
		    	runningJob = job; //set the current running job
		    	break;
		    }
		}
		if (!foundJob) {
			a[0] = 1; //stop CPU
			runningJob = null; //no currently running job
		}
    }

}
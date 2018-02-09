public class Job {
	int number; //job number
	int priority; //priority of the job
	int size; //size of the job
	int maxCPUtime; //maximum CPU time allowed for job
	int lastTime; //to keep track of the last time it was interrupted
	int startAddress; //starting address of the job
	int timeRan; //amount of time ran on CPU
	boolean runningIO; //if job is running IO
	boolean blocked; //if job is blocked
	boolean inCore; //if job is in memory
	boolean killBit; //terminate after finishing IO

	public Job(int number, int priority, int size, int maxCPUtime, int lastTime) {
		this.number = number;
		this.priority = priority;
		this.size = size;
		this.maxCPUtime = maxCPUtime;
		this.lastTime = lastTime;
		this.startAddress = startAddress;
		this.timeRan = 0;
		this.runningIO = false;
		this.blocked = false;
		this.inCore = false;
		this.killBit = false;
	}
}
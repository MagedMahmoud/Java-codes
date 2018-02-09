class State {
    public int counter;
	public final Object lock = new Object();
}

class LockedAdder implements Runnable {
	public int counter;
	private State state;

	public LockedAdder(State state) {
		this.state = state;
	}

	public void run() {
		while (true) {
            synchronized (this.state.lock) {
                this.counter += 1;
			    this.state.counter += 1;
            }

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// We don't care.
			}
		}
	}
}

public class ThreadingExampleWithLock {
	public static void main(String[] args) {
		try {
			State sharedState = new State();
			LockedAdder adder0 = new LockedAdder(sharedState);
			LockedAdder adder1 = new LockedAdder(sharedState);
			Thread thread0 = new Thread(adder0);
			Thread thread1 = new Thread(adder1);
			thread0.start();
			thread1.start();
			while (true) {
				Thread.sleep(1000);
				System.out.printf("%d + %d = %d : %d\n",
					adder0.counter,
					adder1.counter,
					adder0.counter + adder1.counter,
					sharedState.counter
				);
			}
		} catch (Exception ex) {
			// eat it.
		}
	}
}


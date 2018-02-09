class State {
    public int counter;
	public boolean lock0 = false;
	public boolean lock1 = false;
}

class SpinLockedAdder implements Runnable {
	private int id;
	private State state;
	public int counter = 0;

	public SpinLockedAdder(int id, State state) {
        this.id = id;
		this.state = state;
	}

	public void run() {
		while (true) {
            if (id == 0) {
                while (this.state.lock0 == false) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // We don't care.
                    }
                }
				this.counter += 1;
				this.state.counter += 1;
				this.state.lock0 = false;
				this.state.lock1 = true;
			} else {
				while (this.state.lock1 == false) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// We don't care.
					}
				}
				this.counter += 1;
				this.state.counter += 1;
				this.state.lock0 = true;
				this.state.lock1 = false;
			}
		}
	}
}

public class ThreadingExampleWithSpinLock {
	public int counter = 0;
	public static void main(String[] args) {
		try {
            State sharedState = new State();

			SpinLockedAdder adder0 = new SpinLockedAdder(0, sharedState);
			SpinLockedAdder adder1 = new SpinLockedAdder(1, sharedState);
			Thread thread0 = new Thread(adder0);
			Thread thread1 = new Thread(adder1);
			thread0.start();
			thread1.start();
            // If both locks start out as false, no progress will ever be made!
            // So we initialize `lock0` to false.
			sharedState.lock0 = true;
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

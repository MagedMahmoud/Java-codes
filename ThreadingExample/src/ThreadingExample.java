import java.util.concurrent.Semaphore;

class State {
    public int counter;
}

class Adder implements Runnable {
	public int counter;
    private State state;

	public Adder(State state) {
		this.state = state;
	}

	public void run() {
		while (true) {
			counter += 1;
			this.state.counter += 1;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// We don't care.
			}
		}
	}
}

public class ThreadingExample {
	public static void main(String[] args) {
		try {
            State sharedState = new State();

			Adder adder0 = new Adder(sharedState);
			Adder adder1 = new Adder(sharedState);
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


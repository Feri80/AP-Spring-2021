package threadInterrupt;

public class Restaurant {

	public static void main(String[] args) {
		Chef ali = new Chef();
		ali.start();
		doSomeWork();
		System.out.println("Restaurant: Enough food has been cooked. Let's stop chef Ali.");
		ali.interrupt();

	}

	private static void doSomeWork() {
		try {
			// Simulating doing some work
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Restaurant (Main thread) got interrupted.");
		}
	}

}

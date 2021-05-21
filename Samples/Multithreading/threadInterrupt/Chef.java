package threadInterrupt;

public class Chef extends Thread {

	@Override
	public void run() {
		while(!(Thread.interrupted())) {
			System.out.println("Chef: Making some food for guests.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("I got awaken!");
				Thread.currentThread().interrupt();
			}
			cookingFood();
		}
		System.out.println("Chef: That was a long day. I am tired.");
	}

	private void cookingFood() {
		for(int i = 0; i < 100000000; i++) {
			Math.sin(i);
		}
		
//		try {
//		//  Simulating cooking of food
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			System.out.println("Chef: It seems they don't need any more food!");
//			break;
//		}
	}

}

package runnableExample;

class RunnableClass implements Runnable {
	@Override
    public void run() {
        System.out.println("Hello from a thread!");
    }
}

public class RunnableSimple {

    public static void main(String args[]) {
    	Thread mySimpleThread = new Thread(new RunnableClass());
        mySimpleThread.start();
    }

}

package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
	static int counter=0;
	public void run() {
		for(int i=0;i<100;i++) {
			increment();
		}
	}
	private static void increment() {
		counter++;
	}
	public static int getCount() {
		return counter;
	}
}
public class ThreadPool {
	public static void main(String[] args) {
		//first create a thread pool of size 5
		ExecutorService service = Executors.newFixedThreadPool(5);
		//submit jobs to the executor service
		for(int i=0;i<10;i++) {
			service.execute(new Task());
		}
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {e.printStackTrace();};
		service.shutdown();
		while(!service.isShutdown()) {
		}
		System.out.println(Task.getCount());
	}
}

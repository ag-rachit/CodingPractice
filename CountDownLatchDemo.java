import java.util.concurrent.CountDownLatch;
class CountDownLatchDemo {

	static int count = 0;
	public static void main(String args[]) throws InterruptedException {
		// Let us create task that is going to
		// wait for four threads before it starts
		CountDownLatch latch = new CountDownLatch(4);

/*		Worker first = new Worker(1000, latch,
				"WORKER-1");
		Worker second = new Worker(2000, latch,
				"WORKER-2");
		Worker third = new Worker(3000, latch, "WORKER-3");
		Worker fourth = new Worker(4000, latch, "WORKER-4");
		first.start();
		second.start();
		third.start();
		fourth.start();*/


		for (int i =0 ; i < 10 ; i++) {
			Thread t = new Thread(() -> {
				count ++;
				System.out.println("Thread " + count);
				latch.countDown();
			});
			Thread t1 = new Thread(() -> {
				count ++;
				System.out.println("Thread " + count);
				latch.countDown();
			});
			Thread t2 = new Thread(() -> {
				count ++;
				System.out.println("Thread " + count);
				latch.countDown();
			});
			;
			Thread t3 = new Thread(() -> {
				count ++;
				System.out.println("Thread " + count);
				latch.countDown();
			});
			t.start();
			t1.start();
			t2.start();
			t3.start();
		}

		latch.await();
		// Main thread has started
		System.out.println(Thread.currentThread().getName() +
				" has finished");
	}
}

/*// A class to represent threads for which
// the main thread waits.
class Worker extends Thread
{
	private int delay;
	private CountDownLatch latch;

	public Worker(int delay, CountDownLatch latch,
				  String name)
	{
		super(name);
		this.delay = delay;
		this.latch = latch;
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(delay);
			latch.countDown();
			System.out.println(Thread.currentThread().getName()
					+ " finished");
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
} */

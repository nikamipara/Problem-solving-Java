package prec;

public class Threadmagic {
	static Thread t1, t2, t3;

	// volatile int a,b,c;
	public static void main(String... args) {
		Runnable r = new Runnable() {
			int one = 0;
			int i = 0;

			@Override
			public void run() {
				for (; i < 1000; i++) {
					//this.wait();
					synchronized(this){System.out.println("Thread :"
							+ Thread.currentThread().getName() + ":" + i);
					}
					//this.notify();
				}
			}
		};
		/*t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i < 1000; i = i + 3) {

					try {
						wait();
					} catch (InterruptedException e) {
						System.out.println("Error :Thread 1");
						e.printStackTrace();
					}
					System.out.println("Thread 2:" + i);
					t3.notify();
				}
				;
			}
		});
		t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 2; i < 1000; i = i + 3) {

					try {
						wait();
					} catch (InterruptedException e) {
						System.out.println("Error :Thread 1");
						e.printStackTrace();
					}
					System.out.println("Thread 3:" + i);
					t1.notify();
				}
				;
			}
		});*/
		t1 = new Thread(r,"thread 1");
		t2 = new Thread(r,"thread 2");
		//t3 = new Thread(r,"thread 3");
		t1.start();
		t2.start();
		//t3.start();
		
	}
}

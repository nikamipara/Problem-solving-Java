package LeanStartUpBar;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class StartupBar {
	public static void main(String... args) throws IOException, InterruptedException {
		BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
		Chef c = new Chef(q);
		Thread mychef = new Thread(c);
		Waiter w = new Waiter(q,mychef);
		mychef.start();
		Thread waiter = new Thread(w);
		waiter.start();
		waiter.join();
		mychef.join();
		q.clear();
	}
}
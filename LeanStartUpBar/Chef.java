package LeanStartUpBar;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;

class Chef implements Runnable {
	private static final int MIN = 1000*60;
	private final BlockingQueue<Integer> queue;
	private int count=0;
	private PrintStream out;
	Chef(BlockingQueue<Integer> q) throws IOException {
		queue = q;
		File f =new File("OrderProcessed.txt");
		f.createNewFile();
		System.out.println("File will be  saved at "+f.getAbsolutePath());
		out = new PrintStream(f);
	}

	public void run() {
		try {
			while (true) {
				int OrderId = queue.take();
				if(OrderId==-1){
					break;
				}
				out.println("Chef: Picked up ORD"+(++count)+" at "+ Utills.getCurrentTime());
				prepareMeal(OrderId);
				out.println("Chef: Finished making "+Utills.getMealName(OrderId)+" for ORD"+(count)+" at "+ Utills.getCurrentTime());
			}
			out.println("Chef: We are closed now");
		} catch (InterruptedException ex) {
			out.println("Chef is Interrupted One should not disturb cook when he is preparing meals.");
		} finally{
			out.close();
			queue.clear();
		}
	}

	private void prepareMeal(int orderId) throws InterruptedException {
		out.println("Chef: Cooking " +Utills.getMealName(orderId)+" ...");
		switch (orderId) {
		case 1:Thread.sleep(5*MIN);return;
		case 2:Thread.sleep(3*MIN); return;
		case 3:Thread.sleep(3*MIN); return;
		case 4:Thread.sleep(7*MIN); return;
		default:
			return;
		}
	}
}


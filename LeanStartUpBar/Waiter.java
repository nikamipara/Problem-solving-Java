package LeanStartUpBar;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable {
	private Scanner sc;
	private int count = 0;

	private final BlockingQueue<Integer> queue;
	private Thread chef;

	Waiter(BlockingQueue<Integer> q, Thread chef) {
		queue = q;
		this.chef = chef;
		sc = new Scanner(System.in);
	}

	public void run() {
		try {
			while (true) {
				// Thread.sleep(100);
				System.out.print("Enter Item id:");
				int orderNumber = sc.nextInt();

				if (orderNumber == -1) {
					queue.put(-1);
					break;
				} else if (orderNumber < 1 || orderNumber > 4) {
					System.out
							.println("Sorry The Meal you requestd is not available Today");
					continue;
				} else {
					queue.put(orderNumber);
					System.out.println("OrderNumber:ORD" + (++count) + " for "
							+ Utills.getMealName(orderNumber)
							+ " has been placed at " + Utills.getCurrentTime());
				}
			}
			System.out.println("Waiter: We are closed now");
		} catch (InterruptedException e) {
			System.out.println("Waiter: interrupted.");
			chef.interrupt();
		} finally {
			sc.close();
			queue.clear();

		}
	}
}

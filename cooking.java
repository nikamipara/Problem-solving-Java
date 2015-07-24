import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
class Utills{
	private  static final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss a");
	public static String getMealName(int id){
		switch(id){
		case 1: 
			return "Sandwich";
		case 2: 
			return "Coffie";
		case 3: 
			return "Cerial";
		case 4: 
			return "Pizza";
		default:
			return "";
		}
	}
	public static String getCurrentTime() {
		return Utills.dateFormat.format(new Date());
	}
}
class Waiter implements Runnable {
	private Scanner sc;
	private int count=0;
	
	private final BlockingQueue<Integer> queue;
	private Thread chef;

	Waiter(BlockingQueue<Integer> q,Thread chef) {
		queue = q;
		this.chef=chef;
		sc = new Scanner (System.in);
	}

	public void run() {
		try {
			while (true) {
				// Thread.sleep(100);
				System.out.print("Enter Item id:");
				int orderNumber = sc.nextInt();
				//System.out.println();
				queue.put(orderNumber);
				if(orderNumber==-1)Thread.currentThread().interrupt();
				else if(orderNumber<1||orderNumber>4){System.out.println("Sorry The Meal you requestd is not available Today");continue;}
				System.out.println("OrderNumber:ORD"+(++count)+" for "+Utills.getMealName(orderNumber)+" has been placed at "+Utills.getCurrentTime());
			}
		} catch (InterruptedException e) {
			System.out.println("Waiter: interrupted.");
			chef.interrupt();
		}finally{
			sc.close();
		}
	}
}

class Chef implements Runnable {
	private static final int MIN = 1000;
	private final BlockingQueue<Integer> queue;
	private int count=0;
	private PrintStream out;
	Chef(BlockingQueue<Integer> q) throws IOException {
		queue = q;
		File f =new File("OrderProcessed.txt");
		f.createNewFile();
		System.out.println("File saved at "+f.getAbsolutePath());
		out = new PrintStream(f);
	}

	public void run() {
		try {
			while (true) {
				//Thread.sleep(100);
				int OrderId = queue.take();
				out.println("Chef: Picked up ORD"+(++count)+" at "+ Utills.getCurrentTime());
				prepareMeal(OrderId);
				out.println("Chef: Finished making "+Utills.getMealName(OrderId)+" for ORD"+(count)+" at "+ Utills.getCurrentTime());
			}
		} catch (InterruptedException ex) {
			out.println("Chef is Interrupted One should not disturb cook when he is preparing meals.");
		} finally{
			out.close();
		}
	}

	private void prepareMeal(int orderId) throws InterruptedException {
		out.println("Chef: Cooking " +Utills.getMealName(orderId)+" ...");
		switch (orderId) {
		case 1: Thread.sleep(5*MIN); return;
		case 2:Thread.sleep(3*MIN); return;
		case 3:Thread.sleep(3*MIN); return;
		case 4:Thread.sleep(7*MIN); return;
		default:
			return;
		}
	}
}

class cooking {
	public static void main(String... args) throws IOException {
		BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
		Chef c = new Chef(q);
		Thread mychef = new Thread(c);
		Waiter w = new Waiter(q,mychef);
		mychef.start();
		new Thread(w).start();
		/*try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//new Thread(c2).start();
	}
}
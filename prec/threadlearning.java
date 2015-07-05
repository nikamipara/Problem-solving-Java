package prec;

import java.util.concurrent.Semaphore;

/*
class Q {
	int n;
	boolean valueSet = false;

	synchronized int get() {
		if (!valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		if (valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}

class Producer implements Runnable {
	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();
	}

	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
		}
	}
}

class Consumer implements Runnable {
	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		while (true) {
			q.get();
		}
	}
}

class threadlearning {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Press Control-C to stop.");
	}
}
*/
public class threadlearning extends Thread {
    public int name;
    final Value v;
    final Semaphore lock;

    public threadlearning(Value v, Semaphore lock) {
        this.v = v;
        this.lock = lock;
    }

    public void run() {
        try {
        	//lock.acquire();
            while (v.i <= 50) {
            	lock.acquire();
                System.out.println("Thread" + name + " : " + v.i);
                v.i++;
                lock.release();
                sleep(100);
               // lock.acquire();
            }
            //lock.release();
        } catch (Exception e) {
            System.out.println("some problem");
        }
        finally{
        	lock.release();
        }
    }

    public static void main(String[] args) {
        Value v = new Value();
        Semaphore lock = new Semaphore(1);
        threadlearning a = new threadlearning(v, lock);
        threadlearning b = new threadlearning(v, lock);
        a.name = 1;
        b.name = 2;
        a.start();
        b.start();
    }

    static class Value {
        int i = 1;
    }
}
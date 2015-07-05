package prec;

/*public class threadtry3 {

}*/
class O {
    O nextnofity;
    int i=0;
    public O(O next, int initial){
    	nextnofity=next;
    	//initialint = initial;
    }
    synchronized public void print(Thread t){
    	for(;i<100;i++){
    		try {
    			System.out.println("T:"+Thread.currentThread().getName()+" entering in waiting");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("T:"+Thread.currentThread().getName()+" interrupted");
				//e.printStackTrace();
			}
    		System.out.println("T:"+Thread.currentThread().getName()+" "+i);
    		System.out.println("T:"+Thread.currentThread().getName()+" notifying next thread:");
    		t.interrupt();
    		System.out.println("T:"+Thread.currentThread().getName()+"next thread notified ");
    	}
    }

    /*public synchronized void one( object msg) {
        if (flag1||flag2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag1 =false; flag2=true;
        notify();
    }

    public synchronized void two(String msg) {
        if (flag1||!flag2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg);
        flag1 = true; flag2=true;
        notify();
    }
    public synchronized void three(String msg) {
        if (!flag1||!flag2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread:"+Thread.currentThread().getName()+"   -"+msg);
        flag1 = false;flag2=false;
        notify();
    }
*/}

class T1 implements Runnable {
    O m;
    String[] s1 = { "1", "4", "7" };
    public Thread tw;
    T2 next;
    public T1(O m1,T2 next) {
        this.m = m1;
        this.next=next;
        tw = new Thread(this, "one");
      //  tw.start();
        
    }
    public void start(){
    	tw.start();
    }
    public void run() {
        
    	m.print(next.tw);/*for (int i = 0; i < s1.length; i++) {
            m.one(s1[i]);
        }*/
    }
}

class T2 implements Runnable {
    O m;
    public Thread tw;
    T3 n;
    String[] s2 = { "2", "5", "8" };

    public T2(O m2,T3 ne) {
        this.m = m2;
        n=ne;
        tw = new Thread(this, "two");
      // tw.start();
    }
    public void start(){
    	tw.start();
    }
    public void run() {
        m.print(n.tw);
    }
}
class T3 implements Runnable {
    O m;
    String[] s3 = { "3", "6", "9" };
    public Thread tw;
    T1 mm;
    public T3(O m3,T1 mm) {
        this.m = m3;
        this.mm=mm;
         tw = new Thread(this, "three");
        //tw.start();
    }
    public void start(){
    	tw.start();
    }

    public void run() {
        m.print(mm.tw);
    }
}
public class threadtry3 {
     public static void main(String[] args) {
        O one=null,two=null,three=null;
        
        one = new O(one,1);
        two = new O(one,2);
        three = new O(one,3);
        T1 t1;
        T2 t2 = null;
        T3 t3 = null;
         t1 =new T1(one,t2);
         t2 =new T2(one,t3);
         t3 =new T3(one,t1);
         t1.start();
         t2.start();
         t3.start();
        t1.tw.interrupt();
    }
}
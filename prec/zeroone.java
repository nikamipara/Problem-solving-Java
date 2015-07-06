package prec;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
class zeroone {
	public static String pow(int j){
		StringBuffer f = new StringBuffer("1");
		for (int i = 0; i < j; i++) {
			f.append("0");
		}
		return f.toString();
	}
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// k = sc.nextInt();
		for (int i = 1; i < 10000; i++)
			calculate(i);

	}

	private static void calculate(int n) {
		BigInteger ans = new BigInteger("0");
		HashMap<Integer, BigInteger> a = new HashMap<Integer, BigInteger>();
		
		int power = 0;
		int reminder = (new BigInteger(pow(power)).mod(new BigInteger(Integer.toString(n)))).intValue();
		if (reminder==0) {
			ans = new BigInteger(pow(power));
		} else {
			//Long g = (long)Math.pow(10, power);
			a.put(reminder, new BigInteger(pow(power)));
			power++;
			boolean while1 = true;
			while (while1) {
				reminder = (new BigInteger(pow(power)).mod(new BigInteger(Integer.toString(n)))).intValue();
				if (reminder==0) {
					ans = new BigInteger(pow(power));
					break;
				} else {
					HashMap<Integer, BigInteger> temp = new HashMap<Integer, BigInteger>();
					Iterator it = a.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry pair = (Map.Entry) it.next();
						// System.out.println(pair.getKey() + " = " +
						// pair.getValue());
						int newr = (reminder+(int)pair.getKey())%n;
						if (newr==0) {
							ans = new BigInteger(pow(power));
							ans = ans.add((BigInteger)pair.getValue());
									//+ (long) pair.getValue();
							while1 = false;
							break;
						} else {
							if (a.get(newr) == null && temp.get(newr) == null) {
								BigInteger b = new BigInteger(pow(power));
								BigInteger aa = new BigInteger(pair.getValue().toString());
								b =b.add(aa);
								temp.put(newr, b);
							}
						}
						// it.remove(); // avoids a
						// ConcurrentModificationException
					}
					a.putAll(temp);
					a.put(reminder, new BigInteger(pow(power)));
				}
				power++;
			}
		}
			System.out.println("#"+n+"  "+ans);
	}
}
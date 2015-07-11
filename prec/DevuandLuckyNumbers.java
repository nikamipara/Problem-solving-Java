package prec;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class DevuandLuckyNumbers {
	static final int MOD = 1000000007;
	static final BigInteger BMOD = new BigInteger("1000000007");
	static int fours = 1;
	static int fives = 3;
	static int sixes = 5;

	public static void main(String... args) {
		//System.out.println(Integer.MAX_VALUE- MOD);
		Scanner sc = new Scanner(System.in);
		/*fours = sc.nextInt();
		fives = sc.nextInt();
		sixes = sc.nextInt();*/
		if(fours==fives&& fives==sixes&& sixes==0){ System.out.println(0); return;}
		int digit =2;
		ArrayList<p> one = new ArrayList<p>();
		ArrayList<p> two = new ArrayList<p>();
		ArrayList<p> three = new ArrayList<p>();
		int sum=0;
		// initialized data
		// for fours
		if (valid(1, 0, 0)) {
			BigInteger b = new BigInteger("4").mod(BMOD);
			sum = (b.intValue() % MOD + sum % MOD) % MOD;
			p newp = new p();
			newp.no = "4";
			newp.fours = 1;
			newp.fives = 0;
			newp.sizxes = 0;
			one.add(newp);
		}
		// for fives
		if (valid(0, 1, 0)) {
			BigInteger b = new BigInteger("5").mod(BMOD);
			sum = (b.intValue() % MOD + sum % MOD) % MOD;
			p newp = new p();
			newp.no = "5";
			newp.fours = 0;
			newp.fives = 1;
			newp.sizxes = 0;
			one.add(newp);
		}

		// for sixes
		if (valid(0, 0, 1)) {
			BigInteger b = new BigInteger("6").mod(BMOD);
			sum = (b.intValue() % MOD + sum % MOD) % MOD;
			p newp = new p();
			newp.no = "6";
			newp.fours = 0;
			newp.fives = 0;
			newp.sizxes = 1;
			one.add(newp);
		}
				
		while(digit<=fours+fives+sixes){
			for (int i = 0; i < one.size(); i++) {
				//for fours
				if (valid(one.get(i).fours+1,one.get(i).fives,one.get(i).sizxes)){
					BigInteger b = new BigInteger("4"+one.get(i).no).mod(BMOD);
					sum = (b.intValue()%MOD+sum%MOD)%MOD;
					
					p newp = new p();
					newp.no = "4"+one.get(i).no;
					newp.fours = one.get(i).fours+1;
					newp.fives = one.get(i).fives;
					newp.sizxes = one.get(i).sizxes;
					two.add(newp);
				
				}
				//for fives
				if (valid(one.get(i).fours,one.get(i).fives+1,one.get(i).sizxes)){
					BigInteger b = new BigInteger("5"+one.get(i).no).mod(BMOD);
					sum = (b.intValue()%MOD+sum%MOD)%MOD;
					
					p newp = new p();
					newp.no = "5"+one.get(i).no;
					newp.fours = one.get(i).fours;
					newp.fives = one.get(i).fives+1;
					newp.sizxes = one.get(i).sizxes;
					two.add(newp);
				}
				// for sixes
				if (valid(one.get(i).fours,one.get(i).fives,one.get(i).sizxes+1)){
					BigInteger b = new BigInteger("6"+one.get(i).no).mod(BMOD);
					sum = (b.intValue()%MOD+sum%MOD)%MOD;
					
					p newp = new p();
					newp.no = "6"+one.get(i).no;
					newp.fours = one.get(i).fours;
					newp.fives = one.get(i).fives;
					newp.sizxes = one.get(i).sizxes+1;
					two.add(newp);
				}
			}
			digit++;
			three.addAll(one);
			one = two;
			two = new ArrayList<p>();
		}
		three.addAll(one);
		/*for (int i = 0; i < three.size(); i++) {
			System.out.print(" "+three.get(i).no);
		}*/
		System.out.println(sum);
	}
	public static boolean valid(int i4, int i5, int i6) {
		return i4 <= fours && i5 <= fives && i6 <= sixes;
	}
}
class p {
	String no;
	int fives,fours,sizxes;
}

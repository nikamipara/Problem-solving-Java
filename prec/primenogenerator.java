package prec;

import java.util.ArrayList;

public class primenogenerator {
	public static void main(String... args) {
		ArrayList<Integer> mylist = new ArrayList<Integer>();// array to store
																// prime
																// numbers. this
																// is not
																// bounded.
		mylist.add(2);
		int MAX_RANGE = 1000000000;
		int i = 3;
		int count =0;
		while (i < 100000) {
			
			boolean isDevide = false;
			for (int a = 0; a < mylist.size(); a++) {
				if (i % mylist.get(a) == 0) {// i%mylist[a]==0
					isDevide = true;
					break;
				}
			}
			if (isDevide == false) {
				mylist.add(i);
				count++;
				//System.out.println(i);
			}
			i++;
		}
		System.out.println(count);

	}

}

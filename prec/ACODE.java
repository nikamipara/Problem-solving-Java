package prec;

import java.util.Scanner;

public class ACODE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ss = new Scanner(System.in);
		while(ss.hasNext()){
			String s = ss.nextLine();
			if(s.length() <2) break;
			int l = s.length();
			l--;
			int prev=0;
			int pprev= 0;
			 if(gi(s.charAt(l))>0){
				prev = 1; pprev=1;
			}
			else {
				prev=0; pprev=1;
			}
			l--;
			while(l>=0){
				if(gi(s.charAt(l))*10+gi(s.charAt(l+1))>26){
					pprev=prev;
				}
				else{
					if (gi(s.charAt(l)) != 0) {
						int temp = prev;
						prev = prev + pprev;
						pprev = temp;
					} else {
						pprev = prev;
						prev = 0;
					}
				}l--;
			}
			System.out.println(prev);
		}
	}
	public static int gi(char s){
		return (int)s - (int)'0';
	}
	

}

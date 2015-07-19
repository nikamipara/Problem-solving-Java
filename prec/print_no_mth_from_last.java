package prec;

import java.util.Scanner;

public class print_no_mth_from_last {
static int M;
	public static void main(String...args){
	Scanner sc = new Scanner(System.in);
	M = sc.nextInt();
	sc.nextLine();
	int count = 0;
	listnode root=null,current=null;
	while(sc.hasNextLine()){
		String s = sc.nextLine();
		String[] ss = s.split(" ");
		for(String no:ss){
			int n = Integer.parseInt(no);
		if(root==null){
			root = new listnode(n);
			current = root;
			count++;
			
		}else if(count==M) {
			current.next = new listnode(n);
			current = current.next;
			root = root.next;
		}else {
			current.next = new listnode(n);
			current = current.next;
			count++;
		}}
	}
	if(count<M) System.out.println("NIL");
	else System.out.println(root.value);
}
}
class listnode{
	listnode next;
	int value;
	listnode(int value){
		this.value =value;
		next = null;
	}
}

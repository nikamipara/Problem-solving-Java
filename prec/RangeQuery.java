/*Sample Input 
 * 10 5
-8 -8 -8 4 -2 5 8 -5 1 2
2 9
8 10
1 3
3 4
6 8

sample out put 
Odd
Even
Even
Even
Even
 * */
package prec;

import java.util.Scanner;

public class RangeQuery {
public static void main(String... args){
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int  k = sc.nextInt();
	int a[][] = new int[N][N];
	for (int i = 0; i <N; i++) {
		a[i][i] = sc.nextInt();
		if(Math.abs(a[i][i])%2==0)a[i][i] =2;else a[i][i]=1;
		for(int j=i-1;j>-1;j--){
			if(a[j][i-1] == a[i][i]) {
				a[j][i] = 2;
			}
			else a[j][i] =1;
		}
	}
	/*for (int i = 0; i <N; i++) {
		for (int j = 0; j < N; j++) {
			System.out.print(a[i][j] +", ");
		}
		System.out.println();
	}*/
	for (int i = 0; i < k; i++) {
		int aa = sc.nextInt();
		int bb = sc.nextInt();
		String s = (a[aa-1][bb-1]==1)? "Odd":"Even";
		System.out.println(s);
	}
}
}

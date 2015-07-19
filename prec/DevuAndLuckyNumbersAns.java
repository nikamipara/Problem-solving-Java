package prec;

import java.util.Scanner;

public class DevuAndLuckyNumbersAns {
	static final int MOD = 1000000007;
	static int[] pow10;
	static int fours;
	static int fives;
	static int sixes;

	public static void main(String... args) {
		// System.out.println(Integer.MAX_VALUE- MOD);
		Scanner sc = new Scanner(System.in);
		fours = sc.nextInt();
		fives = sc.nextInt();
		sixes = sc.nextInt();

		pow10 = new int[fours + fives + sixes + 1];
		for (int i = 1; i < pow10.length; i++)
			pow10[i] = pow10[i - 1] * 10 % MOD;

		long[][][] count = new long[fours + 1][fives + 1][sixes + 1];
		long[][][] sum = new long[fours + 1][fives + 1][sixes + 1];
		count[0][0][0] = 1;
		sum[0][0][0] = 0;
		for (int i = 0; i <= fours; i++) {
			for (int j = 0; j <= fives; j++) {
				for (int k = 0; k <= sixes; k++) {
					if (i == 0 && j == 0 && k == 0)
						continue;
					long rs = 0, rc = 0;
					if (i > 0) {
						rs += (10 * sum[i - 1][j][k] + count[i - 1][j][k] * 4)
								% MOD;
						rc += count[i - 1][j][k];
					}
					if (j > 0) {
						rs += (10 * sum[i][j - 1][k] + count[i][j - 1][k] * 5)
								% MOD;
						rc += count[i][j - 1][k];
					}
					if (k > 0) {
						rs += (10 * sum[i][j][k - 1] + count[i][j][k - 1] * 6)
								% MOD;
						rc += count[i][j][k - 1];
					}
					rs %= MOD;
					rc %= MOD;
					sum[i][j][k] = rs;
					count[i][j][k] = rc;
				}
			}
		}
		long res = 0;
		for (int i = 0; i <= fours; i++)
			for (int j = 0; j <= fives; j++)
				for (int k = 0; k <= sixes; k++) {
					res += sum[i][j][k];
					res %= MOD;
				}
		System.out.println(res);

	}

	
}

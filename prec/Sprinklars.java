package prec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Sprinklars {
	static ArrayList<Integer> sprinklr, templist;
	static int[] allowed;
	static int noofsprinklr, potcost, rangecost;
	static int range;

	public static void main(String... args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		PrintWriter p = new PrintWriter(System.out);
		for (int i = 0; i < test_case; i++) {
			sprinklr = null;
			templist = null;
			noofsprinklr = 0;
			potcost = 0;
			rangecost = 0;
			range = 0;
			int N = sc.nextInt();
			int potplaces = sc.nextInt();
			potcost = sc.nextInt();
			rangecost = sc.nextInt();
			allowed = new int[potplaces + 1];

			for (int j = 1; j < potplaces + 1; j++) {
				allowed[j] = sc.nextInt();
			}

			// calculating the answer

			int potrange = -1;
			// this should be in loop lets see
			while (true) {
				templist = new ArrayList<Integer>();
				int nextpostiontobecoverd = 1;
				int searchfromthisindex = 1;
				potrange++;
				boolean isSolutionExists = true;
				while (nextpostiontobecoverd <= N) {
					int mynextpot = findpot(allowed, searchfromthisindex,
							nextpostiontobecoverd, potrange);
					if (mynextpot == -1) {
						// solution is not found for this pot.
						// empty the temp list.
						// System.out.println("solution not found for this case");
						isSolutionExists = false;
						break;
					} else {
						templist.add(allowed[mynextpot]);
						searchfromthisindex = mynextpot + 1;
						nextpostiontobecoverd = allowed[mynextpot] + potrange
								+ 1;
					}

				}
				if (isSolutionExists
						&& (sprinklr == null || cost(templist.size(), potrange) < cost(
								noofsprinklr, range))) {
					sprinklr = templist;
					noofsprinklr = sprinklr.size();
					range = potrange;
				}/* else if(isSolutionExists) break; */// break while loop we
														// have the optimum
														// solutuion.
				if (isSolutionExists && (templist.size() <= 1 /*
															 * ||
															 * (sprinklr!=null
															 * &&
															 * templist.size()
															 * >=sprinklr
															 * .size())
															 */))
					break;
			}
			// //////////////////////////////////////////////////

			p.println(noofsprinklr + " " + range);
			for (int a : sprinklr) {
				p.print(a + " ");
			}
			p.println();

		}
		p.close();
	}

	private static double cost(double size, double potrange) {
		return size * potcost + potrange * rangecost;
	}

	private static int findpot(int[] allowed2, int searchfromthisindex,
			int nextpostiontobecoverd, int potrange) {
		// do a binary search on an given array starting form the search index
		// given.
		int search = nextpostiontobecoverd + potrange;
		int start = searchfromthisindex;
		int end = allowed2.length - 1;
		if (start >= allowed.length || search < allowed2[start])
			return -1;
		int ans = binarysearch(allowed2, start, end, search);
		if (ans < start || ans > end) {
			// ans is not found for this perticular range sarch for the next
			// range.
			return -1;
		} else if (allowed2[ans] - nextpostiontobecoverd > potrange)
			return -1;
		return ans;

	}

	private static int binarysearch(int[] allowed2, int start, int end,
			int search) {
		if (start == end) {
			if (allowed2[start] == search)
				return start;
			else if ((allowed2[start] > search)) {
				return start - 1;
			} else
				return start;
		}
		if (start > end) {
			return end;
		}
		int middle = (start + end) / 2;
		if (allowed2[middle] == search)
			return middle;
		else if (allowed2[middle] > search)
			end = middle - 1;
		else {
			start = middle + 1;
		}
		return binarysearch(allowed2, start, end, search);
	}
}

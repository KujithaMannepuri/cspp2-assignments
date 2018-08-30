
import java.util.*;
public class Solution {/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args) {
		System.out.println("Enter size of the array:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ary[];
		int max = 0;
		ary = new int[n];
		System.out.println("please enter elements of array:");
		for (int i = 0; i < n; i++) {
			ary[i] = sc.nextInt();
		}
		max = ary[0];
		for (int i = 0; i < n; i++) {
			if (max < ary[i]) {
				max = ary[i];
			}
		}
		System.out.println(max);
	}
}

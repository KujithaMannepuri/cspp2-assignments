
// Given an String, Write a java method that returns the decimal
// value for the given binary string.
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {/*
	Do not modify this main function.
	*/
	/**
	 * Constructor.
	 */
	private Solution() { }
	/**
	 * function_description.
	 *
	 * @param args The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		//sc.nextLine();
		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			String res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
		static String binaryToDecimal(String s) {
			int val = 0;
			int base = 1;
			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == '1')
					val = val + base;
				base = base * 2;
			}
			return val+"";
		}
}

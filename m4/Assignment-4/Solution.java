
// Given an String, Write a java method that returns the decimal
// value for the given binary string.
import java.util.Scanner;
public class Solution {/*
	Do not modify the main function 
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverseString(s);	
		System.out.println(reverse);
	}
	//Write reverseString function
	static String reverseString(String s) {
		String rev = "";
		// char[] s1 = input.toCharArray();
		// for (int i = s1.length()-1; i>=0; i--);
		for (int i = 0; i < s.length(); i++) {
			rev = s.charAt(i) + rev;
		}
			// rev = rev + s1.charAt(i);
		return rev;
	}
}

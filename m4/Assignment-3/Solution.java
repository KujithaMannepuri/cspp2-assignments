
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.*;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		//sc.nextLine();
		for(int i=0;i<=n;i++){
			String s=sc.nextLine();
			// String res=binaryToDecimal(s);//Write binaryToDecimal function
			// System.out.println(res);
			System.out.println(binaryToDecimal(s));
		}
	}
		static int binaryToDecimal(String s){
			int val = 0;
			int base = 1;
			for (int i=s.length()-1;i>=0;i--){
				if (s.charAt(i) == '1')
					val = val+base;
				base = base*2;
			}
			return val;
		}
}

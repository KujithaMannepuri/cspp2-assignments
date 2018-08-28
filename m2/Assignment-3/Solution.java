import java.util.Scanner;

/**
 * Class for solution.
 */
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result=power(base, exponent);
        System.out.println(result);
	}
	/*
	Need to write the power function and print the output.
	*/
	static long power(int b, int e){
		if (e != 0){
			return (b*(power(b, e-1)));
		}
		else return 1;
	}
}


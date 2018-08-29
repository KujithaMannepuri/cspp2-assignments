
import java.util.Scanner;
/*
 Do not modify this main function.
*/
public class Solution {
    /**
     * { var_description }
     */
    private static int gcd = 1;
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1, n2);

    }
    /*
	Need to write the gcd function and print the output.
	*/
    static void gcd(int n1, int n2) {
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        System.out.println(gcd);
    }
}

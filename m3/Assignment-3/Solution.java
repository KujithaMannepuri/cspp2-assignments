
import java.util.Scanner;
/*
 Do not modify this main function.
*/
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * { var_description }
     */
    private Solution() {
        //constructor
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcd(n1, n2);
        System.out.println(gcd);
    }
    /*
    Need to write the gcd function and print the output.
    */
    /**
     * gcd function.
     *
     * @param n1 number n1
     * @param n2 number n2
     *
     * @return return value.
     */
    static int gcd(final int n1, final int n2) {
        int temp = 0;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                temp = i;
            }
        }
        return temp;
    }
}





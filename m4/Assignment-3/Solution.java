
// Given an String, Write a java method that returns the decimal
// value for the given binary string.
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution { /*
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
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        //sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }

        /**
         * binary to decimal function.
         *
         * @param s { parameter_description }
         *
         * @return { description_of_the_return_value }
         */
        static String binaryToDecimal(final String s) {
            int val = 0;
            int base = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '1') {
                    val = val + base;
                }
                base = base * 2;
            }
            return val + "";
        }
}

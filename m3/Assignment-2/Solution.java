
import java.util.Scanner;
/*
    Do not modify this main function.
    */
/**
 * Main class.
 */
public final class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    /**.
     *  variable description 
     */
    private Solution() {
        //constructor
    }
    /**.
     * { function_description }
     *
     * @param args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int j = 1;
        int count = 0;
        final int ten = 10;
        final int seven = 7;
        for (int i = 1; i <= n; i++) {
            j = i;
            while (j != 0) {
                if (j % ten == seven) {
                    count++;
                }
                j = j / ten;
            }
        }
        System.out.println(count);
    }
}
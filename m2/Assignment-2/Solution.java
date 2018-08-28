/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
    constructor.
    */
    private Solution() { }
    /**.
    Do not modify this main function.
    @param args parameter
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        roots(a, b, c);
    }
    /**.
    Need to write the rootsOfQuadraticEquation
    function and print the output.
    @param a { parameter_description }
    @param b { parameter_description }
    @param c { parameter_description }
    */
    static void roots(final int a, final int b, final int c) {
        double root1;
        double root2;
        final int f = 4;
        double det = b * b - f * a * c;
        root1 = (-b + Math.sqrt(det)) / (2 * a);
        root2 = (-b - Math.sqrt(det)) / (2 * a);
        System.out.println(root1 + " " + root2);
    }
}


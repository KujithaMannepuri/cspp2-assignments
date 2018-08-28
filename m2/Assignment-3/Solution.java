import java.util.Scanner;

/**
 * Class for solution.
 */
public class Solution {
    /**
    Do not modify this main function.
    @param args The arguments
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    Need to write the power function and print the output.
    @param b { parameter_description }
    @param e { parameter_description }
    @return     { description_of_the_return_value }
    */
    static long power(int b, int e) {
        if (e != 0){
            return (b * (power(b, e - 1)));
        } else{
            return 1;
        }
    }
}


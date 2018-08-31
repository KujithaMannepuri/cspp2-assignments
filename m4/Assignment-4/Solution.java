
// Given an String, Write a java method that returns the reverse of given string.
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution { /*
    Do not modify the main function. 
    */
    /**
     * main function
     *
     * @param args The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);  
        System.out.println(reverse);
    }
    //Write reverseString function

    /**
     * function of reverse string.
     *
     * @param s { parameter_description }
     *
     * @return description_of_the_return_value.
     */
    static String reverseString(final String s) {
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

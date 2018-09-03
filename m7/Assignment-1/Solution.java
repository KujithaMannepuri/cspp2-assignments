import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    /**
     * { var_description. }
     */
    private String input;
    /**
     * constructor.
     *
     * @param      str   The string
     */
    InputValidator(final String str) {
        this.input = str;
    }
    /**
     * to validate the data.
     *
     * @return     { returns boolean value true or false }
     */
    boolean validateData() {
        int length1 = input.length();
        final int length2 = 6;
        if (length1 >= length2) {
            return true;
        }
        return false;
    }
}
/**
 * { class for solution. }
 */
class Solution {
/**
 * { main function. }
 *
 * @param args  The arguments
 */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}

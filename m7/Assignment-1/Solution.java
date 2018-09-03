import java.util.Scanner;
class InputValidator
{
	/*Write the atrributes and methods for InputValidator*/
	private String input;
	InputValidator(final String str) {
		this.input = str;
	}
	boolean validateData() {
		int length1 = input.length();
		final int length2 = 6;
		if (length1 >= length2)
			return true;
		return false;
	}
}
public final class Solution
{
	public static void main(String[] args)
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}

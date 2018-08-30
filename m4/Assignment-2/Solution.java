import java.util.Scanner;

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * constructor.
     */
    private Solution() {
    }
    /* Fill the main function to print resultant of addition of matrices*/
    /**
     * main function.
     *
     * @param args The argument
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        int[][] add = new int[row1][col1];
        int[][] mat1 = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
        int row2 = sc.nextInt();
        int col2 = sc.nextInt();
        int[][] mat2 = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        if (row1 == row2 && col1 == col2) {
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    add[i][j] = mat1[i][j] + mat2[i][j];
                    System.out.print(add[i][j]);
                    if (j < col1 - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("not possible");
        }
    }
}

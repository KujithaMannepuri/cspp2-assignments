import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
/**
 * Class for bag of words.
 */
class BagOfWords {
    /**
     * constructor.
     */
    protected BagOfWords() {
    }
    /**
     * Returns a string representation of the object.
     *
     * @param      filename  The filename
     *
     * @return     String representation of the object.
     */
    public static String toString(final File filename) {
        String str = "";
        try {
            Scanner sc = new Scanner(new FileReader(filename));
            StringBuilder s = new StringBuilder();
            while (sc.hasNext()) {
                s.append(sc.next());
                s.append(" ");
            }
            sc.close();
            str = s.toString();
        } catch (Exception e) {
            System.out.println("no file");
        }
        return str;
    }
    /**
     * similar string function.
     *
     * @param      str1  The string 1
     * @param      str2  The string 2
     *
     * @return     { description_of_the_return_value }
     */
    public static double
similarString(final String str1, final String str2) {
        int rows = str1.length();
        int cols = str2.length();
        final int h = 100;
        final double h2 = 100d;
        double strLen = rows + cols;
        int[][] max = new int[rows + 1][cols + 1];
        int res = 0;
        double similarity = 0;
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                if (i == 0 || j == 0) {
                    max[i][j] = 0;
} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    max[i][j] = max[i - 1][j - 1] + 1;
                } else {
                    max[i][j] = 0;
                }
                if (res < max[i][j]) {
                    res = max[i][j];
                }
            }
        }
    similarity = Math.round(((res * 2) / strLen) * h2) / h2;
        return (similarity * h);
        }
        /**
         * Removes all.
         *
         * @param      text  The text
         *
         * @return     { description_of_the_return_value }
         */
    public static Map removeAll(final String text) {
        String[] words = text.replaceAll("[^a-zA-Z. ]", "")
        .toLowerCase().split(" ");
        Map<String, Integer> hmap = new HashMap<>();
        int freq = 0;
        for (int i = 0; i < words.length; i++) {
            if (!hmap.containsKey(words[i])) {
                hmap.put(words[i], 1);
            } else {
                hmap.put(words[i], hmap.get(words[i]) + 1);
            }
        }
        return hmap;
    }
}

/**
 * Class for solution.
 */
final class Solution {
    /**
     * constructor.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param  args  The arguments
     */
    public static void main(final String[] args) {
        final int h1 = 100;
        try {
        BagOfWords f = new BagOfWords();
        Scanner sc = new Scanner(System.in);
        File ip = new File(sc.next());
        File[] listOfFiles = ip.listFiles();
        double max = 0;
        String res1 = "";
        int length = listOfFiles.length;
        double[][] res = new double[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    res[i][j] = h1;
                } else {
res[i][j] = BagOfWords.similarString(BagOfWords.toString(listOfFiles[i]),
                    BagOfWords.toString(listOfFiles[j]));
                if (max < res[i][j]) {
                    max = res[i][j];
            res1 = "Maximum similarity is in between "
+ listOfFiles[i].getName() + " and " + listOfFiles[j].getName();
                }
            }
            }
        }
        System.out.print("\t");
        for (int i = 0; i < length; i++) {
            System.out.print("\t" + listOfFiles[i].getName());
        }
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(listOfFiles[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                System.out.print(res[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println(res1);

    } catch (Exception e) {
        System.out.println("Empty Directory");
    }
    }
}

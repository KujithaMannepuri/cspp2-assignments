import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
/**
 * Class for bag of words.
 */
class bagofwords {
/**
 * constructor.
 */
    protected bagofwords() {
    }
    /**
     * Removes all.
     *
     * @param text  The text
     *
     * @return return hashmap.
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
    /**
     * similarity function.
     *
     * @param      file1  The file 1
     * @param      file2  The file 2
     *
     * @return     { description_of_the_return_value }
     */
    public static int similarity(final String file1, final String file2) {
        double nmrtr = 0;
        double sum1 = 0;
        double sum2 = 0;
        final int h = 100;
        final double h2 = 100D;
        Map<String, Integer> hmap1 = removeAll(file1);
        Map<String, Integer> hmap2 = removeAll(file2);
        for (String ind1:hmap1.keySet()) {
            for (String ind2:hmap2.keySet()) {
                if (ind1.equals(ind2)) {
    nmrtr += hmap1.get(ind1) * hmap2.get(ind2);
                }
            }
        }
        for (String ind1:hmap1.keySet()) {
            sum1 += Math.pow(hmap1.get(ind1), 2);
        }
        for (String ind2:hmap2.keySet()) {
            sum2 += Math.pow(hmap2.get(ind2), 2);
        }
        double denominator = Math.sqrt(sum1) * Math.sqrt(sum2);
        return (int) ((((nmrtr / denominator) * h2) / h2) * h);
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
        final int hundered = 100;
        try {
        bagofwords f = new bagofwords();
        Scanner sc = new Scanner(System.in);
        File ip = new File(sc.next());
        File[] listOfFiles = ip.listFiles();
        int max = 0;
        String res1 = "";
        int length = listOfFiles.length;
        int[][] res = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    res[i][j] = hundered;
                } else {
res[i][j] = bagofwords.similarity(bagofwords.toString(listOfFiles[i]),
                    bagofwords.toString(listOfFiles[j]));
                if (max < res[i][j]) {
                    max = res[i][j];
    res1 = "Maximum similarity is in between "
        + listOfFiles[i].getName() + " and " + listOfFiles[j].getName();
                }
            }
            }
        }
        System.out.print("      \t");
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
        System.out.println("empty directory");
    }
    }
}
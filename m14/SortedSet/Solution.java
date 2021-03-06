import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**
     * sortedset array.
     */
    private int[] sortedset;
    /**
     * size.
     */
    private int size;
    /**
     * constructor.
     */
     SortedSet() {
        final int ten = 10;
        sortedset = new int[ten];
        size = 0;
    }
    @Override

    /**
     * boolean function.
     *
     * @param      item  The item
     *
     * @return     returns true if the item is in set.
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return    returns first match.
     */
    @Override
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (sortedset[i] == item) {
                return i;
            }
        }
        return -1;
    }

    /**
     * add function.
     *
     * @param      item  The item
     */
    @Override
    public void add(final int item) {
        int temp = 0;
        if (size == 0) {
            sortedset[size++] = item;
        } else {
                if (!contains(item)) {
                    sortedset[size++] = item;
                }
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (sortedset[i] > sortedset[j]) {
                        temp = sortedset[i];
                        sortedset[i] = sortedset[j];
                        sortedset[j] = temp;
                    }
                }
                }
            }
        }


    /**
     * subset function.
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return    returns subset.
     */
    public Set subSet(final int start, final int end) {
        Set s = new Set();
        if (start <= end) {
            Set s2 = new Set();
            s2 = headSet(end);
            for (int i = 0; i < s2.size(); i++) {
                if (sortedset[i] >= start) {
                    s.add(sortedset[i]);
                }
            }
            return s;
        }
        System.out.println("Invalid Arguments to Subset Exception");
        return null;
     }

     /**
      * headset function.
      *
      * @param      item  The item
      *
      * @return    returning a set.
      */
     public Set headSet(final int item) {
        Set set1 = new Set();
        for (int i = 0; i < size; i++) {
            if (sortedset[i] < item) {
                set1.add(sortedset[i]);
            }
        }
        return set1;
     }


     /**
      * function last.
      *
      * @return    returns last digit in set.
      */
     public int last() {
        if (size > 0) {
            return sortedset[size - 1];
        }
        System.out.println("Set Empty Exception");
        return -1;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(sortedset[i] + ", ");
        }
        sb.append(sortedset[size - 1] + "}");
        return sb.toString();
    }

}
/**
 * { item_description }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param s { string input from test case file }
     *
     * @return { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        //Set s = new Set();
        SortedSet s = new SortedSet();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                    s.add(Integer.parseInt(tokens[1]));
                break;
                case "addAll":
                    String[] arr = tokens[1].split(",");
                    int[] arr1 = new int[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        arr1[i] = Integer.parseInt(arr[i]);
                    }
                    s.addAll(arr1);
                break;
                // case "intersection":
                // s = new SortedSet();
                // SortedSet t = new SortedSet();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
                // System.out.println(s.intersection(t));
                // break;
                // case "retainAll":
                // s = new SortedSet();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // System.out.println(s.retainAll(intArray));
                // break;
                // case "cartesianProduct":
                // s = new SortedSet();
                // t = new SortedSet();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
   // System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                // break;
                case "subSet":
                String[] values = tokens[1].split(",");
                if (s.subSet(Integer.parseInt(values[0]), Integer.parseInt(
                    values[1])) != null) {
                    System.out.println(s.subSet(Integer.parseInt(values[0]),
                        Integer.parseInt(values[1])));
                }
                break;
                case "headSet":
                int headvalue = Integer.parseInt(tokens[1]);
                System.out.println(s.headSet(headvalue));
                break;
                case "last":
                    System.out.println(s.last());
                break;
                default:
                break;
            }
        }
    }
}

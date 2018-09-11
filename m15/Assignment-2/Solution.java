import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Exception for signaling invalid subset selection errors.
 */
class InvalidSubsetSelectionException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     **/
    InvalidSubsetSelectionException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s     { parameter_description }
     **/
    SetEmptyException(final String s) {
        super(s);
    }
}

/**
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**
     * { function_description }.
     *
     * @param      arr   The arr
     */
    public void sort(final int[] arr) {
        int res;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    res = arr[i];
                    arr[i] = arr[j];
                    arr[j] = res;
                }
            }
        }
    }
    /**
     * add method.
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            set[size++] = item;
        }
        sort(set);
    }
    /**
     * { function_description }.
     *
     * @param      start  The from element
     * @param      end    To element
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception    { exception_description }
     */
    public int[] subSet(final int start, final int end) {
        try {
            if (start > end) {
                throw new InvalidSubsetSelectionException("");
            // return null;
            }
            int[] res = new int[size];
            int temp = 0;
            for (int i = 0; i < size; i++) {
                if (set[i] >= start) {
                    for (int j = i; j < size; j++) {
                        if (set[j] < end) {
                            res[temp++] = set[i];
                        }
                        break;
                    }
                }
            }
            return Arrays.copyOf(res, temp);
        } catch (InvalidSubsetSelectionException is) {
            System.out.println("Invalid Arguments to Subset Exception");
        }
        return null;
    }

    /**
     * { function_description }.
     *
     * @param      toEle  To ele
     *
     * @return     { description_of_the_return_value }
     */
    public int[] headSet(final int toEle) {
        try {
           int[] temp = new int[size];
            int result1 = 0;
            for (int i = 0; i < size; i++) {
                if (set[i] < toEle) {
                    temp[i] = set[i];
                    result1++;
                }
            }
            if (result1 != 0) {
                // throw new SetEmptyException("");
                return Arrays.copyOf(temp, result1);
            } else {
                throw new SetEmptyException("");
            }
        } catch (SetEmptyException se) {
            System.out.println("Set Empty Exception");
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int last() throws SetEmptyException {
        if (size == 0) {
            throw new SetEmptyException("Set Empty Exception");
            // return -1;
        } else {
            return set[size - 1];
        }
    }
    /**
     * Adds all.
     * @param      ele   The ele
     */
    public void addAll(final int[] ele) {
        for (int i : ele) {
            add(i);
        }
    }
}
/**
 * Solution class.
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
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
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
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new SortedSet();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new SortedSet();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
            case "subSet":
            if (tokens.length != 2) {
                break;
            }
            String[] arrstring3 = tokens[1].split(",");
            int[] object = s.subSet(Integer.parseInt(arrstring3[0]),
                    Integer.parseInt(arrstring3[1]));
            if (object != null) {
                System.out.println(Arrays.toString(object).replace("[",
                    "{").replace("]", "}"));
            }
            break;
            case "headSet":
            if (tokens.length != 2) {
                break;
            }
            int[] obj = s.headSet(Integer.parseInt(tokens[1]));
            if (obj != null) {
                System.out.println(Arrays.toString(obj).replace("[",
                    "{").replace("]", "}"));
            }
            break;
            case "last":
            try {
                if (tokens.length != 1) {
                    break;
                }
                int temp = s.last();
                System.out.println(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            case "addAll":
                int[] intArr = intArray(tokens[1]);
                if (intArr.length == 1) {
                    s.add(intArr[0]);
                } else {
                    s.add(intArr);
                }
                break;
            default:
                break;
            }
        }
    }
}

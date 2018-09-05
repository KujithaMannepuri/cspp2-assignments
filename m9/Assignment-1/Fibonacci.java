import java.util.Scanner;

/*
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */

/**
 * Class for fibonacci.
 */
public class Fibonacci {
    /*
     * fib is a static method takes a argument n
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     *
     * Look for the hint.txt if some of the testcases fail.
     */
    
    /**
     * fibonacci constructor.
     */
    public Fibonacci() {

    }
    /**
     * fibonocci function.
     *
     * @param n number of fibonocci series.
     *
     * @return    returns the list.
     */
    public static List fib(final int n) {
        // todo - complete this method
        int n1 = 0, n2 = 1, fibo = 0;
        List arr = new List();
        arr.List(n);
            arr.add(n1);
            arr.add(n2);
            for (int i = 2; i < n; i++) {
                fibo = n1 + n2;
                // fibo = arr.get(i-1)+ arr.get(i-2);
                n1 = n2;
                n2 = fibo;
                arr.add(fibo);
            }
        return arr;
    }

    /**
     * main function.
     *
     * @param args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }
}
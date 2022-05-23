/*
 ******************************************************************************
 *                                                                            *
 * S.A. WORLDLINE N.V. - All rights reserved.                                 *
 *                                                                            *
 ******************************************************************************
 * The information contained in this document is subject to change without    *
 * notice and should not be construed as a commitment by WORLDLINE.           *
 *                                                                            *
 * WORLDLINE assumes no responsibility for any errors or omissions that may   *
 * appear in this document.                                                   *
 *                                                                            *
 * The contents of this document must not be reproduced in any form           *
 * whatsoever, by or on behalf of third parties, without the prior written    *
 * consent of WORLDLINE.                                                      *
 ******************************************************************************
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * @author Wallace ESPINDOLA (wes)
 * @since 24/05/2022
 */
public class GenerateBinaryNumbers {

    public static void main(String args[]) {

        int n = 10;
        System.out.println("generateBinaryNumbers n=" + n);
        generateBinaryNumbers(n);

        n = 7;
        System.out.println("generatePrintBinary n=" + n);
        generatePrintBinary(n);

        n = 7;
        System.out.println("convertToBinaryNumber n=" + n);
        convertToBinaryNumber(n);

        n = 13;
        System.out.println("convertToBinaryNumberWithStream n=" + n);
        convertToBinaryNumberWithStream(n);
    }

    static void generateBinaryNumbers(int n) {
        if (n == 0) { //returns 0 if n=0
            return;
        }

        //creating a Queue of type String
        Queue<String> que = new LinkedList<>();

        //adding the root element to the queue which is the first binary number
        que.add("1");

        int total = 0;

        //check if the total is less than n
        while (total < n) {
            //remove an element from the Queue and print it
            String curr = que.poll();
            System.out.print(curr + " ");

            //appending 0 and 1 in the left and right child respectively
            que.add(curr + "0");
            que.add(curr + "1");

            total++;
        }
        System.out.println();
        System.out.println();
    }

    // This function uses queue data structure to print binary numbers
    static void generatePrintBinary(int n) {
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<>();

        // Enqueue the first binary number
        q.add("1");

        // This loops is like BFS of a tree with 1 as root
        // 0 as left child and 1 as right child and so on
        while (n-- > 0) {
            // print the front of queue
            String val = q.peek();
            q.remove();
            System.out.println("val=" + val + " -> q=" + q);

            // Append "0" to val and enqueue it
            q.add(val + "0");

            // Append "1" to val and enqueue it. Note that s2
            // contains the previous front
            q.add(val + "1");
        }
        System.out.println();
    }

    static void convertToBinaryNumber(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(Integer.toBinaryString(i));
        }
        System.out.println();
    }

    static void convertToBinaryNumberWithStream(int n) {
        IntStream.range(0, n).mapToObj(Integer::toBinaryString).map(s -> padWithLeftZeros(s, n)).forEach(System.out::println);
    }

    private static Object padWithLeftZeros(String s, int val) {
        // 2^n = x ==> n = log(x)/log(2)
       Double d = Math.ceil(Math.log(val) / Math.log(2));
       int n = d.intValue();
        //System.out.println(d + ", " + n);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < n - s.length(); i++) {
            sb.append("0");
        }
        return sb.append(s).toString();
    }
}

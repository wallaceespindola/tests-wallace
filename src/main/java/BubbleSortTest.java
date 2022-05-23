/*
 ******************************************************************************
 *                                                                            *
 * S.A. WORLDLINE N.V.-All rights reserved.                                 *
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

import java.util.Arrays;

/**
 * @author Wallace ESPINDOLA (wes)
 * @since 23/05/2022
 */
public class BubbleSortTest {

    public static void main(String args[]) {

        int[] array = {10, 5, 3, 1, 24, 12};
        int len = array.length;

        System.out.println("Unsorted: " + Arrays.toString(array) + " -> n=" + array.length);

        bubbleSort(array);

        System.out.println("_Sorted_: " + Arrays.toString(array) + " -> n=" + array.length);
    }

    private static void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i=0; i < (n-1); i++) {
            for (int j=0; j < (n-i)-1; j++) {

                System.out.println("n(i,j)=("+i+","+j+") ==> arr[j]="+arr[j]+" > arr[j+1]="+arr[j+1]+" -> swap="+((arr[j] > arr[j+1]) ? true : false));

                if (arr[j] > arr[j+1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

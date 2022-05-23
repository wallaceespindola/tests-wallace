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
public class SumOsMatrixRowColumTest {

    public static void main(String args[]) {

        //Initialize matrix
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Matrix -> lines=" + matrix.length + ", cols=" + matrix[0].length);

        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);

        sumOfMatrixElements(matrix);
    }

    private static void sumOfMatrixElements(int[][] a) {

        int rows, cols, sumRow, sumAllRow, sumCol, sumAllCol, sum;

        //Calculates number of rows and columns present in given matrix
        rows = a.length;
        cols = a[0].length;

        //Calculates sum of each row of a given matrix
        sumAllRow = 0;
        for (int i = 0; i < rows; i++) {
            sumRow = 0;
            for (int j = 0; j < cols; j++) {
                sumRow = sumRow + a[i][j];
            }
            System.out.println("Sum of row " + (i + 1) + ": " + sumRow);
            sumAllRow += sumRow;
        }
        System.out.println("==> Sum of all rows : " + sumAllRow);

        //Calculates sum of each column of a given matrix
        sumAllCol = 0;
        for (int i = 0; i < cols; i++) {
            sumCol = 0;
            for (int j = 0; j < rows; j++) {
                sumCol = sumCol + a[j][i];
            }
            System.out.println("Sum of column " + (i + 1) + ": " + sumCol);
            sumAllCol += sumCol;
        }
        System.out.println("==> Sum of all columns : " + sumAllCol);

        //Calculates sum of all elements of a given matrix
        sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum = sum + a[i][j];
            }
        }
        System.out.println("## Sum of all elements of the matrix = " + sum);
    }
}

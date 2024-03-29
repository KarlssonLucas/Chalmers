package exercises;

import java.util.Arrays;

import static java.lang.StrictMath.round;
import static java.lang.System.out;
import static java.lang.System.setOut;

/*
 * Methods with array/matrix params and/or return value. Implement methods.
 *
 * See:
 * - Matrices
 */
public class Ex3MatrixMethods {

    public static void main(String[] args) {
        new Ex3MatrixMethods ().program ();
    }

    void program() {
        int[][] m = {           // Hard coded test data
                {-1, 0, -5, 3},
                {6, 7, -2, 0},
                {9, -2, -6, 8},
                {0, 0, 5, -6}
        };

        // TODO uncomment one at a time and implement

        // Return array with all negatives in m
        int[] negs = getNegatives (m);
        out.println (Arrays.toString (negs));
        out.println (negs.length == 6);
        out.println (Arrays.toString (negs).equals ("[-1, -5, -2, -2, -6, -6]")); // Possibly other ordering!

        // Mark all negatives with a 1, others as 0
        // (create matrix on the fly)
        int[][] marked = markNegatives (new int[][]{
                {1, -2, 3,},
                {-4, 5, -6,},
                {7, -8, 9,},
        });
        /* marked should be (don't uncomment)
        { {0, 1, 0},
          {1, 0, 1},
          {0, 1, 0} }
        */
        out.println (Arrays.toString (marked[0]).equals ("[0, 1, 0]"));
        out.println (Arrays.toString (marked[1]).equals ("[1, 0, 1]"));
        out.println (Arrays.toString (marked[2]).equals ("[0, 1, 0]"));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Create matrix from array
        int[][] matrix = toMatrix (arr);


        /* matrix should be (don't uncomment)
        { {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9} }
        */
        // plot(matrix);  // If manual inspection
        out.println (Arrays.toString (matrix[0]).equals ("[1, 2, 3]"));
        out.println (Arrays.toString (matrix[1]).equals ("[4, 5, 6]"));
        out.println (Arrays.toString (matrix[2]).equals ("[7, 8, 9]"));
        // Sum of all directly surrounding elements to some element in matrix
        // (not counting the element itself)
        // NOTE: Should be possible to expand method to include more distant neighbours
        out.println (sumNeighbours (matrix, 0, 0) == 11);
        out.println (sumNeighbours (matrix, 1, 1) == 40);
        out.println (sumNeighbours (matrix, 1, 0) == 23);
    }

    private int sumNeighbours(int[][] matrix, int i, int i1) {
        int sum = 0;
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (i + dy < 0 || i1 + dx < 0) {
                    continue;
                } else if (dy == 0 && dx == 0) {
                    continue;
                }
                sum += matrix[i + dy][i1 + dx];
            }
        }
        return sum;
    }

    private int[][] toMatrix(int[] arr) {
        int n = 0;
        int[][] r = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                r[i][k] = arr[n];
                n++;
            }
        }
        return r;
    }

    private int[][] markNegatives(int[][] arr) {
        int[][] r = new int[3][3];
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (arr[i][k] < 0) {
                    r[i][k] = 1;
                    n++;
                } else {
                    r[i][k] = 0;
                    n++;
                }
            }
        }
        return r;
    }

    // -------- Write methods below this -----------------------

    int[] getNegatives(int[][] arr) {
        int[] r = new int[6];
        int n = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                if (arr[i][k] < 0) {
                    r[n] = arr[i][k];
                    n++;
                }
            }
        }
        return r;
    }

    // Use if you like (during development)
    void plot(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println (Arrays.toString (matrix[row]));
        }
    }


}

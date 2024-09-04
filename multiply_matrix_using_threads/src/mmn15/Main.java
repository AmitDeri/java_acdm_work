// Author: Amit Deri ID: 316443548

package mmn15;

public class Main {

	
	// The main function 
    public static void main(String[] args) {
        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrixB = {
                {7, 8, 6},
                {9, 10, 3},
                {2, 5, 8}
        };

        int[][] result = MultiplyMatrixs.multiplyMatrices(matrixA, matrixB);

        // Print the result matrix
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
	
}

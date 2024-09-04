// Author: Amit Deri ID: 316443548

package mmn15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiplyMatrixs {
	public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
	    int n = matrixA.length;
	    int p = matrixB.length;
	    int m = matrixB[0].length;

	    int[][] result = new int[n][m];
	    Monitor monitor = new Monitor(n * m);

	    ExecutorService executor = Executors.newFixedThreadPool(n); // Creating a new executor

	    // Calculating the values of each slot in the result matrix 
	    // and after that send the information of the result and the indexes
	    // to the monitor print method that will manage the printing at the right time
	    for (int i = 0; i < n; i++) {
	        final int row = i;
	        executor.execute(() -> {
	            for (int j = 0; j < m; j++) {
	                for (int k = 0; k < p; k++) { 
	                    result[row][j] += matrixA[row][k] * matrixB[k][j];
	                }
	                monitor.printResult(row, j, result[row][j], m);
	            }
	        });
	    }

	    executor.shutdown();
	    
	    // Ensure that the main thread that prints the result matrix 
	    // will not occur before all the thread of calculating all the 
	    // values of the matrix have been ended
	    try {
	        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    return result;
	}


    static class Monitor {
        private int totalSlots;
        private int currentSlot;

        public Monitor(int totalSlots) {
            this.totalSlots = totalSlots;
            this.currentSlot = 0;
        }

        // In this method we are using synchronized so only one thread can be 
        // executed and in the method itself we first check if the currentSlot 
        // is equal to the right slot and if so we are printing else we are getting
        // inside the while which "wait" for the right thread with the notify/ All methods
        public synchronized void printResult(int row, int col, int value, int numCols) {
            while (currentSlot != row * numCols + col ) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Calculated slot: (" + row + ", " + col + ") = " + value);

            currentSlot++;
            
            
            // This condition will wake all the threads that have been 
            // waiting since they were not the slot and other wise 
            // we are checking for the right slot by using notify
            if (this.currentSlot == totalSlots) {
                notifyAll(); // Notify all waiting threads to exit
            } else {
                notify(); // Notify the next waiting thread
            }
        }


    }
}

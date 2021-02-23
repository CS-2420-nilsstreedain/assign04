package assign04;

//import java.util.ArrayList;
import java.util.Random;

public class LargestNumberSolverTimer {

	public static void main(String[] args) {
		Random randomNumberGenerator = new Random();

		// Do 10000 lookups and use the average running time
		int timesToLoop = 1000;
//		ArrayList<Integer[]> list = new ArrayList<>();
		// For each problem size n . . .
		for (int n = 100; n <= 1000; n += 100) {

			// Generate an array of n uNIDs
			int[] qNum = new int[n];
			for (int i = 0; i < n; i++)
				qNum[i] = i;

			// Randomly shuffle the array
			for (int i = 0; i < n; i++) {
				int randomIndex = randomNumberGenerator.nextInt(n);
				int temp = qNum[i];
				qNum[i] = qNum[randomIndex];
				qNum[randomIndex] = temp;
			}

			// Generate a new "random" array of n elements
			Integer[] randomArray = new Integer[n];

			// For 4-5
			for (int i = 0; i < n; i++)
				randomArray[i] = (qNum[i]);

			// For 6
			/*
			 * for (int j = 0; j < n; j++) { for (int i = 0; i < n; i++) { randomArray[i] =
			 * (qNum[i]); } list.add(randomArray); }
			 */
			long startTime, midpointTime = 0, stopTime;

			// First, spin computing stuff until one second has gone by
			// This allows this thread to stabilize
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Now, run the test
			startTime = System.nanoTime();
//			int insert = -1;
			for (int i = 0; i < timesToLoop; i++) {
				// First (and second, but using java's sort method for #5
				LargestNumberSolver.findLargestNumber(randomArray);
				// Third
				//LargestNumberSolver.findKthLargest(list, i);
			}
			midpointTime = System.nanoTime();

			// Run a loop to capture the cost of running the "timesToLoop" loop
			for (int i = 0; i < timesToLoop; i++) { // empty block
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups
			// Average it over the number of runs
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;

			System.out.println(n + "\t" + averageTime);
		}
	}
}

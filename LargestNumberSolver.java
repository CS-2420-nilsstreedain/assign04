package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import assign02.CS2420Student;


/*
* A priority queue that supports access of the minimum element only.
* 
* @author Kyle Williams and Nils Streedain
* 
* @version February 16, 2021
*/

public class LargestNumberSolver {
	
	/*
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object. 
	 * @Param <T> - the type of elements contained in this priority queue
	 * @Param arr - the array of elements to search through
	 * @Param cmp - the comparator
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		for (int i = 1; i < arr.length; i++) {
			T val = arr[i];
			int j;
			for (j = i - 1; j >=0 && (cmp.compare(arr[j],val) < 0); j--)
				arr[j+1] = arr[j];
			arr[j + 1] = val;
		}
	}

	/*
	 * This method returns the largest number that can be formed by arranging the
	 * integers of the given array, in any order. If the array is empty, the largest
	 * number that can be formed is 0. This method must not alter the given array
	 * and must call your insertionSort method with a Comparator or lambda
	 * expression that you design.
	 * 
	 * @Param arr - an array of Integers
	 * 
	 * @Return the largest number in the provided array
	 */
	public static BigInteger findLargestNumber(Integer[] arr) {
		// Checks if arr has a length of zero
		if (arr.length == 0)
			return new BigInteger("0");

		// Copies arr to newArr
		Integer[] newArr = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
			newArr[i] = arr[i];
		
		// Sorts newArr with OrderByConcat
		insertionSort(newArr, new OrderByConcat());

		// Concatenates each element of newArr
		String concatenate = "";
		for (int i = 0; i < newArr.length; i++)
			concatenate += newArr[i];
		
		// Returns concatenated String as a BigInteger
		return new BigInteger(concatenate);
		
			
		//largeNumber = BigInteger.valueOf(Integer.valueOf(concatenate));
	}

	/*
	 * This method returns the largest int value that can be formed by arranging the
	 * integers of the given array, in any order. An OutOfRangeException is thrown
	 * if the largest number that can be formed is too large for the int data type.
	 * Logic for solving the problem of determining the largest number should not
	 * appear again in this method — call an existing public method or a helper
	 * method. This method must not alter the given array.
	 * 
	 * @Param arr - an array of Integers
	 * 
	 * @Throws OutOfRangeException if largest number is too large for int
	 * 
	 * @Return largest number in data type int
	 */
	public static int findLargestInt(Integer[] arr) throws OutOfRangeException {
		BigInteger number = findLargestNumber(arr);
		if ((number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))) > 0) {
			new OutOfRangeException("Number larger than maximum int size");
		}
		return number.intValueExact();
	}

	/*
	 * This method behaves the same as the previous method, but for data type long
	 * instead of data type int.
	 * 
	 * @Param arr - an array of Integers
	 * 
	 * @Throws OutOfRangeException if
	 * 
	 * @Return largest number in data type long
	 */
	public static long findLargestLong(Integer[] arr) throws OutOfRangeException {
		BigInteger number = findLargestNumber(arr);
		if ((number.compareTo(BigInteger.valueOf(Long.MAX_VALUE))) > 0) {
			new OutOfRangeException("Number larger than maximum long size");
		}
		return number.longValueExact();
	}

	/*
	 * This method sums the largest numbers that can be formed by each array in the
	 * given list. This method must not alter the given list.
	 * 
	 * @Param arr - an array of Integers
	 * 
	 * @Return - the sum of all elements in the array
	 */
	public static BigInteger sum(List<Integer[]> list) {
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < list.size(); i++) {
			sum.add(findLargestNumber(list.get(i)));
		}
		return sum;
	}

	/*
	 * This method determines the kth largest number that can be formed by each
	 * array in the given list. E.g., if k=0 returns the largest overall, if
	 * k=list.size()-1 returns the smallest overall. This method returns the
	 * original array that represents the kth largest number, not the kth largest
	 * number itself. An IllegalArgumentException is
	 * thrown if k is not a valid position in the list. This method must not alter
	 * the given list and must call your insertionSort method with a Comparator or
	 * lambda expression that you design.
	 * 
	 * @Param arr - an array of Integers
	 * 
	 * @Throws IllegalArgumentException if k is an invalid position in the list
	 * 
	 * @Return - the kth largest integer
	 */
	public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {
		if (list.size() < k)
			new IllegalArgumentException("List size smaller than k");
		Integer[][] arr = new Integer[list.size()][];
		arr = list.toArray(arr);
		insertionSort(arr, (i1, i2) -> findLargestInt(i1) - findLargestInt(i2));
		return arr[k];
	}

	/*
	 * This method generates list of integer arrays from an input file, such that
	 * each line corresponds to one array of integers separated by blank spaces, and
	 * returns an empty list if the file does not exist.
	 * 
	 * @Param filename - the name of the file to be read
	 * 
	 * @Return - an array of integers within the file
	 */
	public static List<Integer[]> readFile(String filename) {
		ArrayList<Integer[]> arrays = new ArrayList<>();
		try {
			Scanner fileIn = new Scanner(new File(filename));
			while (fileIn.hasNextLine()) {	
				String line = fileIn.nextLine();
				arrays.add(lineToArray(line));
			} // repeat for all lines
			
			fileIn.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage() + " File not found.");
		} 
		return arrays;
	}
	
	private static Integer[] lineToArray(String line){
		ArrayList<Integer> preArray = new ArrayList<>();
		Scanner lineIn = new Scanner(line);
		lineIn.useDelimiter(" ");
		
		while (lineIn.hasNext()) {
			preArray.add(Integer.valueOf(lineIn.next()));
		}
		
		Integer[] array = new Integer[preArray.size()];
		for (int i = 0; i < preArray.size(); i++) {
			array[i] = preArray.get(i);
		}
		
		lineIn.close();
		return array;
	}
	
	// As lambda: (o1, o2) -> Integer.valueOf("" + o1 + o2) - Integer.valueOf("" + o2 + o1)
	protected static class OrderByConcat implements Comparator<Integer> {
		public int compare(Integer x, Integer y) {
			// Concatenates both ways possible for X and Y and casts each to an int
			int xy = Integer.valueOf("" + x + y);
			int yx = Integer.valueOf("" + y + x);
			
			// Returns the difference between XY and YX
			return xy - yx;
		}
	}
}

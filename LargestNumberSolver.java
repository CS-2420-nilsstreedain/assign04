package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//import java.util.stream.Stream;

/**
 * Methods to find the largest number via concatenating the individual elements
 * in a provided Integer array or collection of Integer arrays
 * 
 * @author Kyle Williams, Nils Streedain
 * @version February 17, 2021
 */

public class LargestNumberSolver {

	/**
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 * 
	 * @param <T> - the type of elements contained in this priority queue
	 * @param arr - the array of elements to search through
	 * @param cmp - the comparator
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		// Loops over each element of arr other than the first
		for (int i = 1; i < arr.length; i++) {

			// Stores element determined by iteration of the loop
			T val = arr[i];

			// Shifts values larger than i but placed lower than i in the array up 1 index
			int j;
			for (j = i - 1; j >= 0 && (cmp.compare(arr[j], val) < 0); j--)
				arr[j + 1] = arr[j];

			// Places value in the open space created by the shift of larger values
			arr[j + 1] = val;
		}
	}

	/**
	 * This method compares each Integer from the provided array and concatenating
	 * them to create the largest possible number, returns as a BigInteger
	 * 
	 * @param arr - an array of Integers
	 * @return the largest number in the provided array
	 */
	public static BigInteger findLargestNumber(Integer[] arr) {
		// Checks if arr has a length of zero
		if (arr.length == 0)
			return new BigInteger("0");

		// Copies arr to newArr
		Integer[] newArr = Arrays.copyOf(arr, arr.length);

		// Sorts newArr with a lambda by concatenating both ways possible for X and Y
		// and casts each to an Integer, returns difference
		insertionSort(newArr, (o1, o2) -> Integer.valueOf("" + o1 + o2) - Integer.valueOf("" + o2 + o1));

		// Concatenates every element of newArr
		String concatenate = "";
		for (int i = 0; i < newArr.length; i++)
			concatenate += newArr[i];

		// Returns concatenated String as a BigInteger
		return new BigInteger(concatenate);
	}

	/**
	 * This method compares each Integer from the provided array and concatenating
	 * them to create the largest possible number, returns as an int, does not work
	 * if larger than 2^32 (the maximum int value)
	 * 
	 * @param arr - an array of Integers
	 * @throws OutOfRangeException if largest number is too large for int data type
	 * @return largest number in data type int
	 */
	public static int findLargestInt(Integer[] arr) throws OutOfRangeException {
		// Finds and returns largest number unless it doesn't fit in an int data type
		BigInteger number = findLargestNumber(arr);
		if ((number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))) > 0)
			new OutOfRangeException("Number larger than maximum int size");

		return number.intValueExact();
	}

	/**
	 * This method behaves the same as the previous method, but for data type long
	 * instead of data type int.
	 * 
	 * @param arr - an array of Integers
	 * @throws OutOfRangeException if largest number is too large for long data type
	 * @return largest number in data type long
	 */
	public static long findLargestLong(Integer[] arr) throws OutOfRangeException {
		// Finds and returns largest number unless it doesn't fit in a long data type
		BigInteger number = findLargestNumber(arr);
		if ((number.compareTo(BigInteger.valueOf(Long.MAX_VALUE))) > 0)
			new OutOfRangeException("Number larger than maximum long size");

		return number.longValueExact();
	}

	/**
	 * This method sums the largest numbers that can be formed by each array in the
	 * given list. This method must not alter the given list.
	 * 
	 * @param arr - an array of Integers
	 * @return - the sum of all elements in the array
	 */
	public static BigInteger sum(List<Integer[]> list) {
		// Initializes a BigInteger with 0 so values can be added to it
		BigInteger sum = new BigInteger("0");

		// Iterates over each value in list and adds the largest number
		for (int i = 0; i < list.size(); i++)
			sum.add(findLargestNumber(list.get(i)));

		return sum;
	}

	/**
	 * This method determines the kth largest number formed using the findLargestInt
	 * method above, and returns the associated array. Throws
	 * IllegalArgumentException if k is not a valid position in the list. This
	 * method does not alter the given list.
	 * 
	 * @param arr - an array of Integers
	 * @throws IllegalArgumentException if k is an invalid position in the list
	 * @return - the kth largest integer
	 */
	public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {
		// Throws exception if k is larger than the list size
		if (list.size() < k)
			new IllegalArgumentException("List size smaller than k");

		// Creates a 2D Integer array copied from list
		Integer[][] arr = list.toArray(new Integer[list.size()][]);

		// Sorts the copied array by findLargestInt
		insertionSort(arr, (i1, i2) -> findLargestInt(i1) - findLargestInt(i2));

		return arr[k];
	}

	/**
	 * This method generates list of integer arrays from an input file, such that
	 * each line corresponds to one array of integers separated by blank spaces, and
	 * returns an empty list if the file does not exist.
	 * 
	 * @param filename - the name of the file to be read
	 * @return - an array of integers within the file
	 */
	public static List<Integer[]> readFile(String filename) {
		// Creates a new ArrayList of Integer arrays
		ArrayList<Integer[]> arrays = new ArrayList<>();

		try {
			// Creates a new scanner from a file
			Scanner fileIn = new Scanner(new File(filename));

			// Loops over each line of the file, turns each line into a String, then turns
			// that String into an array that is added to the ArrayList
			while (fileIn.hasNextLine()) {
				String line = fileIn.nextLine();
				arrays.add(lineToArray(line));
			}

			// Closes the file
			fileIn.close();

		} catch (FileNotFoundException e) {
			// If a file is not found, an error message is sent
			System.err.println(e.getMessage() + " File not found.");
		}

		return arrays;
	}

	/**
	 * Helper method for readFile that turns an individual line into an array.
	 * 
	 * @param line - line to be turned into an array
	 * @return array - array created from line parameter
	 */
	private static Integer[] lineToArray(String line) {
		/*
		 * Old code:
		 * 
		 * ArrayList<Integer> preArray = new ArrayList<>(); Scanner lineIn = new
		 * Scanner(line);
		 * 
		 * lineIn.useDelimiter(" "); while (lineIn.hasNext()) {
		 * preArray.add(Integer.valueOf(lineIn.next())); } Integer[] array = new
		 * Integer[preArray.size()]; for (int i = 0; i < preArray.size(); i++) {
		 * array[i] = preArray.get(i); } lineIn.close();
		 */

		/*
		 * To try:
		 * 
		 * Ended up having to stream to int[] then Integer[] because you can't go from
		 * String[] to Integer[] so it may be slower but I want to see. Arrays.stream is
		 * primitive and Stream.of is non primitive.
		 * 
		 * Integer[] array =
		 * Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(
		 * Integer[]::new); Integer[] array =
		 * Stream.of(line.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(
		 * Integer[]::new);
		 */

		// Splits the line into a String array
		String[] lineSplit = line.split(" ");

		// Creates an Integer array the same length as the lineSplit array
		Integer[] array = new Integer[lineSplit.length];

		// Copies each value of the String array to an Integer array
		for (int i = 0; i < lineSplit.length; i++)
			array[i] = Integer.valueOf(lineSplit[i]);

		return array;
	}
}

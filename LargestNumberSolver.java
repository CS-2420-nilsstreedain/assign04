package assign04;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;

public class LargestNumberSolver {
	
	/*
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 * 
	 * A priority queue that supports access of the minimum element only.
	 * 
	 * @author Kyle Williams and Nils Streedain
	 * 
	 * @version February 16, 2021
	 * 
	 * @param <T> - the type of elements contained in this priority queue
	 */
	
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {

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
		return null;
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
		return 0;
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
		return 0;
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
		return null;
	}

	/*
	 * This method determines the kth largest number that can be formed by each
	 * array in the given list. E.g., if k=0 returns the largest overall, if
	 * k=list.size()-1 returns the smallest overall. This method returns the
	 * original array that represents the kth largest number, not the kth largest
	 * number itself. An IllegalArgumentException (Links to an external site.) is
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
		return null;
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
		return null;
	}
}

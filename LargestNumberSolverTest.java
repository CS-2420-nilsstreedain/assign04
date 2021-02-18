package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Overall JUnit tester for the LargestNumberSolver class
 * 
 * @author Kyle Williams, Nils Streedain
 * @version February 17, 2021
 */
class LargestNumberSolverTest {

	private Integer[] emptyIntegerArray;
	private String[] emptyStringArray;

	private ArrayList<Integer[]> emptyArrayList;
	private ArrayList<Integer[]> largeArrayList;
	private ArrayList<Integer[]> arrayListWithEmptyIntegerArrays;
	
	private ArrayList<Integer[]> plainArrayList;
	private LinkedList<Integer[]> plainLinkedList;
	private Vector<Integer[]> plainVector;


	@BeforeEach
	void setUp() throws Exception {
		plainArrayList = new ArrayList<>();
		plainArrayList.add(new Integer[] { 3, 3, 3 });
		plainArrayList.add(new Integer[] { 2, 2, 2 });
		plainArrayList.add(new Integer[] { 1, 1, 1 });

		plainLinkedList = new LinkedList<>();
		plainLinkedList.add(new Integer[] { 3, 3, 3 });
		plainLinkedList.add(new Integer[] { 2, 2, 2 });
		plainLinkedList.add(new Integer[] { 1, 1, 1 });

		plainVector = new Vector<>();
		plainVector.add(new Integer[] { 3, 3, 3 });
		plainVector.add(new Integer[] { 2, 2, 2 });
		plainVector.add(new Integer[] { 1, 1, 1 });

		emptyArrayList = new ArrayList<>();

		largeArrayList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			largeArrayList.add(new Integer[] { i, i, i });

		arrayListWithEmptyIntegerArrays = new ArrayList<>();
		arrayListWithEmptyIntegerArrays.add(new Integer[] { 3, 3, 3 });
		arrayListWithEmptyIntegerArrays.add(new Integer[0]);
		arrayListWithEmptyIntegerArrays.add(new Integer[] { 2, 2, 2 });
		arrayListWithEmptyIntegerArrays.add(new Integer[0]);
		arrayListWithEmptyIntegerArrays.add(new Integer[] { 1, 1, 1 });
	}

	// -------------------------------------------------- insertionSort method tests --------------------------------------------------

	// Tests insertionSort() for an empty Integer array
	@Test
	void insertionSortEmpty() {
		emptyIntegerArray = new Integer[0];
		LargestNumberSolver.insertionSort(emptyIntegerArray, (o1, o2) -> o1 - o2);
		assertArrayEquals(new Integer[0], emptyIntegerArray);
	}

	// Tests insertionSort for an Integer array with two elements
	@Test
	void insertionSortTwoValues() {
		emptyIntegerArray = new Integer[] { 1, 0 };
		LargestNumberSolver.insertionSort(emptyIntegerArray, (o1, o2) -> o1 - o2);
		assertArrayEquals(new Integer[] { 0, 1 }, emptyIntegerArray);
	}

	// Tests insertionSort for an Integer array with five elements
	@Test
	void insertionSortFiveValues() {
		emptyIntegerArray = new Integer[] { 3, 2, 4, 1, 0 };
		LargestNumberSolver.insertionSort(emptyIntegerArray, (o1, o2) -> o1 - o2);
		assertArrayEquals(new Integer[] { 0, 1, 2, 3, 4 }, emptyIntegerArray);
	}

	// Tests insertionSort for an Integer array with five elements using the
	// finLargestNumber lambda expression
	@Test
	void insertionSortFiveLinearValues() {
		emptyIntegerArray = new Integer[] { 0, 4, 2, 1, 3 };
		LargestNumberSolver.insertionSort(emptyIntegerArray,
				(o1, o2) -> Integer.valueOf("" + o2 + o1) - Integer.valueOf("" + o1 + o2));
		assertArrayEquals(new Integer[] { 4, 3, 2, 1, 0 }, emptyIntegerArray);
	}

	// Test insertionSort for an Integer array with five of the same elements
	@Test
	void insertionSortSameValues() {
		emptyIntegerArray = new Integer[] { 0, 0, 0, 0, 0 };
		LargestNumberSolver.insertionSort(emptyIntegerArray, (o1, o2) -> o1 - o2);
		assertArrayEquals(new Integer[] { 0, 0, 0, 0, 0 }, emptyIntegerArray);
	}

	// Tests insertionSort for an Integer array with 1000 elements
	@Test
	void insertionSortLargeArray() {
		emptyIntegerArray = new Integer[1000];
		for (int i = 0; i < 1000; i++)
			emptyIntegerArray[i] = 999 - i;
		LargestNumberSolver.insertionSort(emptyIntegerArray, (o1, o2) -> o1 - o2);
		assertEquals(999, emptyIntegerArray[999]);
	}
	
	@Test
	void insertionSortStringLengthArray() {
		emptyStringArray = new String[] {"4444", "333", "1", "22"};
		LargestNumberSolver.insertionSort(emptyStringArray, (o1, o2) -> o1.length() - o2.length());
		assertArrayEquals(new String[] {"1", "22", "333", "4444"}, emptyStringArray);
	}
	
	@Test
	void insertionSortStringLexArray() {
		emptyStringArray = new String[] {"c", "a", "b"};
		LargestNumberSolver.insertionSort(emptyStringArray, (s1, s2) -> s1.compareTo(s2));
		assertArrayEquals(new String[] {"a", "b", "c"}, emptyStringArray);
	}

	// -------------------------------------------------- findLargestNumber() method tests --------------------------------------------------

	// Tests findLargestNumber for empty array
	@Test
	void findLargestNumberEmptyArray() {
		emptyIntegerArray = new Integer[] { 0 };
		assertEquals(new BigInteger("0"), LargestNumberSolver.findLargestNumber(emptyIntegerArray));
	}

	// Tests findLargestNumber for an array with two elements
	@Test
	void findLargestNumberSmallArray() {
		emptyIntegerArray = new Integer[] { 0, 1 };
		assertEquals(new BigInteger("10"), LargestNumberSolver.findLargestNumber(emptyIntegerArray));
	}

	// Tests findLargestNumber for an array with five elements
	@Test
	void findLargestNumberMedArray() {
		emptyIntegerArray = new Integer[] { 1, 2, 3, 4, 5 };
		assertEquals(new BigInteger("54321"), LargestNumberSolver.findLargestNumber(emptyIntegerArray));
	}

	// Tests findLargestNumber for an array with twenty elements
	@Test
	void findLargestNumberLargeArray() {
		emptyIntegerArray = new Integer[20];
		for (int i = 0; i < 20; i++)
			emptyIntegerArray[i] = i + 1;
		assertEquals(new BigInteger("9876543220191817161514131211110"), LargestNumberSolver.findLargestNumber(emptyIntegerArray));
	}

	// -------------------------------------------------- findLargestInt() method tests --------------------------------------------------

	// Tests findLargestInt for empty array
	@Test
	void findLargestIntEmptyArray() {
		emptyIntegerArray = new Integer[] { 0 };
		assertEquals(0, LargestNumberSolver.findLargestInt(emptyIntegerArray));
	}

	// Tests findLargestInt for an array with two elements
	@Test
	void findLargestIntSmallArray() {
		emptyIntegerArray = new Integer[] { 0, 1 };
		assertEquals(10, LargestNumberSolver.findLargestInt(emptyIntegerArray));
	}

	// Tests findLargestInt for an array with five elements
	@Test
	void findLargestIntMedArray() {
		emptyIntegerArray = new Integer[] { 1, 2, 3, 4, 5 };
		assertEquals(54321, LargestNumberSolver.findLargestInt(emptyIntegerArray));
	}

	// Test findLargestInt for an array past the bounds of int
	@Test
	void findLargestIntErr() {
		emptyIntegerArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestInt(emptyIntegerArray);
		});
	}

	// -------------------------------------------------- findLargestLong() method tests --------------------------------------------------

	// Tests findLargestLong for empty array
	@Test
	void findLargestLongEmptyArray() {
		emptyIntegerArray = new Integer[] { 0 };
		assertEquals(0, LargestNumberSolver.findLargestLong(emptyIntegerArray));
	}

	// Tests findLargestLong for an array with two elements
	@Test
	void findLargestLongSmallArray() {
		emptyIntegerArray = new Integer[] { 0, 1 };
		assertEquals(10, LargestNumberSolver.findLargestLong(emptyIntegerArray));
	}

	// Tests findLargestLong for an array with five elements
	@Test
	void findLargestLongMedArray() {
		emptyIntegerArray = new Integer[] { 1, 2, 3, 4, 5 };
		assertEquals(54321, LargestNumberSolver.findLargestLong(emptyIntegerArray));
	}

	// Tests findLargestLong for an array past the bounds of long
	@Test
	void findLargestLongErr() {
		emptyIntegerArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestLong(emptyIntegerArray);
		});
	}

	// ------------------------------------------------------- sum() method tests -------------------------------------------------------

	// Tests sum with an ArrayList containing 3 Integer arrays of 3 elements
	@Test
	void sumSmallArrayList() {
		assertEquals(new BigInteger("666"), LargestNumberSolver.sum(plainArrayList));
	}

	// Tests sum with a LinkedList containing 3 Integer arrays of 3 elements
	@Test
	void sumSmallLinkedList() {
		assertEquals(new BigInteger("666"), LargestNumberSolver.sum(plainLinkedList));
	}

	// Tests sum with a Vector containing 3 Integer arrays of 3 elements
	@Test
	void sumSmallVector() {
		assertEquals(new BigInteger("666"), LargestNumberSolver.sum(plainVector));
	}

	// Tests sum with an empty Integer ArrayList
	@Test
	void sumEmptyArrayList() {
		assertEquals(new BigInteger("0"), LargestNumberSolver.sum(emptyArrayList));
	}

	// Tests sum with a large Integer ArrayList
	@Test
	void sumLargeArrayList() {
		assertEquals(new BigInteger("49550400"), LargestNumberSolver.sum(largeArrayList));
	}

	// Tests sum with a an ArrayList containing some empty Integer arrays
	@Test
	void sumTooShortArrayList() {
		assertEquals(new BigInteger("666"), LargestNumberSolver.sum(arrayListWithEmptyIntegerArrays));
	}

	// -------------------------------------------------- findKthLargest() method tests --------------------------------------------------

	// Tests findKth with an ArrayList containing 3 Integer arrays of 3 elements
	@Test
	void findKthSmallArrayList() {
		assertArrayEquals(new Integer[] { 3, 3, 3 }, LargestNumberSolver.findKthLargest(plainArrayList, 0));
	}

	// Tests findKth with a LinkedList containing 3 Integer arrays of 3 elements
	@Test
	void findKthSmallLinkedList() {
		assertArrayEquals(new Integer[] { 3, 3, 3 }, LargestNumberSolver.findKthLargest(plainLinkedList, 0));
	}

	// Tests findKth with a Vector containing 3 Integer arrays of 3 elements
	@Test
	void findKthSmallVector() {
		assertArrayEquals(new Integer[] { 3, 3, 3 }, LargestNumberSolver.findKthLargest(plainVector, 0));
	}

	// Tests finKth with an empty Integer ArrayList
	@Test
	void findKthEmptyArrayList() {
		assertThrows(IllegalArgumentException.class, () -> {
			LargestNumberSolver.findKthLargest(emptyArrayList, 0);
		});
	}

	// Tests findKth with a an ArrayList containing an empty Integer
	@Test
	void findKthArrayListEmptyIntArray() {
		emptyArrayList.add(new Integer[0]);
		assertArrayEquals(new Integer[0], LargestNumberSolver.findKthLargest(emptyArrayList, 0));
	}

	// Tests findKth with a large Integer ArrayList
	@Test
	void findKthLargeArrayList() {
		assertArrayEquals(new Integer[] { 99, 99, 99 }, LargestNumberSolver.findKthLargest(largeArrayList, 0));
	}

	// Tests last value of findKth with a large Integer ArrayList
	@Test
	void findLastKthLargeArrayList() {
		assertArrayEquals(new Integer[] { 0, 0, 0 }, LargestNumberSolver.findKthLargest(largeArrayList, 99));
	}

	// Tests findKth with a an ArrayList containing some empty Integer arrays
	@Test
	void findKthTooShortArrayList() {
		assertArrayEquals(new Integer[] { 3, 3, 3 },
				LargestNumberSolver.findKthLargest(arrayListWithEmptyIntegerArrays, 0));
	}

	// -------------------------------------------------- readFile() method tests --------------------------------------------------

	// Tests readFile by inputting the file and confirming three indexes
	@Test
	void readFileArrayList() {
		ArrayList<Integer[]> file = (ArrayList<Integer[]>) LargestNumberSolver.readFile("src/assign04/integers.txt");
		assertArrayEquals(new Integer[] { 88, 51 }, file.get(7));
		assertArrayEquals(new Integer[] { 92, 89, 39, 7, 21 }, file.get(13));
		assertArrayEquals(new Integer[] { 21, 75, 100, 99 }, file.get(739));
	}

	// Test readFile by inputting an invalid file and expecting an empty array
	@Test
	void readFileNoFile() {
		ArrayList<Integer[]> file = (ArrayList<Integer[]>) LargestNumberSolver.readFile("");
		assertEquals(new ArrayList<Integer[]>(), file);
	}

	// Test readFile by inputting an invalid file and expecting an empty file
	@Test
	void readFileEmptyFile() {
		ArrayList<Integer[]> file = (ArrayList<Integer[]>) LargestNumberSolver.readFile("src/assign04/empty.txt");
		assertEquals(new ArrayList<Integer[]>(), file);
	}
}

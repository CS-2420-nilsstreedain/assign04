package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LargestNumberSolverTest {
	
	private ArrayList<Integer[]> arrayList = new ArrayList<>();
	private Integer[] integerArrayOne = {5, 5, 5};
	private Integer[] integerArrayTwo = {4, 4, 4};
	private Integer[] integerArrayThree = {2, 1, 3};

	@BeforeEach
	void setUp() throws Exception {
		arrayList.add(integerArrayOne);
		arrayList.add(integerArrayTwo);
		arrayList.add(integerArrayThree);
	}

	@Test
	void test() {
//		System.out.println(LargestNumberSolver.findLargestNumber(integerArray));
		
		System.out.println(Arrays.toString(LargestNumberSolver.findKthLargest(arrayList, 0)));
		
		fail("Not yet implemented");
	}

}

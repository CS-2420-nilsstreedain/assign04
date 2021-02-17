package assign04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LargestNumberSolverTest {
	
	private Integer[] integerArray = {11, 12, 11, 12, 11};

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
		System.out.println(LargestNumberSolver.findLargestNumber(integerArray));
		fail("Not yet implemented");
	}

}

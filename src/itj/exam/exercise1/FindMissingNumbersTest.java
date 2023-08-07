package itj.exam.exercise1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class FindMissingNumbersTest {

	@Test
	void testArrayWithUnorderedValues() {
		Integer[] inputArray = { 4, 3, 2, 7, 8, 2, 3, 1 };
		int[] expectedResult = { 5, 6 };
		int[] result = new FindMissingNumbers(inputArray).solve();
		Arrays.sort(result);
		Arrays.sort(expectedResult);
		assertArrayEquals(expectedResult, result);
	}

	@Test
	void testArrayWithRepeatedNumber() {
		Integer[] inputArray = { 1, 1, 1, 1, 1, 1 };
		int[] expectedResult = { 2, 3, 4, 5, 6 };
		int[] result = new FindMissingNumbers(inputArray).solve();
		Arrays.sort(result);
		Arrays.sort(expectedResult);
		assertArrayEquals(expectedResult, result);
	}

	@Test
	void testEmptyArray() {
		Integer[] inputArray = {};
		int[] expectedResult = {};
		int[] result = new FindMissingNumbers(inputArray).solve();
		Arrays.sort(result);
		Arrays.sort(expectedResult);
		assertArrayEquals(expectedResult, result);
	}

	@Test
	void testArrayOfSizeOne() {
		Integer[] inputArray = { 2 };
		int[] expectedResult = { 1 };
		int[] result = new FindMissingNumbers(inputArray).solve();
		Arrays.sort(result);
		Arrays.sort(expectedResult);
		assertArrayEquals(expectedResult,result );
	}
	

	@Test
	void testLargeInput() {
		Integer[] inputArray = IntStream.range(1, 5001).boxed().toArray(Integer[]::new);
		inputArray[499] = 1;
		inputArray[999] = 1;
		inputArray[2999] = 3;
		inputArray[3999] = 5;

		int[] expectedResult = { 500,1000,3000,4000 };
		int[] result = new FindMissingNumbers(inputArray).solve();
		Arrays.sort(result);
		Arrays.sort(expectedResult);
		assertArrayEquals(expectedResult, result);
	}

	
	@Test
	void testNullInput() {
		Integer[] inputArray = null;
		
	    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	    	
	    	int[] result = new FindMissingNumbers(inputArray).solve();
	    });

	    String expectedMessage = "Input array is null";
	    String actualMessage = exception.getMessage();
	    assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	void testArrayWithNullValues() {
		Integer[] inputArray = {1,2,null};
		
	    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	    	
	    	int[] result = new FindMissingNumbers(inputArray).solve();
	    });

	    String expectedMessage = "Array contains null values";
	    String actualMessage = exception.getMessage();
	    assertEquals(expectedMessage, actualMessage);
	}
	
}

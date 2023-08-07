package itj.exam.exercise2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class SumOfTwoTest {

	@Test
	void testArrayWithDuplicateValues() {
		Integer[] input = {3,3};
		System.out.println(Arrays.toString(new SumOfTwo(input) .find(6)));
	}
	
	
	@Test
	void testNullArray() {
	    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	    	
	    	Integer[] result = new SumOfTwo(null).find(6);
	    });

	    String expectedMessage = "Input array is null";
	    String actualMessage = exception.getMessage();
	    assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	void testWithNullTargetNumber() {
		Integer[] inputArray = {};
	    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
	    	Integer[] result = new SumOfTwo(inputArray).find(null);
	    });

	    String expectedMessage = "Target number can't be null";
	    String actualMessage = exception.getMessage();
	    assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	void testArrayWithNegativeNumbers() {
		Integer[] inputArray = {-43,43};
		Integer[] result = new SumOfTwo(inputArray) .find(0);
		
		int firstResult = result[0];
		int secondResult = result[1];
		assertNotEquals(firstResult, secondResult);
		assertEquals(0,inputArray[firstResult]+inputArray[secondResult]);
	}
	
	@Test
	void testArrayWithNullValues() {
		Integer[] inputArray = {3,null,3};
		Integer[] result = new SumOfTwo(inputArray) .find(6);
		
		int firstResult = result[0];
		int secondResult = result[1];
		assertNotEquals(firstResult, secondResult);
		assertEquals(6,inputArray[firstResult]+inputArray[secondResult]);
	}
	@Test
	void testTargetNumberNotFound() {
		Integer[] inputArray = {3};
		Integer[] result = new SumOfTwo(inputArray) .find(3);
		
		assertEquals(0, result.length);
	}
	
	
	@Test
	void testLargeInput() {
		Integer[] inputArray = IntStream.range(1, 10001).boxed().toArray(Integer[]::new);
		inputArray[499]=30_000;		
		Integer[] result = new SumOfTwo(inputArray) .find(30_200);
		assertEquals(30_200,inputArray[result[0]]+inputArray[result[1]]);
	}

}

package itj.exam.exercise1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FindMissingNumbers {
	
	Integer[] input;
	
	public FindMissingNumbers(Integer[] input) {
		if(input == null) {
			throw new IllegalArgumentException("Input array is null");	
		}
		boolean hasNoNullValues = Arrays.stream(input).allMatch(e->e!=null);
		if(!hasNoNullValues) {
			throw new IllegalArgumentException("Array contains null values");
		}
		
		this.input = input;
	}
	
	public int[] solve() {
		int originalLength = input.length;
		
		
		
		Set<Integer> inputAsSet = new HashSet<Integer>(Arrays.asList(input));
		IntStream result = IntStream.range(1, originalLength+1).filter(e->!inputAsSet.contains(e));
		return result.toArray();
		
	}
	
	
	static public void main(String...args) {
		
	}
	

}

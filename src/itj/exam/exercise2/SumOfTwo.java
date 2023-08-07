package itj.exam.exercise2;

public class SumOfTwo {

	private Integer[] input;

	public SumOfTwo(Integer[] input) {
		if(input == null) {
			throw new IllegalArgumentException("Input array is null");	
		}
		this.input = input;
	}
	
	public Integer[] find(Integer targetNumber) {
		if(targetNumber == null) {
			throw new IllegalArgumentException("Target number can't be null");	
		}
		for(int i=0;i<input.length;i++) {
			for(int j=i+1; j<input.length;j++) {
				Integer firstValue = input[i];
				Integer secondValue = input[j];
				if(firstValue == null || secondValue == null) {
					continue;
				}
				if(firstValue+secondValue==targetNumber) {
					Integer[] result= {i,j};
					return result;
				}
			}
		}
		Integer[] result= {};
		return result;
	}
	
	static public void main(String ...args) {
	}
}

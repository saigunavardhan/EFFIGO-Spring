package JUnit;

public class MyMath {
	
	private int sum;
	public int CalculateSum(int[] numbers) {
		for(int number:numbers) {
		sum += number;	
		}
		return sum;
	}
}

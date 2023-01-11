import java.util.stream.IntStream;

public class RangeExample {
	public static void main(String[] args) {
		int[] numbers = IntStream.range(0, 10).toArray();
		
		for (int num : numbers) {
			System.out.println(num);
		}
	}
}

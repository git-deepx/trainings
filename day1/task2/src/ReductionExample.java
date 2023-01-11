import java.util.ArrayList;
import java.util.List;

public class ReductionExample {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		
		int sum = numbers.stream()
		        .reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		
	}

}

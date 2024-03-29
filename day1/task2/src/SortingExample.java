import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortingExample {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(4);
		numbers.add(2);
		numbers.add(6);
		numbers.add(3);
		numbers.add(1);
		numbers.add(5);
		
		List<Integer> topK = numbers.stream()
		        .sorted()
		        .limit(3) // any Limit we want to add
		        .collect(Collectors.toList());
		
		System.out.println(topK);
		
	}

}

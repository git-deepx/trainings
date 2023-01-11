import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConversionExample {
	public static void main(String[] args) {  
		List<String> words = new ArrayList<String>();
		
		words.add("first");
		words.add("second");
		words.add("third");
		words.add("fourth");
		words.add("fifth");
		words.add("sixth");
		words.add("seventh");
		
		
		Map<String, Integer> wordLengths = words.stream()
		        .collect(Collectors.toMap(
		                word -> word, //
		                word -> word.length())); // mapping word to wordLength
		System.out.println(wordLengths);
	}
}

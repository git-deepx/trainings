import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindingsExample {
	public static void main(String[] args) {
		List<String> words = new ArrayList<String>();
		
		words.add("first");
		words.add("second");
		words.add("third");
		words.add("fourth");
		words.add("fifth");
		words.add("sixth");
		words.add("seventh");
		
		Optional<String> LongWordsUsingFindAny = words.stream()
		        .filter(word -> word.length() > 3)
		        .findAny();
		System.out.println(LongWordsUsingFindAny);
		
		Optional<String> LongWordsUsingFindFirst = words.stream()
		        .filter(word -> word.length() > 5  && word.charAt(2) == 'c')
		        .findFirst();
		// Note that findFirst() and findAny() methods return Optional<T> objects.
		System.out.println(LongWordsUsingFindFirst);
		
		//Matching Example
		Boolean match = words
				.stream()
				.allMatch(obj -> obj.length() > 5);
		
		System.out.println(match);
		
		//JOining example
		String joinedWords = words.stream()
		        .collect(Collectors.joining("-"));
		System.out.println(joinedWords);

	}
}
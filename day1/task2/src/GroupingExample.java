import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Items{
	int id;
	String name;
	String category;
	
	Items(int id, String category, String name) {
		this.id = id;
		this.category = category;
		this.name = name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return id + " " + category + " " + name;
	}
}

public class GroupingExample {
	public static void main(String[] args) {
		List<Items> items = new ArrayList<>();
		items.add(new Items(1, "TV", "sony TV"));
		items.add(new Items(4, "fridge", "sony Fridge"));
		items.add(new Items(2, "TV", "xiaomi TV"));
		items.add(new Items(6, "fridge", "Xiaomi Fridge"));
		items.add(new Items(3, "TV", "Apple TV"));
		
		System.out.println(items.get(3).getCategory()); // syntax to access elements in ArrayList
		
		Map<String, List<Items>> productsByCategoryMap = items.stream()
					.collect(Collectors.groupingBy(Items::getCategory));
		System.out.println(productsByCategoryMap);
		
		Map<String, List<String>> result = items.stream()
				.collect(Collectors.groupingBy(Items::getCategory,
                                Collectors.mapping(Items::getName, Collectors.toList())
                        )
                );
		System.out.println(result);
	
	}
}

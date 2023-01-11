import java.util.TreeSet;
public class TreeSetExample {
	public static void main(String[] args)
    {
        // Creating a Set interface with reference to
        // TreeSet
        TreeSet<String> ts1 = new TreeSet<>();
 
        // Elements are added using add() method
        ts1.add("A");
        ts1.add("C");
        ts1.add("B");
 
        // Duplicates will not get insert
        ts1.add("C");
 
        // Elements get stored in default natural
        // Sorting Order(Ascending)
        System.out.println(ts1);
    }
}

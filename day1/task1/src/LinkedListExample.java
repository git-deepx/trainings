import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
	public static void main(String[] args) {
	    LinkedList<String> cars = new LinkedList<String>();
	    
	    cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		cars.add("Mazda");
		
	    System.out.println(cars);
	    
	    Iterator<String> i=cars.iterator();  
        
        while(i.hasNext()) {  // iteration in linkedList
        	System.out.println(i.next());  
        }
  }
}
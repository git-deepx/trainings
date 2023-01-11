import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
	public static void main(String args[]){    
        LinkedHashSet<String> set=new LinkedHashSet<String>();  
        set.add("One");    
        set.add("Two");    
        set.add("Three");   
        set.add("Four");  
        set.add("One");   
        set.add("Five");  
        System.out.println(set);
        
        Iterator<String> i=set.iterator();  
        
        while(i.hasNext()) {  // iteration in linkedList 
        	System.out.println(i.next());  
        }  
 }  
}

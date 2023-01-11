import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }
    
    public String getName() {
    	return name;
    }
}

/**
 * @author 7000033080
 *
 */
public class FilteringExample {  
    public static void main(String[] args) {  
        ArrayList<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f));  
        productsList.add(new Product(2,"Dell Laptop",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product(4,"Sony Laptop",82000f));  
        productsList.add(new Product(5,"Apple Laptop",90000f));
        
        
        
        List<String> prodNames1 = productsList
        		.stream()
        		.collect(Collectors.mapping(Product::getName, Collectors.toList()));
        System.out.println(prodNames1);
        
        List<String> prodNames2 = productsList
        		.stream()
        		.map(obj -> obj.getName())
        		.collect(Collectors.toList());
        System.out.println(prodNames2);
        
        
        //filtering Example
        List<Float> pricesList =  productsList.stream()  
					                .filter(p -> p.price > 30000)   // filtering price  
					                .map(pm -> pm.price)          // fetching price  
					                .collect(Collectors.toList());  // collecting the values
        System.out.println(pricesList);
        
        //pre-processing Example
        List<Float> squares = pricesList.stream()
					                .map(n -> n * n)
					                .collect(Collectors.toList());
        System.out.println(squares);
    }
    
}  
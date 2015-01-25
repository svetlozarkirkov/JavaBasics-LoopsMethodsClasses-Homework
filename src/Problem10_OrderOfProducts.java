import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem10_OrderOfProducts {
	
	public static class Product { //creating object "Product"
		private String name;  // creating property "name"
		private BigDecimal price; //creating property "price"
		
		public Product(String name, BigDecimal price){ //constructor with parameters
			this.name=name;
			this.price=price;
		}
		public String getName(){ //method to return the name of the product
			return name;
		}
		public BigDecimal getPrice(){ //method to return the price of the product
			return price;
		}
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		ArrayList<Product> products = new ArrayList<Product>(); //list to keep the products from input file
		try {
			Scanner productsTXT = new Scanner(new File("Products.txt")); //opening the Products.txt file
			while (productsTXT.hasNextLine()){ //checking if the file has more lines
				Product temp = new Product(productsTXT.next(),productsTXT.nextBigDecimal()); //creating temporary product
				products.add(temp); //adding the temporary product to the list
			}
			productsTXT.close();
		} catch (FileNotFoundException e) { //catching the exception if the file does not exist
			System.out.println("Error: Products.txt not found!"); //printing error message
			System.exit(-1); //program exit
		}
		Map<BigDecimal, String> orders = new HashMap<BigDecimal, String>(); //creating hashmap to hold the orders
		try{
			Scanner orderTXT = new Scanner(new File("Order.txt")); //opening the Order.txt file
			while (orderTXT.hasNextLine()){ //checking if the file has more lines
			orders.put(orderTXT.nextBigDecimal(), orderTXT.next()); // putting the temporary order in the hashmap
			}														// using "quantity" + " " + "product" from Order.txt
			orderTXT.close();
		}
		catch (FileNotFoundException e) { //catching the exception if the file does not exist
			System.out.println("Error: Order.txt not found!"); //printing error message
			System.exit(-1); //program exit
		}
		BigDecimal totalPrice = new BigDecimal("0"); // initialize totalPrice
		for (Map.Entry<BigDecimal, String> entry : orders.entrySet()) { //iterating the orders hashmap
			BigDecimal quantity = entry.getKey(); // getting the quantity
		    String key = entry.getValue(); // getting the name
		    for (Product product: products){ // iterating and checking the products list for the key
		    	if (product.getName().equals(key.toString())){ // if the product is found
		    		BigDecimal itemCost = product.getPrice().multiply(quantity); // calculate item cost
		    		totalPrice = totalPrice.add(itemCost); //adding item cost to the total price
		    	}
		    }
		}
		PrintWriter writer = new PrintWriter("Output.txt", "UTF-8"); //writing the output file
		writer.printf("%.2f",totalPrice); //writing the total price to the output text file
		writer.close(); // closing the writer
		System.out.printf("%.2f",totalPrice); //print totalprice to console
	}
}

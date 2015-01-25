import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Problem9_ListOfProducts {
	
	public static class PriceSorter implements Comparator<Product>{ // class for sorting "product" objects by price

	    public int compare(Product one, Product another){  // the method
	        int returnVal = 0;

		    if(one.getPrice().compareTo(another.getPrice())<0){ 
		        returnVal =  -1;
		    }else if(one.getPrice().compareTo(another.getPrice())>0){
		        returnVal =  1;
		    }else if(one.getPrice() == another.getPrice()){
		        returnVal =  0;
		    }
		    return returnVal;
		    }
		}

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

	public static void main(String[] args) throws UnsupportedEncodingException {
		try {
			Scanner scanner = new Scanner(new File("Input.txt")); //opening the input file
			ArrayList<Product> products = new ArrayList<Product>(); //list to keep the products from input file
			
			while (scanner.hasNextLine()){ //checking if the file has more lines
				Product temp = new Product(scanner.next(),scanner.nextBigDecimal()); //creating temporary product
				products.add(temp); //adding the temporary product to the list
			}
			
			PrintWriter writer = new PrintWriter("Output.txt", "UTF-8"); //writing the output file
			Collections.sort(products,new PriceSorter()); //using PriceSorter class to sort the list of products by price
			
			for (Product prod:products){   // iterate through each product from the list (now sorted)
				writer.printf("%s %s",prod.price,prod.name); //print the product values
				writer.println(); //add a new line
			}
			writer.close(); //closing the file
			scanner.close(); //closing scanner
			
		} catch (FileNotFoundException e) { //catching the exception if the file does not exist
			System.out.println("Error: Input.txt not found!"); //printing error message
			System.exit(-1); //program exit
		}
	}
}
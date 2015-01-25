import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem8_SumNumbersFromTextFile {

	public static void main(String[] args){
		int sum = 0;
		try {
			Scanner scanner = new Scanner(new File("input.txt"));
			while(scanner.hasNextInt())
			{
			     sum += scanner.nextInt();
			}
			System.out.println(sum);
			scanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
	}
}

import java.util.ArrayList;
import java.util.Scanner;


public class Problem5_AngleUnitConverter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<String> resultsStr = new ArrayList<String>(); // keeping the resulting measures
		ArrayList<Double> resultsNumbers = new ArrayList<Double>(); // keeping the resulting numbers
		for (int i = 0; i < n; i++){
			double temp = input.nextDouble();
			String measure = input.next();
				switch (measure) {
	            case "deg": resultsNumbers.add(Math.toRadians(temp));
	            			resultsStr.add("rad");
	                     break;
	            case "rad": resultsNumbers.add(Math.toDegrees(temp));
	            			resultsStr.add("deg");
	            		break;
	            default:
	            break;
			}
		}
		for (int i = 0; i < resultsNumbers.size(); i++){
			System.out.printf("%.6f %s\n",resultsNumbers.get(i),resultsStr.get(i));
		}
		input.close();
	}
}
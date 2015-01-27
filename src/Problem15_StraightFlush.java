import java.util.Scanner;


public class Problem15_StraightFlush {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] inputHand = input.nextLine().split(", ");
		if (inputHand.length<5){
			System.out.println("No Straight Flushes");
			return;
		}
	}
}

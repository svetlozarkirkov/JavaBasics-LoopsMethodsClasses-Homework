import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class Problem6_RandomHandsOfFiveCards {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] faces = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		char[] suits = {'\u2660','\u2665','\u2666','\u2663'};
		ArrayList<String> deck = new ArrayList<String>(); // creating default deck
		for (int i = 0; i < faces.length;i++){
			for (int j = 0; j < suits.length; j++){
				String card = faces[i]+suits[j];
				deck.add(card);
			}
		}
		for (int i = 0; i < n; i++){
			ArrayList<String> tempDeck = deck; //instance of the default deck
			Collections.shuffle(tempDeck); // shuffling :)
			for (int j = 0; j < 5; j++){
				Random random = new Random();
				int randomIndex = random.nextInt(tempDeck.size()); //getting random index of the deck
				System.out.print(tempDeck.get(randomIndex)+ " ");  //printing the card
				tempDeck.remove(randomIndex);  //removing the card from the temp deck
			}
			System.out.println();
		}
		input.close();
	}
}
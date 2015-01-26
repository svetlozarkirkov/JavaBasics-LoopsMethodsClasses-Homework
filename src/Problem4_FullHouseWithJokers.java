
public class Problem4_FullHouseWithJokers {

	public static void main(String[] args) {
		String[] faces = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		char[] suits = {'\u2660','\u2665','\u2666','\u2663'};
		int count = 0;

		String firstCard = "";
		String secondCard = "";
		String thirdCard = "";
		String fourthCard = "";
		String fifthCard = "";

		for (int three = 0; three < faces.length; three++) {
			for (int two = 0; two < faces.length; two++) {
				if (three != two) {
					for (int firstSuit = 0; firstSuit < suits.length; firstSuit++) {
						for (int secondSuit = firstSuit + 1; secondSuit < suits.length; secondSuit++) {
							for (int thirdSuit = secondSuit + 1; thirdSuit < suits.length; thirdSuit++) {
								for (int fourthSuit = 0; fourthSuit < suits.length; fourthSuit++) {
									for (int fifthSiuth = fourthSuit + 1; fifthSiuth < suits.length; fifthSiuth++) {
										firstCard = faces[three] + suits[firstSuit];
										secondCard = faces[three] + suits[secondSuit];
										thirdCard = faces[three] + suits[thirdSuit];
										fourthCard = faces[two] + suits[fourthSuit];
										fifthCard = faces[two] + suits[fifthSiuth];
										String[] hand = { firstCard, secondCard, thirdCard, fourthCard, fifthCard };

										for (int combinations = 0; combinations <= 31; combinations++) {
											int check = combinations;
											for (int jokers = 0; jokers < 5; jokers++) {
												if (check % 2 == 1) {
													hand[jokers] = "* ";
													check /= 2;
												}
											}
											System.out.println(hand[0] + hand[1] + hand[2] + hand[3] + hand[4]);
											count++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count + " Full houses");
	}

}

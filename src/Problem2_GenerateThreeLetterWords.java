import java.util.Scanner;


public class Problem2_GenerateThreeLetterWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine();
		for (int i = 0; i < inputStr.length();i++){
			for (int j = 0; j < inputStr.length();j++){
				for (int k = 0; k < inputStr.length(); k++){
					System.out.printf("%c%c%c%c",inputStr.charAt(i),inputStr.charAt(j),inputStr.charAt(k),' ');
				}
			}
		}
		input.close();
	}
}
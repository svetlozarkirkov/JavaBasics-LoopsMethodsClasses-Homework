import java.util.Scanner;


public class Problem1_SymmetricNumbersInRange {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int start = input.nextInt();
		int end = input.nextInt();
		for (int i = start; i <= end; i++){
			int length = Integer.toString(i).length();
			if(length == 1){
				System.out.print(i+" ");
			}
			else if (length == 2){
				String temp = Integer.toString(i);
				int[] digits = new int[temp.length()];
				for (int j = 0; j < temp.length(); j++)
				{
				    digits[j] = temp.charAt(j) - '0';
				}
				if(digits[0]==digits[1]){
					System.out.print(i+" ");
				}
			}
			else {
				String temp = Integer.toString(i);
				int[] digits = new int[temp.length()];
				for (int j = 0; j < temp.length(); j++)
				{
				    digits[j] = temp.charAt(j) - '0';
				}
				if ((digits[0]==digits[2]) || (digits[0]==digits[1] && digits[1]==digits[2])){
					System.out.print(i+" ");
				}
			}
		}
		input.close();
	}
}

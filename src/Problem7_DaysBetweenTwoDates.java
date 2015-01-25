import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Problem7_DaysBetweenTwoDates {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		String start = input.nextLine();
		String end = input.nextLine();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("d-MM-yyyy"); //creates the format for the input date
		LocalDate startDate = LocalDate.parse(start,format);
		LocalDate endDate = LocalDate.parse(end,format);
		int count = 0;
		if (startDate.isAfter(endDate)){  // checking if the starting date is after the end date
			for (LocalDate dt = endDate; dt.isBefore(startDate); dt=dt.plusDays(1) ){
				count--;
			}
		}
		else {
			for (LocalDate dt = startDate; dt.isBefore(endDate); dt=dt.plusDays(1) ){
				count++;
			}
		}
		System.out.println(count);
		input.close();
	}
}

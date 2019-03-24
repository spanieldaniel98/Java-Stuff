import java.util.Scanner;

public class DateConverter {
	
	Scanner scanner;
	String date;
	String convertedDate;

	public DateConverter() {
		scanner = new Scanner(System.in);
	}
	
	public void run() {
		System.out.println("Enter a date to convert: ");
		date = scanner.next();
		convertedDate = this.convertDate(date);
		System.out.println("The converted date is: " + convertedDate);
		
		run();
	}
	
	public String convertDate(String date) {
		String[] array = date.split("/");
		return array[2] + '-' + array[1] + '-'  + array[0];
	}
}
import java.util.Scanner;

public class RemainderCalculator {
	
	Scanner scanner;
	int dividend, divisor, quotient, remainder;

	public RemainderCalculator() {
		scanner = new Scanner(System.in);
	}
	
	public void run() {
		System.out.println("Enter a dividend (a number to be divided): ");
		dividend = scanner.nextInt();
		
		System.out.println("Enter a divisor (a number to divide by): ");
		divisor = scanner.nextInt();
		
		quotient = dividend / divisor;
		remainder = dividend % divisor;
		
		System.out.println(dividend + " / " + divisor + " = " + quotient + " remainder " + remainder);
	}
}
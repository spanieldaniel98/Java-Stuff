import java.util.ArrayList;
import java.util.Scanner;

public class DivisionSolver {
	
	Scanner scanner;
	String dividend, divisor, quotient, remainder, tempDividend, tempDivisor;
	int tempDividendInt, tempDivisorInt, tempQuotient, tempRemainder;
	char dividendChar, divisorChar;
	boolean possibleSolution;
	
	ArrayList<String> list, dividendList, divisorList;

	// instantiate scanner for reading user input
	public DivisionSolver() {
		scanner = new Scanner(System.in);
	}
	
	// return ArrayList of all possible numbers from input string with *s
	public ArrayList<String> listOfAllCombos(String input) {
		list = new ArrayList<String>();
		list.add("");
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) != '*') {
				for(int j = 0; j < list.size(); j++) {
					list.set(j, list.get(j) + input.charAt(i));
				}
			}
			else {
				for(int j = 0; j < list.size(); j++) {
					String element = list.get(j);
					list.remove(j);

					for(int n = 0; n <= 9; n++) {
						list.add(element + Integer.toString(n));
					}
				}
			}
		}
		return list;
	}
	
	// run main program to take user inputs and return possible division solutions
	public void run() {
		
		// ask for and store user inputs of dividend, divisor, quotient and remainder as variables
		System.out.println("Enter a dividend (a number to be divided), using a * for unknown digits: ");
		dividend = scanner.next();
		
		System.out.println("Enter a divisor (a number to divide by), using a * for unknown digits: ");
		divisor = scanner.next();
		
		System.out.println("Enter a quotient (the result of the division), using a * for unknown digits: ");
		quotient = scanner.next();
		
		System.out.println("Enter a remainder (the remainder of the division), using a * for unknown digits: ");
		remainder = scanner.next();
		
		// generate ArrayLists of possible dividends and divisors from inputs
		dividendList = listOfAllCombos(dividend);
		divisorList = listOfAllCombos(divisor);

		// for all possible dividends and divisors, calculate result and return as a possible
		// solution if valid (i.e. satisfying input quotient and remainder constraints)
		for(String tempDividend : dividendList) {
			for(String tempDivisor : divisorList) {
				
				// convert strings to integers for calculations
				tempDividendInt = Integer.parseInt(tempDividend);
				tempDivisorInt = Integer.parseInt(tempDivisor);
						
				// calculate quotient and remainder
				tempQuotient = tempDividendInt / tempDivisorInt;
				tempRemainder = tempDividendInt % tempDivisorInt;
				
				possibleSolution = true;
				
				// check solution satisfies input quotient constraints
				for(int n = 0; n < quotient.length(); n++) {
					if(quotient.charAt(n) != '*') {
						if(Integer.toString(tempQuotient).charAt(n) != quotient.charAt(n)) {
							possibleSolution = false;
						}
					}
				}
				
				// check solution satisfies input remainder constraints
				for(int n = 0; n <= remainder.length(); n++) {
				    if(remainder.charAt(n) != '*') {
				    	if(Integer.toString(tempRemainder).charAt(n) != remainder.charAt(n)) {
							possibleSolution = false;
						}
					}
				}
				
				// if solution is possible, pretty print
				if(possibleSolution) {
					System.out.println("A possible solution is: " + tempDividendInt + " / " + tempDivisorInt + " = " + tempQuotient + " remainder " + tempRemainder);
				}
			}
		}
	}
}
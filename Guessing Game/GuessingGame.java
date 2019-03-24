import java.util.Scanner;

public class GuessingGame {
	Scanner scanner;
	int lowerBound, upperBound, secretAnswer, guess;
	String input;

	public GuessingGame() {
		lowerBound = 1;
		upperBound = 100;
		secretAnswer = (int)(Math.random() * 100 + 1);
		scanner = new Scanner(System.in);
		System.out.println("Welcome to the guessing game! Can you guess the secret number?");
	}
	
	public void run() {
		System.out.println("Lower bound: " + lowerBound + " | Upper bound: " + upperBound);
		System.out.print("Enter your guess: ");
		input = scanner.nextLine();
		
		if(input.equals("Surrender"))
			System.out.println("Too bad! The answer was " + secretAnswer);
		else {
			guess = Integer.parseInt(input);
			if(guess == secretAnswer)
	        	System.out.println("Congratulations, " + guess + " was the correct answer, you win!");
	        else {
	        	if(guess < lowerBound || guess > upperBound)
	            	System.out.println("Stay in the range please!");
	        	else {
	        		System.out.println("Sorry, that wasn't it... ");
	        		if(guess < secretAnswer)
	                	lowerBound = guess + 1;
	                else
	                	upperBound = guess - 1;
	        	}
	            run();
	        }
		}
	}
}
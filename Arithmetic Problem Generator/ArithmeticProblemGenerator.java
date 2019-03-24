import java.util.Scanner;

public class ArithmeticProblemGenerator 
{
	char math;
	int num1;
	int num2;
    Scanner scanner;

	public ArithmeticProblemGenerator() 
	{
		scanner = new Scanner(System.in);
	}
	
	public void generateProblem() 
	{
		num1 = (int)(Math.random() * 100 + 1);
		num2 = (int)(Math.random() * 100 + 1);
		
		System.out.println("Enter + for addition\nEnter - for subtraction\nEnter * for multiplication");
		math = scanner.next().charAt(0);
		
		if(math == '+')
			System.out.println("Addition problem: " + num1 + "+" + num2);
		
		else if(math == '-')
			System.out.println("Subtraction problem: " + num1 + "-" + num2);
		
		else if (math == '*')
			System.out.println("Multiplication problem: " + num1 + "*" + num2);

		else this.generateProblem();
			
		scanner.close();
	}
}
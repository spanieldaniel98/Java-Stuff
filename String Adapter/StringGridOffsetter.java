import java.util.Scanner;
import java.util.ArrayList;

public class StringGridOffsetter {
	
	Scanner scanner;
	String input;
	boolean caps;

	public StringGridOffsetter() {
		scanner = new Scanner(System.in);
		caps = true;
	}
	
	public void run() {
		System.out.print("Enter a string, if you dare... ");
		input = scanner.nextLine().replaceAll(" ","");
		
		for(int i = 0; i < input.length(); i++) {
			
			for(char c : input.toCharArray()) {
				
				if(caps)
					System.out.print(Character.toUpperCase(c));
				else 
					System.out.print(c);

				caps = !caps;
			}
			
			System.out.println("");
			input = input.substring(1) + input.charAt(0);
		}
	}
}
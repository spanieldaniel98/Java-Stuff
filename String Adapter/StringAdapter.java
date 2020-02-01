import java.util.Scanner;
import java.util.ArrayList;

public class StringAdapter {
	
	Scanner scanner;
	String input;
	ArrayList<Character> outputArray;
	boolean caps;
	
	public String removeExtraSpaces(String input) {
		return input.replaceAll("\\s+", " ");
	}
	
	public String hyphenate(String input) {
		return input.replaceAll("\\s+", "-");
	}
	
	public String alternateCaps(String input) {
		input = removeExtraSpaces(input);
		caps = false;
		outputArray = new ArrayList<Character>();
		
		for(char c : input.toCharArray()) {
			if(!caps) 
				outputArray.add(c);
			else
				outputArray.add(Character.toUpperCase(c));
			caps = !caps;
		}
		return charListToString(outputArray);
	}
	
	public String charListToString(ArrayList<Character> charList) {
		StringBuilder sb = new StringBuilder(charList.size());
		
		for(Character c : charList) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	public void gridOffset(String input) {
		input.replaceAll(" ", "");
		caps = false;
		
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
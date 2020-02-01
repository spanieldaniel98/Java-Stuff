import java.util.List;

public class StringRotater {
	
	public String rotateTheString(String originalString, List<Integer> direction, List<Integer> amount) {
	    
        String output = "";
        int moves, stringLength, instructionLength;

        if(1 <= originalString.length() && originalString.length() <= (int)Math.pow(10, 5)) {
        	output += originalString;
        }  
        else output += originalString.substring(0, (int)Math.pow(10, 5));
        
        stringLength = output.length()-1;

        if(1 <= direction.size() && direction.size() <= (int)Math.pow(10, 5)) {
        	instructionLength = direction.size();
        }  
        else instructionLength = (int)Math.pow(10, 5);
            
        for(int i = 0; i < instructionLength; i++) {
        	
                if(0 <= amount.get(i) && amount.get(i) <= (int)Math.pow(10, 9))
                    moves = amount.get(i);
                
                else moves = 0;

                if(direction.get(i) == 0) {
                    for(int j = 0; j < moves; j++) {
                        output = output.substring(1) + output.charAt(0);
                    }
                }

                if(direction.get(i) == 1) {
                    for(int j = 0; j < moves; j++) {
                        output = output.charAt(stringLength) + output.substring(0, stringLength);
                    }
                }
        }
        return output;
    }
}
import java.util.ArrayList;
import java.util.List;

public class GenBiString {
	public static void main(String [] args){
		
		// Given a string containing of 0 and 1 wildcard characters 
		// generate all binary string that can be formed by replacing 
		// each wildcard chararcter by 0 or 1
		
		String input = "1??0?101"; 
//		StringBuffer sb = new StringBuffer(input);
//		input = sb.reverse().toString();
		
		char [] str = input.toCharArray();
		int count =0;
		
		for(int i=0; i<str.length; i++){
			if(str[i]=='?'){
				count ++;
			}
		}
		
		System.out.println("Input str = \"" + input+"\"");
		
		double possibleAnswer = Math.pow(2, count);
		//doSomething(input, 0 , possibleAnswer, (int)possibleAnswer/2);
		double checkdigit = 1.0/2.0;
		System.out.println("Output: ");
//		System.out.println( doSomething(input, 7, checkdigit, possibleAnswer, 1));
		for(int i=1; i<=possibleAnswer; i++){
			System.out.printf("\t%s\n",doSomething(input, i, checkdigit, possibleAnswer, 1));
		}
	}	
	
	public static String doSomething(String input, int i, double checkdigit, double possibleAnswer, int numberOfLoop){
		//System.out.println("i: " +i + " possibleAnswer: "+possibleAnswer +" numberofLoop: "+ numberOfLoop);
		double valueToCheck = i/possibleAnswer;
		if(possibleAnswer == 2.0 && numberOfLoop == 3){
			//System.out.println(i%possibleAnswer);
			if((i%possibleAnswer==0)){
				input =input.replaceFirst("\\?", "1");
				//System.out.println(input);
				return input;
			}else{
				input =input.replaceFirst("\\?", "0");
				//System.out.println(input);
				return input;
			}
		}
		
		if(numberOfLoop==2){
			String doubleAsString = String.valueOf(valueToCheck);
			int indexOfDecimal = doubleAsString.indexOf(".");
			valueToCheck = Double.parseDouble(doubleAsString.substring(indexOfDecimal));
			//System.out.println(valueToCheck);
			if(valueToCheck==0){
				valueToCheck = 1;
			}
			//return partToCheck;
		}
		//System.out.println("valueToCheck: "+ valueToCheck + " checkdigit: "+ checkdigit);
		if(valueToCheck<=checkdigit){
			input = input.replaceFirst("\\?", "0");
			numberOfLoop ++;
			//System.out.println(input);
			input = doSomething(input, i, checkdigit, possibleAnswer/2, numberOfLoop);
		}else{
			input = input.replaceFirst("\\?", "1");
			numberOfLoop ++;
			//System.out.println(input);
			input = doSomething(input, i, checkdigit, possibleAnswer/2, numberOfLoop);
		}
		
		return input;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	 
}


public class LongestCommonSub {
	
	// the new way to slove this problem
	
	int lcs (char[]firstString, char [] secondString, int string1Length, int string2Length){
//		System.out.println(firstString.length);
//		System.out.println(secondString.length);
//		System.out.println(string1Length+1);
//		System.out.println(string2Length+1);
		int commonString[][] = new int[string1Length+1][string2Length+1];
		
		for(int i =0; i<=string1Length; i++){
			for (int j = 0; j<=string2Length; j++){
				if(i == 0|| j == 0){
					commonString[i][j] = 0;
					System.out.print(commonString[i][j]+" ");
				}else if(firstString[i-1]==secondString[j-1]){
					commonString[i][j] = commonString[i-1][j-1]+1;
					// if they share the character then +1
					System.out.print(commonString[i][j]+" ");
				}else {
					commonString[i][j] = max(commonString[i-1][j], commonString[i][j-1]);
					System.out.print(commonString[i][j]+" ");
					// they have the common character,
					// then they get the last column and the same column on the last row to compare the max 
				}
				
			}
			System.out.println();
		}
		return 0;
	}
	
	 static int max(int a, int b) 
	  { 
	    return (a > b)? a : b; 
	  } 
	public static void main(String [] args ){
		
		
//		// This is my way 
//		// Given two sequences, find the length of longest 
//		//subsequence present in both of them 
//		// abc abg bdf aeg acefg are all subsequences of abcdefg 
//		
//		// need to know the number of possible different 
//		// the combination possbilities 
//		// subsequences of a string with length n
//		
//		String firstSequence = "ABCDGH";
//		String secondSequence = "AEDFHR";
//		
//		// different possible subsequences are 2^(n) - 1 
//		
//		//double possibleNum = Math.pow((double)2, (double)firstSequence.length());
//		//double possibleNum2 = Math.pow(2, secondSequence.length());
//		
//		//System.out.println(possibleNum+" "+ possibleNum2);
//		
//		char [] firstSequence_char = firstSequence.toCharArray();
//		char [] secondSequence_char = secondSequence.toCharArray();
//		
//		char [] commonString = new char [firstSequence_char.length+1];
//		
//		int j =0;
//		int count = 0;
//		for(int i =0; i<firstSequence_char.length; ){
//			
//				if(firstSequence_char[i]==secondSequence_char[j]){
//					commonString[count] = firstSequence_char[i];
//					count++;
//					j++;
//					i++;
//				}else {
//					
//					int instant = j;
//					// length (6) 
//					while (instant<secondSequence_char.length && 
//						firstSequence_char[i]!=secondSequence_char[instant]){
//						instant++;
//					}
//					if(instant==secondSequence_char.length){
//						i++; // it means it reached the end
//					}else{
//						commonString[count] = secondSequence_char[instant];
//						j = instant+1;
//						i++;
//						count++;
//					}
//				}
//			
//		}
//		
//		for(int k=0; k<count; k++){
//			 System.out.print(commonString[k]+" ");
//		}
//		System.out.println("length of the subsequence both sequence share is "+ count);
		
		
		// Here is faster way 
		
		 String sequenceString1 = "AGGTAB"; 
		 char[] firstOne =sequenceString1.toCharArray();
		 int String1Length = firstOne.length; 
		 System.out.println(String1Length);
		 
		 String sequenceString2 = "GXTXAYB"; 
		 char[] secondOne =sequenceString2.toCharArray();		 
		 int String2Length = secondOne.length;
		 System.out.println(String2Length);
		 
		 LongestCommonSub lcs = new  LongestCommonSub();
		 
		 lcs.lcs(firstOne, secondOne, String1Length, String2Length );
		 
	}
		
}


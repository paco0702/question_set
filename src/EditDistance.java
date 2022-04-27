import java.util.ArrayList;
import java.util.List;

public class EditDistance {
	// Given two string str1 and str2 
	// and below operation can performed on str1 
	// insert, remove and replace 
	// find minimum number of edits (operation) required to convert str1 
	// into str2 
	
	
	// if insert (usually the str 1 is shorter than str 2 
	// if remove (usually the str 1 is longer than str 2 
	// if replace (usually they are the same length )
	
	public static void main(String [] args){
		String str1 = "saturday";
		String str2 = "sunday";
		
		char []	str1Char = str1.toCharArray();	
		char [] str2Char = str2.toCharArray();
		
		
		int m = str1Char.length;
		int n = str2Char.length;
		
		int [][] seqOfString = new int [n][m];
		
		for (int i=0; i<seqOfString.length; i++){
			for (int j=0; j<seqOfString[i].length; j++){
				
				if(str2Char[i] == str1Char[j] ){
					seqOfString[i][j] = 1;
					//System.out.print(seqOfString[i][j]+" ");
				}else{
					seqOfString[i][j] = 0;
					//System.out.print(seqOfString[i][j]+" ");
				}
			}
//			System.out.println();
		}
		
		int redundent = 0;
		int notEnough = 0;
		if(m>n){
			redundent = m-n;
			redundent = 0;
			notEnough = m-n;

		}else {
			notEnough = 0;
			redundent = n-m;
		}
		
		char [] storeRedundent = new char [redundent];
		List<String>replaceMent = new ArrayList<>();
		int skippedRows =0;
		
		boolean added = false;
		
		for (int i=0; i<seqOfString.length; i++){
			for (int j=0; j<seqOfString[i].length; j++){
				
				if(seqOfString[i][j] == 1){
					//System.out.println("enter "+ skippedRows);
					//System.out.println("i :"+ i +" j : "+j);
					if((i-skippedRows)==j){
						//System.out.println("i-skippedRows :"+ (i-skippedRows) +" j : "+j);
						//newMatrix [i-skippedRows][j] = 1;
						//System.out.println("char is matched	"+str1Char[i-skippedRows]);
						added = true;
					}
				}
			}
			if(added == true){
				added = false;
			}else{
				if(skippedRows<redundent){
					storeRedundent [skippedRows] = str2Char[i];
					//System.out.println("the char which is redundent is " + str2Char[i]);
					skippedRows++;
					//System.out.println("end "+skippedRows);
				}else{
					replaceMent.add(""+ str2Char[i]);
					//System.out.println("the char needs to be replace " + str2Char[i]);
				}
			}	
		}
		
		System.out.println("");
		System.out.println("The char(s) is going to be removed is ");
		for(int i =0; i<storeRedundent.length; i++){
			System.out.println(storeRedundent[i]);
			
		}
		
		System.out.println("The char(s) is going to be replaced is ");
		for(int i = 0; i<replaceMent.size(); i++){
			System.out.println(replaceMent.get(i));
		}
		
		System.out.println("The char(s) is going to be inserted is ");
		for(int i = notEnough; i>0; i--){
			System.out.println(str1Char[str1Char.length-i]);
		}
}


	
}

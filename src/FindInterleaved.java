//import org.apache.commons.lang3.StringUtils;

public class FindInterleaved {
	public static void main(String [] args){
//		String firstString = "XXXXZY";
//		
//		String compareString = "XXY";
//		String compareString2 = "XXZ";
//		
//		String secondCompare = "";
//		
//		
//		String result = checkString(firstString, compareString, secondCompare, compareString2);
//		System.out.println(result);
		
//		if(StringUtils.compare(secondCompare, compareString2)==0){
//			System.out.println(firstString+" is interleaved of "+ compareString+" and "+ compareString2);
//		}
		System.out.println(checkString("XXXXZY", "XXY","XXZ"));
	
		System.out.println(checkString("XXZXXXY", "XXY","XXZ"));
	
		System.out.println(checkString("WZXY",  "XY", "WZ"));
		
		System.out.println( checkString("XXY", "YX", "X"));
		
		
		// remark
		// if the length with both Strings together are not the same
		// than it must not the interleaved 
		
	}
	public static String checkString (String firstString, String compareString, String compareString2){
		if(firstString.length()!= (compareString.length()+compareString2.length())){
			return firstString+" is not interleaved of "+ compareString+" and "+ compareString2;
		}
		String secondCompare = "";
		int j =0;
		for(int i=0; i<firstString.length(); i++){
			if(firstString.charAt(i)==compareString.charAt(j)){
				j++;
			}else{
				secondCompare = secondCompare + firstString.charAt(i);
			}
		}
		if((secondCompare.compareTo(compareString2)==0)){
			return firstString+" is interleaved of "+ compareString+" and "+ compareString2;
		}else
			return firstString+" is not interleaved of "+ compareString+" and "+ compareString2;
	}
	
	public static String checkString (String firstString, String compareString, String secondCompare, String compareString2){
		int j =0;
		for(int i=0; i<firstString.length(); i++){
			if(firstString.charAt(i)==compareString.charAt(j)){
				j++;
			}else{
				secondCompare = secondCompare + firstString.charAt(i);
			}
		}
		if((secondCompare.compareTo(compareString2)==0)){
			return firstString+" is interleaved of "+ compareString+" and "+ compareString2;
		}else
			return firstString+" is not interleaved of "+ compareString+" and "+ compareString2;
	}
	
	//Sec 0.44 
	//Sec 0.36
	//Sec 0.26 
}

import org.apache.commons.lang3.StringUtils;

public class Boggle {
	// given a dictionary, a method to do a lookup in the dictionary 
	// and a M x N board
	// where every cell has one character
	// find all possible words that can be formed by a sequence of adjacent cahracters
	//a word should not have mulitple instances of the same cell 
	
	
	
	public static void main(String [] args){
		String [] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};
		char [][] boggle = {{'G', 'I', 'Z'},
	            			{'U', 'E', 'K'},
	            			{'Q', 'S', 'E'}};
		
		String [] storedArray = new String [5];
		
		char [] str;
		for(int i=0; i<dictionary.length; i++){
			
			str = dictionary[i].toCharArray();
			if(StringUtils.compare(dictionary[i], dosth(str, boggle))==0){
				System.out.println(dosth(str ,boggle));
			}
			
		}
	
	}

	static String dosth(char [] str,  char [][] goggle){
		int r = goggle.length;
		int c = goggle[0].length;
		int i=0;
		String storedString = "";
		int storePerviousR = 0;
		int storePerviousC = 0;
		boolean isBreak = false;
		int k=0;
		int l=0;
		
		for(int h=0; h<goggle.length; h++){
			for(int j=0; j<goggle[h].length; j++){
				if(goggle[h][j]==str[i]){
					 storedString =  storedString+goggle[h][j];
					 storePerviousR = h;
					 storePerviousC = j;
					 k = ((storePerviousR-1)%r);
					 l = ((storePerviousC-1)%c);
					 i++;
					 isBreak = true;
					 break;
				}
			}
			if(isBreak == true){
				break;
			}
		}
		if(StringUtils.isEmpty(storedString)==true){
			return null;
		}
		isBreak = false;
		int orK = k;
		int orL = l;
		
		int lengthI= r+orK;
		int lengthJ= c+orL;
		boolean nextChar = false;
		while(k<(lengthI)){
			if(k<0){
				k++;
			}else{
				while(l<lengthJ){
					if(l<0){
						l++;
					}else if(l>=goggle[0].length){
						k ++;
						l = ((storePerviousC-1)%c);
					} else if(i>=str.length){
						return storedString;
					}else if(goggle[k][l]==str[i]&& ((k!=storePerviousR)||(l!=storePerviousC))){
						storedString = storedString+goggle[k][l];
						storePerviousR = k;
						storePerviousC = l;
						lengthI = r+ ((storePerviousR-1)%r);
						lengthJ = c+ ((storePerviousC-1)%c);
						l = ((storePerviousC-1)%c);
						k = ((storePerviousR-1)%r);
						nextChar = true;
						i++;
					
						break;
					}else{
						l++;
					}
				}
			}
			if(nextChar == true ){
				nextChar = false;
			}
			if(l==lengthJ){
				k++;
				l = ((storePerviousC-1)%c);
			}
			
		}
		return storedString;

	}
	
	static boolean compare(char c, char str){
		return true;
	}
}


public class GivenaMatrix {
	/*
	 Given a matrix of O and X, replace O with X if surrounded by x 
	 considered to be surrounded by X if there are X at location 
	 just below, above left and right of it 
	 */
	
	
	public static void main(String [] args ){
		char [][] input = {{'X', 'O', 'X', 'X', 'X', 'X'},
				{'X', 'O', 'X', 'X', 'O', 'X'},
				{'X', 'X', 'X', 'O', 'O', 'X'},
				{'O', 'X', 'X', 'X', 'X', 'X'},
				{'X', 'X', 'X', 'O', 'X', 'O'},
				{'O', 'O', 'X', 'O', 'O', 'O'}};
		
		//input = search(input);
		
		//other way
		//remain the O if it is on the edge 
		input = search2(input);
		
		for (int i=0; i<input.length; i++){
			for(int j=0; j<input[i].length; j++){
				System.out.printf(" %c",input[i][j]);
			}
			System.out.println();
		}
	}
	
	public static char [][] search2(char[][]input){
		
		// change the edge
			for(int j=0; j<input[0].length; j++){
				if(input[0][j]=='O'){
					int i =0;
					while(i<input.length){
						if(input[i][j]=='O'){
							input[i][j] = 'Y';
						}
						i++;
					}
				}
			}
			
			for(int j=0; j<input[(input.length-1)].length; j++){
				if(input[0][j]=='O'){
					int i =0;
					while(i<input.length){
						if(input[i][j]=='O'){
							input[i][j] = 'Y';
						}
						i++;
					}
				}
			}
			for(int i=0; i<input.length; i++){
				if(input[i][0]=='O'){
					int j =0;
					while(j<input[i].length){
						if(input[i][j]=='O'){
							input[i][j] = 'Y';
						}
						j++;
					}
				}
			}
			
			for(int i=0; i<input.length; i++){
				if(input[i][(input[i].length-1)]=='O'){
					int j =input[i].length-1;
					while(j>=0){
						if(input[i][j]=='O'){
							input[i][j] = 'Y';
						}
						j--;
					}
				}
			}
			
		input = changeInside(input);
		return input;
	}
	
	private static char [][] changeInside(char [][] input){
		for (int i=0; i<input.length; i++){
			for(int j=0; j<input[i].length; j++){
				
				if(input[i][j]=='O'){
					input[i][j]= 'X';
				}
				if(input[i][j]=='Y'){
					input[i][j]= 'O';
				}
				
			}
		}
		return input;
	}
	public static char [][] search(char [][] input ){
		for (int i=0; i<input.length; i++){
			for(int j=0; j<input[i].length; j++){
				if(input[i][j]=='O'){
					if(detect(input, i,j)==true){
						input[i][j] = 'X';
					}
				}
			}
		}
		
		return input;
	}
	
	private static boolean detect(char[][] input, int i, int j ){
		int originalIndexI = i;
		int originalIndexJ = j;
		boolean surroundX = false;
		while(i>=0){
			if(input[i][j]=='X'){
				surroundX = true;
				break;
			}else{
				surroundX = false;
			}
			i--;
		}
		if(surroundX == false){
			return surroundX;
		}
			i = originalIndexI;
			while(i<input.length){
				if(input[i][j]=='X'){
					surroundX = true;
					break;
				}else{
					surroundX = false;
				}
				i++;
			}
			if(surroundX == false){
				return surroundX;
			}
			i = originalIndexI;
			while(j>=0){
				if(input[i][j]=='X'){
					surroundX = true;
					break;
				}else{
					surroundX = false;
				}
				j--;
			}
			if(surroundX == false){
				return surroundX;
			}
			j = originalIndexJ;
		
			while(j<input[0].length){
				if(input[i][j]=='X'){
					surroundX = true;
					break;
				}else{
					surroundX = false;
				}
				j++;
			}
		
		return surroundX;
	}
}

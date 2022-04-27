
public class Sudoku2 {
	static int  [][] grid ={ 
			//i / 3
			// j / 3
			//00       03       06 
			 {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
	         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
	         {0, 8, 7, 0, 0, 0, 0, 3, 1},   
	         {0, 0, 3, 0, 1, 0, 0, 8, 0}, //03
	         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
	         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
	         {1, 3, 0, 0, 0, 0, 2, 5, 0}, //06
	         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
	         {0, 0, 5, 2, 0, 6, 3, 0, 0} };
	
	static int count = 0;
	static int current = 0 ;
	static int [] row = new int [(grid.length)*(grid.length)];
	static int [] column = new int [(grid.length)*(grid.length)];
	static int [] storedNumber = new int [(grid.length)*(grid.length)];
	static  boolean [][] modiftiedfail =
		
		{{false, false, false, false ,false , false , false ,false, false},
	{false, false, false, false ,false , false , false ,false, false },
	{false, false, false, false ,false , false , false ,false, false },
	{false, false, false, false ,false , false , false ,false, false },
	{false, false, false, false ,false , false , false ,false, false },
	{false, false, false, false ,false , false , false ,false, false },
	{false, false, false, false ,false , false , false ,false, false },
	{false, false, false, false ,false , false , false ,false, false },
	{false, false, false, false ,false , false , false ,false, false }};
	
	
	Sudoku2(){
		
	}
	public static void main(String []args){
		Sudoku2 s = new Sudoku2();
		
		int lastOne = count;
		int u=1;
		for (int i = 0; i<grid.length; ){
			for (int j=0; j<grid.length;){
				if(solve(i , j, u)==true){
					j++;
					u=1;
				}else{
					System.out.println("(before reduces) count: "+ count);
					count = count -1 ;
					i=row[count];
					j=column[count];
					System.out.println("(after reduces) count: "+ count);
					System.out.println("row[count]: "+row[count]);
					System.out.println("column[count]: "+column[count]);
					grid[i][j]=0;
					modiftiedfail[i][j] = true;
					u=storedNumber[count]+1;
					storedNumber[count]= 0;
					System.out.print("i: "+i+", j "+j);
					System.out.println(" stored(now): "+grid[i][j]);
					printArray();
				}
			}
			i++;
		}
		

		printArray();
	}
	
	public static boolean solve(int i, int j, int u){

				if(grid[i][j]==0 || modiftiedfail[i][j]==true){
					while(u<10){
						if(loopRow(u,j)==true){
							if(loopColumn(u,i)==true){
								if(loopGrid(u, i, j)==true){
									System.out.println(u+" has no collision ");
									modiftiedfail[i][j]=false;
									grid[i][j] = u;
									row[count]=i;
									column[count]=j;
									storedNumber[count] = u;
									System.out.println("storedNumber[count] "+ storedNumber[count]);
									System.out.println("(before) count: "+ count);
									System.out.println("row[count] "+row[count]);
									System.out.println("column[count] "+column[count]);
									count++;
									System.out.println("count: "+ count);
									break;
								}
							}
						}
 						u++;
					}
					if(u==10){
						System.out.println("There is no valid number");
						return false;
					}
				}
					return true;
		
	}
	public static boolean loopRow(int numberToPutInTo, int j){
		for(int i=0; i<grid.length; i++){
			if(numberToPutInTo == grid[i][j]){
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean loopColumn(int numberToPutInTo, int i){

		 for(int j=0; j<grid[i].length; j++){
			if(numberToPutInTo == grid[i][j]){
				return false;
			}
		}
		return true;
	}
	
	public static boolean loopGrid(int numberToPutInTo, int i, int j ){
		int nextGridRow = 0;
		int nextGridColumn = 0;
		nextGridRow = (i/3)*3;
		nextGridColumn = (j/3)*3;
		int lengthOfRow = getLength(nextGridRow);
		int lengthOfColumn = getLength(nextGridColumn);
		System.out.println("i: "+ i);
		System.out.println("j: "+ j);
		System.out.println("lengthOfRow: "+ lengthOfRow);
		System.out.println("lengthOfColumn: "+lengthOfColumn);
		System.out.println("nextGridRow: "+nextGridRow);
		System.out.println("nextGridColumn: "+ nextGridColumn);
		for(int k=nextGridRow; k<lengthOfRow; k++){
			for(int l= nextGridColumn; l<lengthOfColumn; l++){
				System.out.println("compare grid [k][l] "+k + " , "+l+" : "+grid[k][l] +" to "+ numberToPutInTo );
				if(grid[k][l]==numberToPutInTo){
					return false;
				}
			}
		}
		return true;
	}
	
	static int getLength(int nextGrid){
		int lengthOfRow = 0;
		if(nextGrid == 0){
			lengthOfRow = 3;
		}else if(nextGrid == 3){
			lengthOfRow = 6;  
		}else {
			lengthOfRow = 9;
		}
		System.out.println(lengthOfRow);
		return  lengthOfRow;
		
	}
	
	 static void printArray(){
		 for(int i = 0; i<grid.length; i++){
				for(int j=0; j<grid.length; j++){
					System.out.print(grid[i][j]+" ");
				}
				System.out.println();
			}
	 }
}

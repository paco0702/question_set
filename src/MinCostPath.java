
public class MinCostPath {
	// Given a cost matrix cost
	// and a position (m,n) IN cost [] [] 
	// return cost of minimum cost path to reach (m,n) from (0,0)
	
	public static void main(String [] args){
		int [][] matrix = {{1, 2, 3 },
		                   {4 , 8, 2},
		                   {1, 5, 3}};
		
		int i =0; 
		int j =0; 
		
		int n = matrix.length;
		int m = matrix[0].length;
		//System.out.println(n);
		//System.out.println(m);
		
		int theMinCost = matrix[0][0];
		int theFirstOne, theSecondOne, theLastOne;
		theFirstOne = 1000000000;
		theSecondOne =  1000000000;
		theLastOne  = 1000000000;
		
		while(i!=n-1 || j!=m-1){
			//System.out.println("the Min Cost: "+ theMinCost);
			//System.out.println(i+" "+j);
			if((i+1)<n){
				theFirstOne = matrix[i+1][j];
			}else {
				theFirstOne = 1000000000;
			}
			
			if((j+1)<m){
				theSecondOne = matrix[i][j+1];
			}else{
				theSecondOne =  1000000000;
			}
			
			if(((i+1)<n) && ((j+1)<m)){
				theLastOne = matrix[((i+1)%n)][((j+1)%m)];
			}else{
				theLastOne  = 1000000000;
			}
			
			//System.out.printf("TheFirstOne: %d TheSecondOne: %d TheLastOne: %d \n", theFirstOne, theSecondOne, theLastOne);
			theMinCost = getMin(theFirstOne, getMin(theSecondOne, theLastOne))+theMinCost;
			
			if(getMin(theFirstOne, getMin(theSecondOne, theLastOne))== theFirstOne){
				i = i+1;
			}else if(getMin(theFirstOne, getMin(theSecondOne, theLastOne)) == theSecondOne){
				j = j+1;
			}else{
				i = (i+1);
				j = (j+1);
			}
			
		}
		
		//System.out.println("The Min Cost Path to ");
		System.out.println(theMinCost);
	}
	// sec 0.12
	public static int getMin(int a, int b){
		if(a>b){
			return b;
		}
		else 
			return a;
	}
}


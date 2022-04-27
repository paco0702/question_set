
public class Knapsack {
	//given weights and values of n items 
	//put these items in a knapsack of capacity W 
	//to get the Maximum total value in the knapscak
	// 2 integer arrays val[0..n-1] wt[0..n-1]
	// val represents the value and wt represent weights 
	// they associate n items respectively 
	//find out the maximum value subset of val 
	//                   such that sum of the wt of this subset is smaller 
	//									than or euqal to W 
	// Given Integer W is represents knapsack capacity 
	
	
	
	public static void main(String [] args){
		int [] value = {60,100,120};
		int [] weight = {10, 20, 30};
		
		int valueCompareTo = 50;
		
		System.out.println("the solution is "+ findMax(value, weight, valueCompareTo));
		
		
		
		
	}
	
	static int max(int a, int b){
		return (a >b)?a:b;
	}
	
	public static int findMax(int [] value, int [] weight, int valueCompareTo){
		int n = value.length;	
		int [][] combination = new int [n+1][valueCompareTo+1];
		int  MaxValue=  0;
		// weights kept as the rows (the one used to compare )  i    wi
		// 1 to W is columns (j) 
		
		
//		for(int i =0; i<n; i++){
//			for(int j=0; j<ValueCompareTo; j++){
//				if(j==0 || i==0){
//					combination [i][j]=0;
//				}else if(weight[i-1]<j){                   
//					combination[i][j] = max(combination[i-1][j-weight[i-1]]+value[i-1], 
//							combination[i-1][j]);   
//					
//				}else{
//					combination [i][j]= combination[i-1][j];
//				}
//			}
//		}
		/*
		 * Let weight elements = {10, 20, 30}
			Let weight values = {60, 100, 120}
			Capacity = 50
		 */
		for(int i=0 ; i<=n; i++){
			
			for (int j =0 ; j<=valueCompareTo; j++){
				if(i==0||j==0){
					combination [i][j] = 0;
					System.out.print(combination[i][j]+" ");
					// j is the value of valueCompareTo == 50 
					/*
					weight[0] = 10;
					if weight[i-1]<j  
					until j loop to 11, can enter the if statement
					j - weight[i-1] when j = 11
					11 - 10 = 1 
					combination[i-1][1] when j can be entered 
					combination[0][1]+value[0] , combination [0][11]
					
					if weight[i-1]<=j 
					until j loop to 10, can enter the if statement
					j - weight[i-1] when j = 10
					10 - 10 = 0
					combination[i-1][0] when j can be entered 
					combination[0][0]+value[0] , combination [0][11]
					0+60, 0 
					
					if j = 20 
					weight[2-1] = 20 <= j = 20 
					j can enter 
					j-weight[i-1] < j 
					20 - 20 = 0 
					combination[2-1][0] when j can be entered 
					combination[2-1][0] when can j be created 
					comhbinatio [1][0] + value[1] , combination[0][20]
					0 + 100 compare to 60 
					
					
					when the column with the weight but not value 
					and compare the you entwer can compare it to value and the 
					upper value it stored 
					
					*/
				}else if(weight[i-1]<=j ) {
					// j == i == 1 can already enter 
					combination[i][j] = max(value[i-1]+combination[i-1][j-weight[i-1]],combination[i-1][j]) ;
					// 
					MaxValue = combination[i][j];
					System.out.print(MaxValue+" ");
				}else{
					combination[i][j] = combination[i-1][j];
					MaxValue = combination[i][j];
					System.out.print(MaxValue+" ");
				}
			}
			System.out.println();
		}
//		int [] combination = new int [value.length*weight.length];
//		int MaxValue = 0;
//		combination [0] = weight[0]+weight[1]+weight[2];
//		
//		if(combination[0]>MaxValue && combination[0]<=W){
//			MaxValue = combination[0];
//		}
//		for(int i =1; i<=value.length; i++){
//			combination[i] = weight[(i%3)]+weight[(i+1)%3];
//			if(combination[i]>MaxValue && combination[i]<=W){
//				MaxValue = combination [i];
//			}
//			
//		}
//		
		return combination[n][valueCompareTo];
	}
}

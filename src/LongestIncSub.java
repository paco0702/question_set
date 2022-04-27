
public class LongestIncSub {
	// example problem that can be solved using DP 
	// LIS longest increasing subsequence to find the length of the longest
	//subsequence of a given sequence such that all elements of the subsequence
	//are sorted in increasing order 
	//
	public static void main(String [] args	){
		int [] sequenceOfNum =  { 10, 22, 9, 33, 21, 50, 41, 60 };
		int [] subsequence = new int [sequenceOfNum.length];
		subsequence [0] = sequenceOfNum[0];
		
		int j = 0;
		int count = 1;
		for(int i=0; i<sequenceOfNum.length; i++){
			if(subsequence[j]<sequenceOfNum[i]){
				j++;
				subsequence[j] = sequenceOfNum[i];
				System.out.print(subsequence[j]+" ");
				count++;
			}
		}
		
//		int [] sequenceOfNum = {3, 10, 2, 1 ,20};
//		int [] LIS = {1, 1, 1,1};
		System.out.println("The length longest length of SubSequence is "+count	);
		
		
	}
	
	
}

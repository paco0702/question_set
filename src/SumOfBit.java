import org.apache.commons.lang3.StringUtils;

public class SumOfBit {
	/*
	 Given an integer array of n integers, find sum of bit 
	 differences in all pair that can be formed from array elemets
	 bit different of a pair (x,y) is count of different bits at 
	 same positions in binary representations of x and y 
	 for example, bit different for 2 and 7 is 2 
	 binary representaions of 2 is 010 
	 and 7 111
	 */
	static int [][] differences;
	
	public static void main(String [] args ){
		//System.out.println(Integer.toBinaryString(2));
		String bit = Integer.toBinaryString(2) + "";
		bit = StringUtils.leftPad((bit)+"", 3, "0");
		//System.out.println(StringUtils.leftPad((bit)+"", 3, "0"));
		String bit2 = Integer.toBinaryString(7) + "";
		bit2 = StringUtils.leftPad((bit2)+"", 3, "0");
		
		//System.out.println(bit2.compareTo(bit));
		//System.out.println(StringUtils.leftPad((bit)+"", 3, "0"));
		
		
//		int [] input = {1,2};
//		System.out.println(begin(input));
		int [] input2 = {1,3,5};
		System.out.println(begin(input2));
	}
	
	public static int begin(int [] input){
		String [] inputBit = new String [input.length];

		String bit = "";
//		for(int i =0; i<matrix.length; i++){
//			bit = Integer.toBinaryString(input[i]) + "";
//			inputBit [i] = StringUtils.leftPad((bit)+"", 3, "0");
////			System.out.printf("%s ",inputBit[i]);
////			System.out.println();
//			for(int j=0; j<matrix[i].length; j++){
//				bit = Integer.toBinaryString(input[j]) + "";
//				matrix[i][j] =  StringUtils.leftPad((bit)+"", 3, "0");
//				if(matrix[i][j].compareTo(inputBit[i])==0){
//					differences[i][j]=0;
//					System.out.printf("%d ", 0);
//				}else{
//					System.out.printf("* ");
//				}
//				//System.out.printf("%s ",matrix[i][j]);
//			}
//			System.out.println();
//		}
//		
//		
		int [] different = new int [input.length];
		for(int i =0; i<input.length; i++){
			bit = Integer.toBinaryString(input[i%input.length]) + "";
			bit = StringUtils.leftPad((bit)+"", 3, "0");
			inputBit[i]= bit;
		}
	
		for(int i=0; i<inputBit.length; i++){
			int sum = 0;
			for(int j=0; j<inputBit[0].length(); j++){
				System.out.println(inputBit[(i%inputBit.length)].charAt(j));
				System.out.println(inputBit[(i+1)%inputBit.length].charAt(j));
				if(inputBit[(i%inputBit.length)].charAt(j)!=inputBit[(i+1)%inputBit.length	].charAt(j)){
					sum++;
				}
			}
			different[i] = sum;
		}
		
		int sum = 0;
		for(int i=0; i<different.length; i++){
			sum = sum + different[i];
			//System.out.println(different[i]);
		}
		
		return sum;
	}
	
}

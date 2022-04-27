
public class UglyNumber {
	public static int Max = 150;
	
	int getNthUglyNo(int n){
		
	int uglyNum[] = new int[Max];  
		
        int i2 = 0, i3 = 0, i5 = 0; 
        int next_multiple_of_2 = 2; 
        int next_multiple_of_3 = 3; 
        int next_multiple_of_5 = 5; 
        int next_ugly_no = 1; 
        
        uglyNum [0] = 1;
        
        for(int i=1; i<Max; i++){
        	next_ugly_no = Math.min(next_multiple_of_2, 
        			Math.min(next_multiple_of_3, next_multiple_of_5));
        	/*
        	 next_ugly_no == 2  i==1 
        	 next_ugly_no == 3 (min 3 , 4 , 5 ) i==2
        	 next_ugly_no == 3 (min 6 , 4 , 5 ) i==3
        	 */
        	
        	uglyNum[i] = next_ugly_no; 
        	/*
        	 uglyNum[1] = 2
        	 uglyNum[2] = 3
        	/*
        	 
        	 i2 = i2(0) + 1  = 1 
        	 i2 = 1
        	 next_multiple_of_2 = 2*2 = 4
        	 next_multiple_of_2 = 4
        	 
        	 i = 2 next ugly no == 3 
        	 next_ugly_no==next_multiple_of_3 == 3
        	 i3 = i3 +1  = 0+1 = 1  
        	 next_mutiples of _3 == 2*3 ==6
        	 
        	 
        	 
        	 */
        	if(next_ugly_no==next_multiple_of_2){
        		i2 = i2+1;
        		next_multiple_of_2 = uglyNum[i2]*2;
        	}
        	if(next_ugly_no==next_multiple_of_3){
        		i3 = i3+1;
        		next_multiple_of_3 = uglyNum[i3]*3;
        	}
        	if(next_ugly_no==next_multiple_of_5){
        		i5 = i5+1;
        		next_multiple_of_5 = uglyNum[i5]*5;
        	}
        }
        
        return next_ugly_no;
	}
	public static void main(String [] args){
		 int n = 150; 
	        UglyNumber obj = new UglyNumber(); 
	        System.out.println(obj.getNthUglyNo(n)); 
	}
}

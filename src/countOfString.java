
public class countOfString {
	public static void main(String [] arg){
		// count of string that can be formed using a, b, and c under
		// give constraints
		
		// given a length n, 
		//count the number of strings of length n that can be made using
		// 'a' 'b' and 'c' with most one 'b' and two 'c' s allowed 
		
		/*

		 
		 3p1 (abc) 2p1   2p1
		 2p1 (ac   3p1   2p1
		 2p1 ac    2p1   2p1
		 */
		int nf = getF(3);
		System.out.println(nf);
		int nrf = getF((3-1));
		System.out.println(nrf);
		double nPr = nf/nrf;
		System.out.println(nPr);
		
		int nf2 = getF(2);
		int nrf2 = getF((2-1));
		double nPr2 = nf2/nrf2;
		System.out.println(nPr2);
		double oneRow = nPr2*nPr2*nPr;
		System.out.println(oneRow);
		
		int possibleCombination = 3*3*3;  // 27 
		
		
//		int nf3 = getF(3);
		
	
		double result = (1.0/2.0)*(1.0/2.0)*(1.0/3.0);
		System.out.println(result*3);
		
		/*
		 
		 1/3 1/3 1/3 aaa
		 1/3 1/3 1/3 acc cca cac caa aca aac 
		 1/3 1/2 1/2 baa bcc bac bca abc cba aba cbc aab ccb acb cab 
		 
		 
		*/
		/*
		 ccc 1 1p1
		 bbb 1 1p1
		 cbb bcb bbc (3c1*3c1*3c1) * 6 
		 abb bab bba 
		 3p2 = 6 
		 1p1 + 3p2 +1p1 
		 3*3*3 - 8
		 
		 
		 if n = 4 
		 4p2 = 12 
		 4p3 = 24 
		 14 
		 3*3*3*3  = 81 
		 242
		 */
	}
	
	public static int getF(int a){ 
		int fa = a;
		int F;
		for(int i=1; i<a; i++){
			fa = fa*(a-1);
			a = a-1;
			//System.out.println(fa);
		}
		//System.out.println(fa);
		return fa;
	}
}

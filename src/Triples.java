
// class linkedList{
//		class Node{
//			int [] tripletsSet = new int [3];
//			Node next;
//			Node prev;
//			
//			Node(int [] tripletsSet){
//				this.tripletsSet = tripletsSet;
//				this.next = null;
//				this.prev = null;
//			}
//			
//			Node (int a, int b, int c){
//				int [] theSet = {a,b,c};
//				this.tripletsSet = theSet;
//				this.next = null; 
//				this.prev = null;
//			}
//			Node(){
//				this.tripletsSet = new int [3];
//				this.next = null;
//				this.prev = null;
//			}
//		}
//		
//		Node head;
//		Node last = new Node();
//		Node currentNodePointer = new Node();
//		int count=0;
//		
//		public linkedList(){
//			head = new Node();
//			head.next = null;
//			currentNodePointer = new Node();
//			currentNodePointer.next = null;
//		}
//		
//		public void insert(int a, int b, int c){
//			if(isEmpty()==true){
//				head = new Node(a,b,c);
//				head.next = null;
//				currentNodePointer.next = head;
//				count = count +1;
//			}else {
//				
//				Node newNode = new Node(a, b, c);
//				newNode.next = head.next;
//				head.next = newNode;
//				currentNodePointer.next = newNode;
//				count = count +1;
//				
//			}
//		}
//		
//		public void push(){
//			if(isEmpty()==true){
//				System.out.println("there is nothing in the list.");
//			}else{
//				Node node = head;
//				System.out.println("sum of these numbers equals to 0");
//				while(node!=null){
//					System.out.print("{ ");
//					for(int i =0; i<node.tripletsSet.length; i++){
//						System.out.print(" "+node.tripletsSet[i]+" ");
//					}
//					System.out.print(" }");
//					node = node.next;
//				}
//			}
//		}
//		
//		boolean isEmpty(){
//			if(count==0){
//				return true;
//			}else {
//				return false;
//			}
//		}
//	}

class MergeSort{
	// first merge call will be 
	// call the merge function arr, 0, 0, 1 (12 11 involved)
	void merge(int arr[], int l, int m, int r){
		//Find sized of two subarrays to merged
		int n1 = m-l+1;   // 1
		int n2 = r-m;     // 1 
		
		int L[] = new int [n1];
		int R[] = new int [n2];
		
		// copy the data to the new array 
		 for (int i = 0; i < n1; ++i){
			 L[i] = arr[l + i]; 
		 } 
		 // L[0] = 12
	     for (int j = 0; j < n2; ++j) {
	          R[j] = arr[m + 1 + j];  // 0+ 1 + 0  
	     }
	     // R[0] = 11 
	     
	     int i = 0, j = 0; 
	     
	     int k = l; 
	        while (i < n1 && j < n2) { // 0<1 and 0<1
	            if (L[i] <= R[j]) {  // L[0] (12) <= R[0] (11) false
	                arr[k] = L[i];    // R[0] is smaller
	                i++; 
	            } 
	            else {              
	                arr[k] = R[j];   // arr[0] == R[0] smaller the first 
	                j++;              
	            } 
	            k++; 
	        }
	        // not true 
	  
	        /* Copy remaining elements of L[] if any */
	        while (i < n1) { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        /* Copy remaining elements of R[] if any */
	        while (j < n2) { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	     
	}
	
	
//               array,   0,    arr.length-1
	void sort(int arr[], int l, int r){
		if(l<r){              // { 12, 11, 13, 5, 6, 7 };
			// find middle point 
			int m = (l+r)/2;
			
			// first to middle
			sort(arr, l, m);
			// middle+1 to last 
			sort(arr, m+1, r);
			
			merge(arr, 1, m, r);
		}
	}
	// first try will be cut the original array into half
	// then seperate two array to do 
	// first column to middle  0 --- 2
	     // 12 11 13 
	     // 0<2 is true
	        // find the second middle point 
	        //  m = 1 (0 +2 )/2  
	        //  first to the second middle  arr 0 1 to call function
	            //  0 < 1 find the third middle point   12 11
	                 // m = 0 (0+1)/2 
	                 // call function arr 0 0  12 
	                   // will be false    
	                 // call another function arr 0+1 1 
	                    // will be false to 
	                 // call the merge function arr, 0, 0, 1 (12 11 involved)
	
	
	
	        //  the second middle to second last arr 1 2 call function 
	            // 1 < 2 true , find the third middle point 
					 // m = 1 (1+2)/2
	                 //  call function arr 1 1 
	                    // will be false (which mean match to the end point)
	        //
	// second  middle +1 to last 
	     // 5 6 7 3----- 5
	     // 3
	
	
	
}
public class Triples {
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
	
	public static void main(String [] args){
		/*
		
		// Given an array of distinct elements
		// the task is to find triplets in the array whose sum is zero 
		
		int [] arr = {0, -1 ,2 , -3, 1};
		int r = 3;
		int rf = 3*2*1;
		int n = arr.length;
		int [] storer = new int [n-1];
		int nf;
		nf = getF(n);
		//System.out.println(nf);
		
		int possibleAnswer = 0;
		int nr = getF((n-r));
		//System.out.println(nr);
		possibleAnswer = nf/(rf*nr);
		
		linkedList newList = new linkedList();
		
//		int firstOne = arr[0] + arr [1] + arr [2] ;  // 012
//		firstOne = arr[0] + arr [3] + arr [4] ; // 034
//		 
//		firstOne = arr[1] + arr [2] + arr [3] ; // 123
//		firstOne = arr[1] + arr [4] + arr [0] ; // 140
//		
//		firstOne = arr[2] + arr [3] + arr [4] ; // 234
//		firstOne = arr[2] + arr [0] + arr [1] ; // 201
//		
//		firstOne = arr[3] + arr [4] + arr [0] ; // 340 
//		firstOne = arr[3] + arr [1] + arr [2] ; // 312 repeated 
//		
//		firstOne = arr[4] + arr [0] + arr [1] ; // 401
//		firstOne = arr[4] + arr [2] + arr [3] ; // 423
		
//		int SecNum =0;
//		int ThrNum =0;
//		int ForNum =0;
//		int FifNum =0;
		boolean FirstRow;
		boolean SecondRow;
		
		for(int j =0; j<(n-1); j++){
			storer[j]=0;
		}
		
		for(int i = 0; i<n; i++){
			System.out.println("The "+ (i+1) + " attemp");
			int SecNum = i+1;
			int ThrNum = i+2;
			int ForNum = i+3;
			int FifNum = i+4;
			
			
			SecNum =  checkOver(SecNum, n);
			ThrNum =  checkOver(ThrNum, n);
			ForNum =  checkOver(ForNum, n);
			FifNum =  checkOver(FifNum, n);
			
			System.out.println(i+""+SecNum+""+ThrNum+": ");
			FirstRow = getTriple(arr[i], arr [SecNum], arr [ThrNum]);
			System.out.println(FirstRow);
			//012
			//123
			//234
			//345
			//456  5-5 =0 6 - 5 = 1   // 4 0 1 
			//567  
			System.out.println(i+""+ForNum+""+FifNum +": ");
			SecondRow = getTriple(arr [i], arr [ ForNum], arr[FifNum]);
			System.out.println(SecondRow);
			//034
			//145  5 -5 =0   // 1 4 0
			//256  5-5 = 0 6-5=1  // 2 0 1 
			//367  6-5 = 1  7-5 = 2  // 3 1 2 
			//478  7-5 = 2  8-5 = 3 
			if(FirstRow==true){
				newList.insert(arr[i], arr [SecNum], arr [ThrNum]);
			}
			
			if(SecondRow==true){
				newList.insert(arr [i], arr [ ForNum], arr[FifNum]);
			}
		}
		//System.out.println(possibleAnswer);
		
		newList.push();
		
	}
	
	public static boolean getTriple(int a, int b, int c){
		if((a+b+c)==0){
			return true;
		}else 
			return false;
	}
	
	public static int getF (int n){
		int F = n;
		for(int i =1; i<n; i++){
			F=F*(n-i);
		}
		return F;
	}
	
	public static int checkOver(int TheNumber, int n){
		int token = TheNumber;
		if((TheNumber)>(n-1)){
			token = TheNumber -n;
		}
		return token;
	}
	*/

	    int arr[] = {0, -1, 2, -3, 1}; 
	    int n =arr.length; 
	    
	    MergeSort ms = new MergeSort();
	    
	    ms.sort(arr, 0,  n-1);
	    
	   // printArray(arr);
	    int b = 0;
	    int e = arr.length-3;
	    
	    for(int i =0; i<n; i++){
	    	int secondIndex = i+1;
	    	if(secondIndex>4){
	    		secondIndex = secondIndex%arr.length;
	    	}
	    	int sum = arr[i]+arr[secondIndex];
	    	for(int j=0; j<n-2;j++){
	    		int index = e+j;
	    		if((index)>4){
	    			index = index%arr.length;
	    		
	    			if(sum+arr[index]==0){
		    			System.out.println(arr[i]+" "+arr[secondIndex]+" "+arr[index]);
		    		}
	    		}else{
	    			if(sum+arr[index]==0){
		    			System.out.println(arr[i]+" "+arr[secondIndex]+" "+arr[index]);
		    		}
	    		}
	    	}
	    	e++;
	    }
	}
	
	 
}



class MergeS {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
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
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
 
    /* A utility function to print array of size n */
     void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
  
}
public class CoinChange {
	public static void main(String []args){
		// Given a value N
		// If we want to make change for N cents,
		// and we have infinite supply of each of S = {S1, S2, .... Sm}
		// how many ways can we make the change
		// N=4 and S = {1, 2, 3}
		// There are four solutions [1,1,1,1} {1,1,2} {2,2} {1,3}
		// N=10 {2,5,3,6} 
		// out put should be 5
		int N = 10;
		int [] number = {2, 5, 3,6};
		int [] orderedNumber = new int [number.length];

        int arr[] = { 12, 11, 13, 5, 6, 7 };
        MergeS ob = new MergeS();
        
        ob.sort(arr, 0, arr.length - 1);
        ob.sort(number,0, number.length-1);
		for(int i =0; i<number.length; i++){
			System.out.println(number[i]);
		}
		
		int [][] str = new int [10][10];
		int [] record = new int [10];
		int sum = 0;
		
		int i = 0;
		int j =0;
		int count = 0;
		int k =0;
		while( k<number.length){
			sum = sum + number[k];
			record [j] = number[k];
			if(sum == N){
				str [i] = record;
				i++;
				count++;
				sum = 0;
				k++;
				j=-1;
				record = new int [10];
			}else if(sum >N){
				sum = 0;
				k++;
				j=-1;
				record = new int [10];
			}
			j++;
		}
		
		sum =0;
		int eachsum = 0;
		j=0;
		k=0;
		int r = 0;
		while(k<number.length){
				int getnumber =number[(r+1)%4];
				sum = sum + number[r%4];
				eachsum = eachsum + number[r%4];
				record [j] = number[r%4];
				if(eachsum>number[(r+1)%4]){
					r++;
					eachsum = 0;
				}
			
			if(sum==N){
				str [i]= record;
				i++;
				count ++;
				sum = 0;
				eachsum = 0;
				k++;
				r=k;
				j=-1;
				record = new int [10];
			}else if(sum >N){
				sum = 0;
				eachsum = 0;
				k++;
				r=k;
				j=-1;
				record = new int [10];
			}
			j++;
				
		}
		
	}
}

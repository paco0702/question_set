import java.util.Stack;

// count sort
public class SortAStack {
	static Stack s = new Stack();
	static Stack copiedS = new Stack();
	static int [] stored = new int [11];
	static int [] outPutArray;
	static int lastElementIndex;
	static int [] negativeStorer;
	static int negativeCount = 0;
	static int smallestIndexSave = 5;
	public static void main(String [] args){
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);
		copiedS = s;
		outPutArray  = new int [s.size()+1];
		negativeStorer = new int [s.size()+1];
		outPutArray[1]=(int)s.pop();
		outPutArray[2]=(int)s.pop();
		outPutArray[3]=(int)s.pop();
		outPutArray[4]=(int)s.pop();
		outPutArray[5]=(int)s.pop();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);
		lastElementIndex = outPutArray.length;
		look(1);
		 
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
	}
	
	
	
	
	public static void look(int index){
		if(index == -1){
			return;
		}
		System.out.println("index: "+ index);
		int originalData = (int) s.pop();
		String digit = String.valueOf(originalData).charAt(index)+"";
		
		if(digit.compareTo("-")==0){
			negativeCount ++;
			negativeStorer [negativeCount] = originalData;
			System.out.println("index ("+negativeCount+") have the value of "+ originalData);
			
		}else{
		
		stored = new int [11];
		int storedData = Integer.parseInt(digit);
		index =  look(index ,storedData);
		System.out.println("index: "+ index);
		}
		
		System.out.println("negative Count :"+ negativeCount);
		if(negativeCount > 0){
			System.out.println("stored[0]:"+stored[0]);
			System.out.println("negativeCount +" +(stored[0] +negativeCount));
			stored[0]= negativeCount;
		}
	
		cumulative(1);
		s.push(outPutArray[5]);
		s.push(outPutArray[4]);
		s.push(outPutArray[3]);
		s.push(outPutArray[2]);
		s.push(outPutArray[1]);
		//System.out.println(index+1);
		
		// renew the save after the recursive
		smallestIndexSave = lastElementIndex;
		sort(index+1);
		System.out.println("the smalles index after sorting is "+ smallestIndexSave);
		if(negativeCount>0){
			int max = negativeCount;
			handleNegative(1, max);
		}
		s.push(outPutArray[5]);
		s.push(outPutArray[4]);
		s.push(outPutArray[3]);
		s.push(outPutArray[2]);
		s.push(outPutArray[1]);
		look(index);
	}
	
	
	
	private static int look(int index, int data){
		System.out.println(data);
		stored [data]++;
		if(s.isEmpty()){
			index --;
			return index;
		}
		int originalData= (int)s.pop();
		String digit = String.valueOf(originalData).charAt(index)+"";
		int storedData = 0;
		if(digit.compareTo("-")==0){
			negativeCount ++;
			negativeStorer [negativeCount] = originalData;
			System.out.println("index ("+negativeCount+") have the value of "+ originalData);
			storedData = 0;
		}else{
		 storedData = Integer.parseInt(digit);
		}
		return  look(index, storedData);
	}
	
	
	
	private static void cumulative (int i){
		if(i>=stored.length){
			return;
		}
		System.out.println("i: "+(i-1)+" store["+(i-1)+"] :"+stored[(i-1)]);
		stored[i] = stored[i-1] + stored[i];
		System.out.println("i: "+i+" store["+i+"] :"+stored[i]);
		i++;
		cumulative(i);
	}
	
	
	
//	private static void sort( int index){
//		if(s.isEmpty()){
//			return;
//		}
//		int originalInt = ((int)s.pop());
//		System.out.println("original integer: "+ originalInt);
//		String digit = String.valueOf(originalInt).charAt(index)+"";
//		int storedData = 0;
//		if(digit.compareTo("-")==0){
//			storedData = 10;
//		}else{
//			storedData = Integer.parseInt(digit);
//		}
//		System.out.println("comparing digit: "+ storedData);
//		System.out.println("counting array as an index for output array : "+ stored[storedData]);
//		// System.out.println("output array sortedArray [stored[storedData]]"+sortedArray [stored[storedData]]);
//		outPutArray [stored[storedData]]= originalInt ;
//		System.out.println("output array  sortedArray ["+stored[storedData]+"] "+outPutArray [stored[storedData]]);
//		stored[storedData]--;
//		sort(index);
//	}
//	
	
	private static void sort( int index){
		int originalData = ((int)s.pop());
		if(s.isEmpty()== false){
			sort(index);
		}
		System.out.println("original integer: "+ originalData);
		String digit = String.valueOf(originalData).charAt(index)+"";
		if(digit.compareTo("-")==0){
			System.out.println("It is negative sign");
			return;
		}else{
		int storedData = Integer.parseInt(digit);
		System.out.println("comparing digit: "+ storedData);
		System.out.println("counting array as an index for output array : "+ stored[storedData]);
		outPutArray [stored[storedData]]= originalData ;
		System.out.println("output array  sortedArray ["+stored[storedData]+"] "+outPutArray [stored[storedData]]);
		if(stored[storedData]<smallestIndexSave){
			smallestIndexSave = stored[storedData];
		}
		stored[storedData]--;
		return;
		}
	}
	
	private static void handleNegative(int index, int negC){
		if(index > negC){
			return;
		}else{
			smallestIndexSave --;
			int theNegativeInt = negativeStorer[index];
			System.out.println("the negativeInt is "+ negativeStorer[index] );
			outPutArray[negativeCount]= theNegativeInt;
			System.out.println("the smallestIndexSave is "+smallestIndexSave);
			System.out.println("Now the outPutArray["+negativeCount+"] is :"+ outPutArray[negativeCount]);
			index++;
			negativeCount --;
			handleNegative(index, negC);
		}
	}
}

class Node {  
	 	int data;  
	 	Node left,right;  
	 	Node parent;
	 	Node(int data){
		 	this.data=data; 
		 	
	 	}
	 	Node(){
	 		this.data = '$';
	 	}
	 }
	
public class BinaryTree {

	public static void main(String [] args){
		Node root = new Node('A');
		root.left = new Node('B');
		root.right = new Node('C');
		root.right.parent = root;
		root.left.parent = root;
		
		root.left.left = new Node('D');
		root.left.left.parent = root.left;
		root.left.right = new Node ('E');
		root.left.right.parent = root.left;
		
		root.right.right = new Node('B');
		root.right.right.parent = root.right;
		root.right.right.right = new Node('E');
		root.right.right.right.parent = root.right.right;
		root.right.right.left = new Node ('D');
		root.right.right.left.parent = root.right.right ;
		
		 getDuplicate(root);
	}
	
	public static void getDuplicate(Node root){
		// record all the subTree 
		Node [] record = new Node [8];
		
		// loop till the end 
		
		Node node = root;
		
		
		while (node.left!=null){
			node = node.left;
		}
		//System.out.println((char)node.data);
		
		int i = 0;
		while (node.parent != root && node.parent!=null){
			record[i] = node.parent;
			System.out.println((char)node.parent.data);
			node = node.parent;
			i++;
		}
		node=root;
		while (node.right!=null){
			node = node.right;
		}
		//System.out.println((char)node.data);
		while (node.parent!= root && node.parent!=null){
			record[i] = node.parent;
			System.out.println((char)node.parent.data);
			node = node.parent;
			i++;
		}
		
		System.out.println(i);
		int k=0;
		boolean isBreak = false;
		for(int j=0; j<i; j++){
			System.out.println(j%i);
			System.out.println((j+1)%i);
			if(record[j%i].data == record[(j+1)%i].data){
				Node oneNode = record[j%i].left;
				Node twoNode = record[(j+1)%i].left;
				 while(oneNode!=null || twoNode!= null){
					if(oneNode.data==twoNode.data){
						System.out.println((char)oneNode.data);
						System.out.println((char)twoNode.data);
						oneNode = oneNode.left;
						twoNode = twoNode.left;
					}else {
						isBreak = true;
						break;
					}
						 
				 }
				if(isBreak == false){
				 		oneNode = record[j%i].right;
				 		twoNode = record[(j+1)%i].right;
					while(oneNode!=null|| twoNode!= null){
					if(oneNode.data==twoNode.data){
						System.out.println((char)oneNode.data);
						System.out.println((char)twoNode.data);
						oneNode = oneNode.right;
						twoNode = twoNode.right;
					}else {
							isBreak = true;
							break;
						}
								 
					}
				}
				
				if(isBreak== false){
					System.out.println("there is duplicated sub tree");
					//return;
				}
			}
			
		}
	}
}

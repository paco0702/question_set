
public class BinarySearchTreeDuplicate {
	// Given a Binary Tree,
	// check whether the Binary tree contains a
	//     duplicate sub tree of size 2 or more 
	
	 class BinaryTree{
		 
		 class Node{
			 char data;
			 Node left;
			 Node right;
			 Node(char data){
				 this.data = data;
				 this.left = null; 
				 this.right = null;
			 }
			 Node (){
				 this.data = 0;
				 this.left = null;
				 this.right = null;
			 }
		 }
		 Node root;
		 int count = 0;
		 public boolean empty(){
			 if(count == 0){
				 return true;
			 }else 
				 return false;
		 }
		 
		 public boolean hasNoChildren(Node node){
			 if(node.left == null && node.right == null)
				 return true;
			 else return false;
		 }
		 
		 public boolean hasRight(Node node){
			 if(node.right != null)
				 return true;
			 else return false;
		 }
		 public boolean hasLeft(Node node){
			 if(node.left != null)
				 return true;
			 else return false;
		 }
		 
		 public void insert(char data){
			 if(empty()==true){
				 Node newNode = new Node(data);
				 root = newNode;
				 count++;
			 }else{
				 Node newNode = new Node(data);
				 int index=  data - 'a';
				 int valueOfRoot = root.data - 'a';
				 if( hasNoChildren(root)==true && index > valueOfRoot){
					 root.right = newNode;
				 }else if(hasNoChildren(root)==true && index < valueOfRoot){
					 root.left = newNode;
				 }else if(hasRight(root)==true && index<valueOfRoot	){
					 root.left = newNode;
				 }else if(hasRight(root)==true && index>valueOfRoot	) {
					 Node node = root.left;
					 int valueOfNode = node.data - 'a';
					 while((node.left!= null && index<valueOfNode )|| (node.right!= null && index>valueOfNode )){
						 if(index<valueOfNode){
							 node = node.left;
						 }else if(index > valueOfNode){
							 node = node.right;
						 }
					 }
				 }else if(hasLeft(root)==true && index>valueOfRoot){
					 root.right = newNode;
				 }else{
					 
				 }
			 }
		 }
		 
	 }
}

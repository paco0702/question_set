class newNode { 
    int data; 
    newNode left, right, nextRight; 
  
    newNode(int item) 
    { 
        data = item; 
        this.left = this.right = this.nextRight = null; 
    } 
} 


public class ConnectNode {
	static int countLeft = 0;
	static int countRight=0;
	static newNode [] storeLeftNode = new newNode[3];
	static newNode [] storeRightNode = new newNode[3];
	public static void main(String [] args){
		newNode root = new newNode(1);
		root.left = new newNode(2);
		root.right = new newNode(3);
		root.left.left = new newNode(4);
		root.left.right = new newNode(5);
		root.right.right = new newNode(6);
		
		printPostOrder(root);
	}
	
	
	static void printPostOrder(newNode node) 
    { 
	
		
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostOrder(node.left); 
        
        // then recur on right subtree 
        printPostOrder(node.right); 
        
        // now deal with the node 
        System.out.print(node.data + " "); 
        
        
    } 
}

package BST;

public class Solution {
	/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

	The Node class is defined as follows:
	    class Node {
	        int data;
	        Node left;
	        Node right;
	     }
	*/

	    boolean checkRight(Node root, int data) {
	        if (root.data>data) { 
	            if (root.left!=null && root.right!=null)
	                return (checkLeft(root.left, root.data) && checkRight(root.right, root.data));
	            if (root.left!=null)
	                return checkLeft(root.left, root.data);
	            if (root.right!=null)
	                return checkRight(root.right, root.data);
	            return true;
	        } 
	        
	        return false;
	    }

	     boolean checkLeft(Node root, int data) {
	        if (root.data<data) {
	            if (root.left!=null && root.right!=null)
	                return (checkLeft(root.left, root.data) && checkRight(root.right, root.data));
	            if (root.left!=null)
	                return checkLeft(root.left, root.data);
	            if (root.right!=null)
	                return checkRight(root.right, root.data);
	            return true;
	        }
	        
	        return false;
	    }

	    boolean checkBST(Node root) {
	        if (root==null) return true;
	        if (root.left!=null && root.right!=null)
	                return (checkLeft(root.left, root.data) && checkRight(root.right, root.data));
	        if (root.left!=null)
	            return checkLeft(root.left, root.data);
	        if (root.right!=null)
	            return checkRight(root.right, root.data);

	        return true;
	        
	    }

}

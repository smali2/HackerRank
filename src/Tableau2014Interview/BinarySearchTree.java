// Bismillah Hirrahman Nirrahim
// This interview was held on October 27, 2014 (probably). The Google doc is on ali007@gmail.com 
// Given an int, delete that node from the tree. 

package Tableau2014Interview;

public class BinarySearchTree {

	class Node {
		int data;
		Node right;
		Node left;
		
		public Node(int d) {
			this.data = d;
		}
	}
	
	public Node findSmallest(Node child) {
		while (child.left!=null) {
			child = child.left;
		}
		
		if (child.right!=null) 
			return findSmallest(child.right);
		
		return child;
	}
	
	public void removeCaseTwoRight(Node parent, Node child) {
		Node temp = child.right;
		parent.right = temp;
		child.right = null;
	}
	
	public void removeCaseTwoLeft(Node parent, Node child) {
		Node temp = child.left;
		parent.left = temp;
		child.left = null;
	}
	
	public void removeCaseOne(Node parent, Node child) {
		if (parent.right==child) {
			parent.right = null;
		} else {
			parent.left = null;
		}
	}
	
	public void remove(int d, Node parent, Node child) {

		if (child.data==d) {
			// case 1: no child
			if (child.left==null && child.right==null) {
				removeCaseOne(parent, child);
				return;
			}
			
			// case 2: one child
			if (child.right!=null) {
				removeCaseTwoRight(parent, child);
				return;
			}
			if (child.left!=null) {
				removeCaseTwoLeft(parent, child);
				return;
			}
			
			// case 3: two children
			// Step a: first find the smallest Node to the right subtree
			Node smallest = findSmallest(child);
			// Step b: Replace the values of this child and the smallest Node found
			child.data = smallest.data;
			// Step c: now delete smallest node from the right subtree
			remove(smallest.data, child.right);
			return;
		}
		
		if (child.data>d) {
			remove(d, child, child.right); 
			return;
		}
		
		if (child.data<d) {
			remove(d, child, child.left);
			return;
		}
		
	}
	// case 1: no children
	// case 2: one child
	// case 3: two children
	
	public void remove(int d, Node root) {
		int current = root.data;
		
		// case 1, root node
		if (root.left==null && root.right==null && current==d) {
			root = null; 
			return;
		}
		
		if (d>current) {
			remove(d, root, root.right);
		} else {
			remove(d, root, root.left);
		}
		
		
	}
}

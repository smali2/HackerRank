// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// This interview was held around October 28, 2014, technical phone interview.

// Question:
// Given a sorted array of floats, create binary tree of minimal height that contains all the floats.
package Tableau2014Interview;

import java.util.Arrays;

import Tableau2014Interview.BinarySearchTree.Node;

public class FloatsToBST {
	static class Node {
		float data;
		Node right;
		Node left;
		
		public Node(float input) {
			this.data = input;
		}
		
		public String toString() {
			String left;
			String right;
			
			if (this.left != null) {
				left = this.left.toString() + ", ";
			} else { 
				left = "";
			}
			
			if (this.right != null) {
				right = ", " + this.right.toString();
			} else { 
				right = "";
			}
		    StringBuffer sb = new StringBuffer();
		    sb.append(left)
		    	.append(this.data)
		    	.append(right);
		    return sb.toString();
		}

	}
	
	/// Algorithm: take start and end index, find the mid-point, and point the parent Node's child to mid-point
	public static Node createTree(int start, int end, float[] input) {
	    
	    if (end<0 || start >= input.length) return null;
	    if (start>end) return null;
	  
        int mid = (end + start) / 2;
        Node newNode = new Node(input[mid]);
        Node rightChild = createTree(mid+1, end, input);
		Node leftChild = createTree(start, mid-1, input);
		newNode.right = rightChild;
		newNode.left = leftChild;
		
		return newNode;    
	 
	}

	public static Node createTree(float[] input) {
		return createTree(0, input.length - 1, input);
	}
	/*
	public static void createTree(Node parent, int start, int end, boolean rightChild, float[] input) {
		if (end<0 || start >= input.length) return;
		
		int mid;
		Node newNode;
		if (rightChild) {
			mid = (end + start) / 2;
			newNode = new Node(input[mid]);
			parent.right = newNode;
		} else {
			mid = (end - start) / 2;
			newNode = new Node(input[mid]);
			parent.left = newNode;
		}
		
			// right subtree
		createTree(newNode, mid+1, end, true, input);
		// left subtree;
		createTree(newNode, start, mid-1, false, input);
	}
	

	}
	
	public static Node createTree(float[] input) {
		if (input.length==0) return null;
		
		if (input.length==1) {
			Node parent = new Node(input[0]);
			return parent;
		} 
		
		if (input.length==2) {
			Node parent = new Node(input[1]);
			Node child = new Node(input[0]);
			parent.left = child;
			return parent;
		}
		
		int mid = input.length / 2;
		Node parent = new Node(input[mid]);
		Node rightChild = createTree(mid+1, input.length-1, input);
        Node leftChild = createTree(0, mid-1, input);
        
	    parent.right = rightChild;
	    parent.left = leftChild;

		return parent;
	}
	*/
	
	public static void main(String[] args) {

		float[] input = {0L, 1L, 2L};
		Node root = createTree(input);
		System.out.println(Arrays.toString(input));
		System.out.println(root.toString());
		
		float[] input2 = {0L, 1L, 2L, 3L};
		Node root2 = createTree(input2);
		System.out.println(Arrays.toString(input2));
		System.out.println(root2.toString());
	}

}

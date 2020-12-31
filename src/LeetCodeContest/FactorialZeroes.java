// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// This contest was held on March 3 2018 at 9.30pm EST
// Question: 793

// Question:
// Let f(x) be the number of zeroes at the end of x!. (Recall that x! = 1 * 2 * 3 * ... * x, and by convention, 0! = 1.)
// For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has 2 zeroes at the end.
// Given K, find how many non-negative integers x have the property that f(x) = K.
package LeetCodeContest;

public class FactorialZeroes {
	
	public static int getZeroCount(int num) {
		String in = Integer.toString(num);
		
		int i = 0;
		for (i = in.length() - 1; i >= 0 ; i--) {
			if (in.charAt(i)!=0) break;
		}
		
		int count = in.length() - 1 - i;
		return count;
		
	}
	
	public static long factorial(int a) {
		
		if (a>0) {
			return a*
		}
	}
	
	public static 
	public static void main(String[] args) {
		
	}
}

// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// This contest was held on March 3 2018 at 9.30pm EST
// Question: 795

package LeetCodeContest;

public class numSubArrays {

    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        
    	int count = 0;
    	
        int i = 0;
        int inScopeCount = 0;
        while (i<A.length) {
        	// start a run
        	if (A[i]>=L && A[i]<=R) {
        		inScopeCount++;
        	}
        	if (A[i]>R) {
        		count = ((inScopeCount+2)*(inScopeCount+1))/2 + count;
        		inScopeCount = 0;
        	}
        	i++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
    	int[] A = {2,1,4,3};
    	int L = 2;
    	int R = 3;
    	
    	System.out.println(numSubarrayBoundedMax(A,L,R));
    }
}

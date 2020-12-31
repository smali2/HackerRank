// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// This interview was held around Nov 2016.
// [FB, FooBar] -> True
// [FoBa, FooBar] -> True
// [FoxBa, FooBar] -> False
// [FoBbr, FooBar] -> False
// [FEBa, FooBar] -> False

package Google2016Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ClassSearch {
	
	class Solution {
	    public int maximumProduct(int[] nums) {
	        Arrays.sort(nums);
	        int ans = 1;
	        for (int i =nums.length-1; i>nums.length-4 && i>=0; i--) {
	            ans *= nums[i];
	        }
	  
	        return ans;
	        
	    }
	}
	public static ArrayList<ArrayList<String>> buildList(String in) {
		char[] c = in.toCharArray();
		
		boolean upper = true;
		ArrayList<ArrayList<String>> lst = new ArrayList<>();
		StringBuilder sb;
		
		for (int i = 0; i < c.length; i++) {
			ArrayList<String> pair = new ArrayList<>();
			sb = new StringBuilder();
			if (Character.isUpperCase(c[i])) {
				pair.add(String.valueOf(c[i]));
				int j;
				for (j = i+1; (j<c.length) ; j++) {
					if (Character.isLowerCase(c[j])) {
						sb.append(c[j]);
					} else {
						break;
					}
				}
				i = j - 1;
				pair.add(sb.toString());
			}
			lst.add(pair);
		}
		
		return lst;
		
		
	}
	
	public static boolean matches(String pattern, String className) {
		ArrayList<ArrayList<String>> patternList = buildList(pattern);
		ArrayList<ArrayList<String>> classList = buildList(className);
		
		// check if the first char is upper in both lists
		
		boolean match = true;
		boolean upper;
		int patternPairSize;
		int classPairSize;
		for (int i = 0; i < patternList.size(); i++) { // number of Upper-Lower pairs
			upper = false;
			patternPairSize = patternList.get(i).size();
			try {
				classPairSize = classList.get(i).size();
			} catch (Exception e) {
				match = false;
				break;
			}
			
			if (patternList.get(i).get(0).equals(classList.get(i).get(0))) {
				upper = true;
			} else {
				match = false;
			}
			
			if (upper) {
				if (classList.get(i).size()>1) {
					// Compare each lowercase char of pattern in sequence 
					int pChars = patternList.get(i).get(1).toCharArray().length;
					int cChars = classList.get(i).get(1).toCharArray().length;
					char[] pl = patternList.get(i).get(1).toCharArray();
					char[] cl = classList.get(i).get(1).toCharArray();
					for (int j = 0; ((j < pChars) && (j<cChars)); j++) {
						if (pl[j]!=cl[j]) {
							match = false;
							break;
						}
					}
				}
			}
			
			if (!match) break;
					
			
		}
		return match;
	}
	
	public static void main(String[] args) {
		System.out.println(matches("Foo", "FooBar"));

		System.out.println(matches("Foo", "FooB"));

		System.out.println(matches("FB", "FooBar"));

		System.out.println(matches("Fo", "FooBar"));
		

		System.out.println(matches("FooT", "FooBarT"));

		System.out.println(matches("FooT", "FooTar"));
		
		System.out.println(matches("FoBaT", "FooBarTest"));
		
		System.out.println(matches("FoBaT", "FootBall"));
	}
}

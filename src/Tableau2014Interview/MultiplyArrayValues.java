// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// This interview was held around October 28, 2014, technical phone interview.
// I was asked this question again about a year later, on September 30 or October 1st timeframe, when I went to Waterloo University
// to give on campus interview for internship (again). Mr. Ehab from Tableau, SW Mgr, asked this question again. And I 
// was not able to clearly remember the trick to the solution at that time, although I think I got closer. Alhamdulillah.


// Question:
// Given an array of integers, produce another array of integers the same length, 
// but the values are the product of every other number in the input array, 
// except for one in the same position that you are computing.
// For example, [2,3,4] => [12,8,6]

package Tableau2014Interview;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiplyArrayValues {

	public static void main(String[] args) {
		int[] arr = {2, 3, 4};	
		
		int multiply = 1;
		
		//System.out.println(Arrays.toString(arr));
		
		for (int i : arr) {
			//System.out.println(i);
			multiply = multiply * i;
		}
		
		for (int j = 0; j < arr.length; j++) {
			arr[j] = multiply / arr[j];
		}
		
		System.out.println(Arrays.toString(arr));
	}
}

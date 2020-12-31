package Algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayManipulation {

    static long highestValue = 0;
    
    static long[] values; 
    
    public static void apply(int a, int b, long k) {
    	//System.out.println("a is: "+a);
    	///System.out.println("b is: "+b);
    	///System.out.println("k is: "+k);
        for (int i = a; i<b+1; i++) {
            values[i] += k;
            if (highestValue<values[i]) highestValue = values[i];
        }
        ///System.out.println("Done");
    }
    
    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("C:\\Users\\Ali\\workspace2\\HackerRank\\src\\Algorithms\\ArrayManipulation_input11.txt"));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        values = new long[n];
        
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            long k = in.nextInt();
            apply(a-1, b-1, k);
        }
        in.close();
        
        System.out.println(highestValue);
    }
}


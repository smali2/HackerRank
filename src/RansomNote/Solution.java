package RansomNote;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("C:\\Users\\Ali\\workspace2\\HackerRank\\src\\RansomNote\\input11.txt"));
        Scanner in = new Scanner(System.in);
        
        int m = in.nextInt();
        int n = in.nextInt();
        
        if (m<n) {
            System.out.println("No");
            return;
        }
        
        HashMap<String, Integer> magazine = new HashMap<>();
        String nextWord = "";
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            nextWord = in.next();
            if (!magazine.containsKey(nextWord)) {
                magazine.put(nextWord, 1);
            } else {
                magazine.replace(nextWord, magazine.get(nextWord)+1);
            }
        }
        
        System.out.println("Printing word counts from the magazine: ");
        for (Map.Entry<String, Integer> entry : magazine.entrySet())
            System.out.println(entry.getKey() + ": " +entry.getValue());
        System.gc();
        //HashMap<String, Integer> ransom = new HashMap<>();
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            nextWord = in.next();
            boolean check = magazine.containsKey(nextWord);
            if (!check) {
                //System.out.println("This is word: " + nextWord );
                System.out.println("No");
                return;
            } else {
                int count = magazine.get(nextWord);
                if (count > 0) {
                	System.out.println(nextWord + " / count "+ count);
                    if (count == 1) magazine.remove(nextWord);
                    count = count - 1;
                    System.out.println(count);
                    if (count > 0) magazine.replace(nextWord, count);
                }
            }
        }
        
        System.out.println("Printing word counts from the magazine again: ");
        for (Map.Entry<String, Integer> entry : magazine.entrySet())
            System.out.println(entry.getKey() + ": " +entry.getValue());
        
        System.out.println("Yes"); 
    }
}

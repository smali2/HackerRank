package CoinChange;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	 private static HashMap<String, Long> hm = new HashMap<>();
	    
	    public static long makeChange(int[] coins, int remaining, int index) {
	        if (coins.length==0) return 0;
	       	        
	        if (remaining == 0) return 1;
	        
	        if (remaining < 0) return 0;
	        
	        long ways = 0;
	        
	        String key = index + "-" + remaining;
	        if (!hm.containsKey(key)) {
                ways += makeChange(coins, remaining - coins[index], index);
                if (index+1<coins.length){ 
                	ways += makeChange(coins, remaining - coins[index+1], index+1);
                }
                hm.put(key, ways);
            } else {
                ways += hm.get(key);
            }
	        
	        return ways;
	        
	    }
	    public static long makeChange(int[] coins, int money) {
	        //int[] memo = new memo[money+1];
	    	for (int i = coins.length - 1; i >= 0; i--) {
	    		makeChange(coins, money, i);
	    	}
	        
	        long a = 0L;
	        for (Entry<String, Long> e : hm.entrySet()) {
	        	System.out.println(e.getKey()+ " : " + e.getValue());
	        }
	        for (int i = 0; i<coins.length; i++) {
	        	String key = i + "-" + money;
	        	if (hm.containsKey(key)) a += hm.get(key);
	        }
	   
	        return a;
	    }
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int coins[] = new int[m];
	        for(int coins_i=0; coins_i < m; coins_i++){
	            coins[coins_i] = in.nextInt();
	        }
	        System.out.println(makeChange(coins, n));
	    }

}

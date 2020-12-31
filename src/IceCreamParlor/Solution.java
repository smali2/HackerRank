package IceCreamParlor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Pair {
    ArrayList<Integer> id = new ArrayList<>();
    int cost;
    int count;
    
    public Pair(int i, int c) {
        this.id.add(i);
        this.cost = c;
        this.count = id.size();
    }
    
    public void addId(int id) {
        this.id.add(id);
    }
}

public class Solution {
    
    
    static void solve(int[] arr, int money) {
        // Complete this function
        
        HashMap<Integer, Pair> iceCreamMenu = new HashMap<>();
        
        int menuNumber = 1;
        
        for (int cost : arr) {
            
            // see if this cost already exists as a differential cost in the map
            if (iceCreamMenu.containsKey(cost)) {
                int firstMenuId = iceCreamMenu.get(cost).id.get(0);
                int secondMenuId = menuNumber;
                System.out.println("The cost is "+cost+" and the menu IDs are: "+firstMenuId+" "+secondMenuId);
                return;
            }
            
             
            // put the cost differential of the icecream on the map 
            int difference = money-cost;
            if (difference >= 0) {
                boolean diffExists = iceCreamMenu.containsKey(difference);
                if (diffExists) {
                    iceCreamMenu.get(difference).addId(menuNumber);
                    int itemCount = iceCreamMenu.get(difference).id.size();
                    if (itemCount==2 && difference==cost) { // return item IDs
                        StringBuffer sb = new StringBuffer();
                        for (int x : iceCreamMenu.get(difference).id) {
                            sb.append(x + " ");
                        }
                        System.out.println(sb.toString());
                        return;
                    }
                } else {
                    iceCreamMenu.put(difference, new Pair(menuNumber, cost));
                }
            }
            menuNumber++;
        }
    }

    public static void main(String[] args) throws IOException {
        
    	System.setIn(new FileInputStream("C:\\Users\\Ali\\workspace2\\HackerRank\\src\\IceCreamParlor\\input13.txt"));
    	Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            solve(arr, money);
        }
        
        
        /*
    	BufferedReader br;
    	try {

    	    String sCurrentLine;

    	    br = new BufferedReader(new FileReader("yourFolder/theinputfile.txt"));

    	    while ((sCurrentLine = br.readLine()) != null) {
    	        System.out.println(sCurrentLine);
    	    }

    	} catch (IOException e) {
    	    e.printStackTrace();
    	} finally {
    	    try {
    	        if (br != null)
    	        	br.close();
    	    } catch (IOException ex) {
    	        ex.printStackTrace();
    	    }
    	}
    	*/
        in.close();
    }
}

// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// Interviewer: Rohit (from Youtube Recommendations team). Doing downstream work for data scientists. May Allah swt guide him. ameen. Very polite guy.
// Time: Wed, March 14, 6pm

package Google2018Interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	HashMap<String, HashMap<String, Double>> ratios = new HashMap<>();
	Deque<String> toVisit = new ArrayDeque<String>();
	ArrayList<String> visitedNodes = new ArrayList<>();
	
	public void processRatios(String input) {
		Scanner in = new Scanner(input);

		while (in.hasNextLine()) {
			String[] tokens = in.nextLine().trim().split(",");
			// Check if ratios contains the key and update list if it does
			if (!ratios.containsKey(tokens[0])) {
				HashMap<String, Double> values = new HashMap<>();
				values.put(tokens[1], Double.parseDouble(tokens[2]));
				ratios.put(tokens[0], values);
			} else {
				HashMap<String, Double> values = ratios.get(tokens[0]);
				values.put(tokens[1], Double.parseDouble(tokens[2]));
			}
			
			if (!ratios.containsKey(tokens[1])) {
				HashMap<String, Double> values = new HashMap<>();
				values.put(tokens[0], 1 / Double.parseDouble(tokens[2]));
				ratios.put(tokens[1], values);
			} else {
				HashMap<String, Double> values = ratios.get(tokens[1]);
				values.put(tokens[0], 1 / Double.parseDouble(tokens[2]));
			}
		}
		
		in.close();
	}
	
	public ArrayList<Double> processRequirements(String req) {
		ArrayList<Double> res = new ArrayList<>();
		Scanner in = new Scanner(req);

		while (in.hasNextLine()) {
			String[] tokens = in.nextLine().trim().split(",");
			// Check if ratios contains the key and update list if it does
			if (ratios.containsKey(tokens[0])) {
				// Iterate through the values and see if we have a ratio
				// If a value is not what we need, then we add it to a Queue 
				// to visit.
				// Uses Breadth First Search
				double ratio = traverse(tokens);
				
				if (ratio < 0) {
					if (toVisit.size()>0) {
						processRequirements(toVisit.getFirst());
					} else {
						res.add((double) -1);
					}
				} else {
					res.add(ratio);
				}
			} else {
				res.add((double) -1);
			}
		}
		
		in.close();
		return res;
	}
	
	public double traverse(String[] tokens) {
		HashMap<String, Double> values = ratios.get(tokens[0]);
		String convertReq = tokens[1];
		Set<Entry<String, Double>> it = values.entrySet();;
		for (Entry<String, Double> e : it) {
			String key = e.getKey();
			Double value = e.getValue();
			
			if (key.equals(convertReq)) {
				return value;
			} else {
				toVisit.add(key);
			}
		}
		visitedNodes.add(tokens[0]);
		return -1;
	}
	
	
	public void execute(String input, String req) {
		processRatios(input);
		
		ArrayList<Double> ratio = processRequirements(req);
	
		for (Double d : ratio) {
			System.out.println(d);
		}
	}
	
}

package BFS_Graph;

import java.io.*;
import java.util.*;

public class Solution {

    public static class Node {
        int num;
        ArrayList<Integer> adjacentNodes = new ArrayList<>();
        boolean isVisited = false;
        int rootDistance = 0;
        
        public Node(int num) {
            this.num = num;
        }
    }
    
    public static Deque<Integer> toVisit = new LinkedList<>();
    
    public static HashMap<Integer, Node> graph = new HashMap<>();
    
    public static void findDistance(int root) {
        // Step 0: mark root as visited
        graph.get(root).isVisited = true;
        
        // Step 1: Compute all distances to connected nodes
        findDistance(root, root);
        
        // Step 2: mark disconnected nodes as distance -1
        for (Node n : graph.values()) {
            if (!n.isVisited) {
                n.rootDistance = -1;
            }
        }
        
    }
    
    public static void findDistance(int root, int current) {
        // Step 1: get current Node
        Node curNode = graph.get(current);
        
        // Step 2: add all the adjacent vertices of the current node for BFS later
        for (Integer n : curNode.adjacentNodes) {
            if ((n!=root) && (!graph.get(n).isVisited)){
                toVisit.add(n);
            }
        }
        
        // Step 3: set the distance for each adjacent vertex. If the distance is greater than current distance, then do not update the distance.
        int curDistance = graph.get(current).rootDistance;
        for (Integer n : curNode.adjacentNodes) {
            if (n!=root) {
                Node adjNode = graph.get(n);
                int adjNodeDistance = adjNode.rootDistance;
                if (adjNodeDistance==0) {
                    adjNode.rootDistance = curDistance + 6;
                } else if (curDistance+6<adjNodeDistance) {
                    adjNode.rootDistance = curDistance + 6;
                }
            }
        }
        
        // Step 4: mark the current node as visited for BFS search
        graph.get(current).isVisited = true;
        
        // Step 5: for each vertex to apply BFS, repeat the algortihm
        while (toVisit.size()>0) {
        	int nextNode = toVisit.poll();
        	if (!graph.get(nextNode).isVisited) {
	        	//System.out.println("Root is "+root+" and next node is "+toVisit.peek());
	            findDistance(root, nextNode);
        	}
        }
        
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
    	
    	System.setIn(new FileInputStream("C:\\Users\\Ali\\workspace2\\HackerRank\\src\\BFS_Graph\\input05.txt"));
        Scanner in = new Scanner(System.in);
        
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            // make Nodes and add to graph
            for (int j = 1; j <= n; j++) {
                graph.put(j, new Node(j));
            }
            
            int m = in.nextInt();
            // Create edges and add to adjacent list
            // for each respective node
            for (int k = 0; k < m; k++) {
                int u = in.nextInt();
                int v = in.nextInt();
                
                graph.get(u).adjacentNodes.add(v);
                graph.get(v).adjacentNodes.add(u);
            }
            
            // starting node
            int s = in.nextInt();
            
            // execute
            findDistance(s);
            
            // print out the distanes in order
            StringBuffer sb = new StringBuffer();
            for (int p = 1; p <= n; p++) {
                if (p!=s) 
                    sb.append(graph.get(p).rootDistance+" ");
            }
            System.out.println(sb.toString());
            
            // clear memory
            toVisit.clear();
            graph.clear();
            System.gc();
        }
        
        
     
        
        
        
    }
}
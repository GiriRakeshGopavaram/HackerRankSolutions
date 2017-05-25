/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Rakesh
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    static void leftRotate(int[] array, int k) {
        int[] b = new int[array.length];
        if (k > 0) {
            for (int i = 0; i < array.length; i++) {
                b[array.length - 1 - i] = array[i];
            }
            k -= 1;
        }
        for (int num : b) {
            System.out.print(num + " ");
        }
    }
    
    public static void coinChange(int dollars, int[] coins) {
        long[] coinsArray = new long[dollars+1];
        coinsArray[0] = 1;
        for(int coin: coins){
            for(int i=0;i<coinsArray.length-coin;i++){
                coinsArray[coin+i] += coinsArray[i]; 
            }
        }
         System.out.println(coinsArray[dollars]);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Graph problem starts here
        
//        Scanner scan = new Scanner(System.in);
//        int numQueries = scan.nextInt();
//        
//        for (int q = 0; q < numQueries; q++) {
//            int numNodes = scan.nextInt();
//            int numEdges = scan.nextInt();
//            
//            /* Create Nodes */
//            Node [] node = new Node[numNodes + 1]; // node "i" will be at index "i"
//            node[0] = null;
//            for (int i = 1; i <= numNodes; i++) {
//                node[i] = new Node(i);
//            }
//            
//            /* Connect Nodes */
//            for (int i = 0; i < numEdges; i++) {
//                int n1 = scan.nextInt();
//                int n2 = scan.nextInt();
//                node[n1].addNeighbor(node[n2]);
//            }
//            
//            /* Create MST */
//            int start = scan.nextInt();
//            findDistances(node[start]);
//
//            /* Print results */
//            for (int i = 1; i <= numNodes; i++) {
//                if (i != start) {
//                    System.out.print(node[i].distance + " ");
//                }
//            }
//            System.out.println();
//        }
//        scan.close();
        
        //Graph problem ends here
    }

    private static void findDistances(Node start) {
        if (start == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>(); // use deque as a queue
        start.distance = 0;
        deque.add(start);
        while (!deque.isEmpty()) {
            Node curr = deque.remove();
            for (Node neighbor : curr.neighbors) {
                if (neighbor.distance == -1) { // meaning it's unvisited
                    neighbor.distance = curr.distance + 6;
                    deque.add(neighbor);
                }
            }
        }
    }
    
    /* Implementation of an UNDIRECTED graph */
    public static class Node {
        public final int     id; // each Node will have a unique ID
        public int           distance; // Also tells us if Node has been visited (-1 means unvisited)
        public HashSet<Node> neighbors;
        
        public Node (int id) {
            this.id   = id;
            distance  = -1;
            neighbors = new HashSet<>();
        }
        
        public void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            } else if (other == null || !(other instanceof Node)) {
                return false;
            }
            Node otherNode = (Node) other;
            return this.id == otherNode.id;
        }

        @Override
        public int hashCode() {
            return id; // simple and effective
        }
    }
}


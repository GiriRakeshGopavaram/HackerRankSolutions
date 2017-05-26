/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    
    public static int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {
        int[][] subMatrix = new int[matrix.length-rowsToDelete.length][];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<3;i++){
                for(int k=0;k<rowsToDelete.length;k++){
                    if(rowsToDelete[k] != i)
                    for(int l=0;l<columnsToDelete.length;l++){
                        if(columnsToDelete[l] != j){
                            //subMatrix[i][j] = matrix[i][j];
                            System.out.println(matrix[i][j]);
                        }
                    }
                }
                
            }
        }
            
        return subMatrix;
    }
    public static int[] digitRootSort(int[] a) {
        Map<Integer, Integer> digital  = new HashMap<>();
        int[] b = new int[a.length];
        int minValue, temp = 0;
        
        for(int i = 0 ;i < a.length;i++){
            digital.put(a[i],1+(a[i]-1)%9);
        }
        for(int key: digital.keySet()){
            minValue = Collections.max(digital.entrySet(), (entry1, entry2)-> entry2.getValue() - entry1.getValue()).getValue();
            
        }

        return b;
    }
    
    public static int numberOfSolutions(int n){
        int result = 0;
        String str = "";
        for(int a = 0;a <=100;a++){    
            for(int b = 0; b <=100;b++){
                double num = (double)a*b;
                double deno = (double)a+b;
            }
        }
        System.out.println(result);
        return result;
    }
    public static void getTriplet(int[] a, int requiredSum)
    {
        Arrays.sort(a);
        int hi;
        int lo;
        for(int i=0; i < a.length-2; i++)
        {
            lo = i+1;
            hi = a.length-1;
            while(lo<hi) {
                int actualSum = a[i] + a[hi] + a[lo];
                int diff = requiredSum-actualSum;
                if (diff > 0)
                    lo++;
                else if(diff<0)
                    hi--;
                else {
                    System.out.println(a[i] + ":" + a[lo] + ":" + a[hi]+" $ "+actualSum);
                    lo++;
                    hi--;
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Graph problem starts here
        
        
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
            for (Node neighbour : curr.neighbours) {
                if (neighbour.distance == -1) { // meaning it's unvisited
                    neighbour.distance = curr.distance + 6;
                    deque.add(neighbour);
                }
            }
        }
    }
    
    /* Implementation of an UNDIRECTED graph */
    public static class Node {
        public final int     id; // each Node will have a unique ID
        public int           distance; // Also tells us if Node has been visited (-1 means unvisited)
        public HashSet<Node> neighbours;
        
        public Node (int id) {
            this.id   = id;
            distance  = -1;
            neighbours = new HashSet<>();
        }
        
        public void addNeighbor(Node neighbour) {
            neighbours.add(neighbour);
            neighbour.neighbours.add(this);
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


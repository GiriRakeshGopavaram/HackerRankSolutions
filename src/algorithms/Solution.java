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
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
    
    //Balanced brackets:
    public static boolean isBalanced(String expression) {
        LinkedList<String> bracket = new LinkedList<>();
        if (expression.length() % 2 != 0) {
            return false;
        }
        String[] chars = expression.split("");
        for (String element : chars) {
            if (element.equals("{")) {
                bracket.push("}");
            } else if (element.equals("[")) {
                bracket.push("]");
            } else if (element.equals("(")) {
                bracket.push(")");
            } else {
                if (bracket.isEmpty() || !bracket.peek().equals(element)) {
                    return false;
                }
                bracket.pop();
            }
        }
        return bracket.isEmpty();
    }
    
    static int count_palindromes(String S) {

        String[] characters = S.split("");
        int count = 0;
        for (int i = 0; i < characters.length; i++) {
            String original = "";
            for (int j = i; j < characters.length; j++) {
                original += characters[j];
                System.out.println(original);
                String reversed = new StringBuilder(original).reverse().toString();
                if (original.equals(reversed)) {
                    count += 1;
                }
            }
        }
        return count;
    }
    
    //sumOfTwo
    public static boolean sumOfTwo(int[] a, int[] b, int v) {
        Arrays.sort(a);
        Arrays.sort(b);
        Hashtable<Integer, Integer> combi = new Hashtable<>();
        for (int i = 0; i < a.length; i++) {
            combi.put(a[i], v - a[i]);
            int x = combi.remove(a[i]);
            for (int j = 0; j < b.length; j++) {
                if (x == b[j]) {
                    return true;
                }
            }
        }

        return false;
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
    static int[] matrixElementsInSpiralOrder(int[][] matrix) {
        int[] result = new int[matrix[0].length * matrix[1].length];
        int r = 0;
        int c = 0;
        int ce = matrix[1].length;
        int re = matrix[0].length;
        int j = 0;
        while (r < re && c < ce) {
            for (int i = c; i < ce; i++) {
                System.out.println(matrix[r][i]);
                result[j] = matrix[r][i];
                j += 1;
            }
            r += 1;
            for (int i = r; i < re - 1; i++) {
                System.out.println(matrix[i][ce - 1]);
                result[j] = matrix[r][i];
                j += 1;
            }
            ce -= 1;
            if (r < re) {
                for (int i = ce; i >= c; i--) {
                    System.out.println(matrix[re - 1][i]);
                    result[j] = matrix[r][i];
                    j += 1;
                }
                re -= 1;
            }
            if (c < ce) {
                for (int i = re - 1; i >= r; i--) {
                    System.out.println(matrix[i][c]);
                    result[j] = matrix[r][i];
                    j += 1;
                }
                c += 1;
            }
        }
        return result;
    }

    
    //Permutations of a given string
     public static void permutation(String str) {
        permutation("", str);
    }
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
    
    
    static public String electionWinner(String[] names) {
        Map<String, Integer> winnerNames = new TreeMap<>(Collections.reverseOrder());
        int count = 0;
        int max = 0;
        //List<String> winnerNames = new ArrayList<>();

        for (String name : names) {
            if (winnerNames.containsKey(name)) {
                count = winnerNames.get(name);
                count += 1;
                if (count > max) {
                    max = count;
                }
                winnerNames.replace(name, count);
            } else {
                count = 1;
                winnerNames.put(name, count);
            }
        }
        System.out.println("Winner is");
        System.out.println(Collections.max(winnerNames.entrySet(), Map.Entry.comparingByValue()).getKey());
        System.out.println(Collections.max(winnerNames.entrySet(), Map.Entry.comparingByValue()).getValue());
        return "";
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


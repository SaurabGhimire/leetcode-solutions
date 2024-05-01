package daily_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindIfPathExistsInGraph1971 {
    public static void main(String[] args) {
        int[][] edges = {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        int source = 5;
        int destination = 9;
        int n=10;
        boolean ans = validPath(10, edges, 7, 5);
        System.out.println("The answer is :" + ans);
    }
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0) return true;
        Stack<Integer> stack = new Stack<Integer>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (u == source ) {
                if(v == destination) return true;
                stack.push(v);
            } else  if (v == source ) {
                if(u == destination) return true;
                stack.push(u);
            }
        }
        List<Integer> traversedNums = new ArrayList<>();
        System.out.println("The stack is: " + Arrays.toString(stack.toArray()));
        while(!stack.isEmpty()){
            int currentVertex = stack.peek();
            if(currentVertex == destination) return true;
            boolean continueForLoop = true;
            System.out.println("traversedNums" + traversedNums.toString());
            System.out.println("Current Vertex" + currentVertex);
            for(int i=0;i<edges.length;i++){
                if(!continueForLoop) break;
                if(edges[i][0] == currentVertex && !traversedNums.contains(edges[i][1])){
                    stack.push(edges[i][1]);
                    continueForLoop = false;
                } else if(edges[i][1] == currentVertex && !traversedNums.contains(edges[i][0])){
                    stack.push(edges[i][0]);
                    continueForLoop = false;
                }
            }
            if(continueForLoop){
                stack.pop();
            }
            traversedNums.add(currentVertex);
        }
        return false;
    }

}

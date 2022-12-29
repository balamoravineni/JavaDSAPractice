package graphs.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  public static void main(String args[]) {
    //input:
    // 5 4
    // 0 1 
    // 0 2
    // 0 3 
    // 2 4
    int V=5;
    int E=4;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i=0;i<V;i++) {
      adj.add(new ArrayList<>());
    }
    Collections.addAll(adj.get(0), 1,2,3);
    Collections.addAll(adj.get(1), 0);
    Collections.addAll(adj.get(2), 0,4);
    Collections.addAll(adj.get(3), 0);
    Collections.addAll(adj.get(4), 2);
    System.out.println("Input: "+ V + " " + E);
    int i=0;
    for(ArrayList<Integer> curr: adj){
      System.out.print(i++ + ": ");
      curr.stream().forEach(el -> System.out.print(el + " "));
      System.out.println();
    }

    System.out.println("Output: ");
    System.out.println(bfsOfGraph(V, adj));
  }

  // Function to return Breadth First Traversal of given graph.
  public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
      // Code here
      ArrayList<Integer> ans = new ArrayList<>();
      
      boolean[] visited = new boolean[V];
      Queue<Integer> queue = new LinkedList<>();
      queue.add(0);
      visited[0] = true;
      
      while(!queue.isEmpty()) {
          int current = queue.poll();
          ans.add(current);
          for(int i=0;i<adj.get(current).size();i++) {
              if(!visited[adj.get(current).get(i)]) {
                  queue.add(adj.get(current).get(i));
                  visited[adj.get(current).get(i)] = true;
              }
          }
      }
      return ans;
  }
}
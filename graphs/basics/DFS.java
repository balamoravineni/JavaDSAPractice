package graphs.basics;

import java.util.ArrayList;
import java.util.Collections;

public class DFS {

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
    System.out.println(dfsOfGraph(V, adj));
  }

  // Function to return a list containing the DFS traversal of the graph.
  public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    // Code here
    ArrayList<Integer> ans = new ArrayList<>();
    boolean[] visited = new boolean[V];   
    dfs(adj,0,ans,visited);
    return ans;
  }

  public static void dfs(ArrayList<ArrayList<Integer>> adj, int ind, ArrayList<Integer> ans, boolean[] visited) {
    ans.add(ind);
    visited[ind] = true;
    for(int i:adj.get(ind)) {
        if(!visited[i]) {
            dfs(adj,i,ans,visited);
        }
    }
  }
}
package graphs.basics;

import java.util.ArrayList;
import java.util.Collections;

public class NumberOfProvinces {

  public static void main(String args[]) {
    // print num of provinces
    //input:
    // 5 2
    // 0 1 
    // 0 2
    int V=5;
    // input is in adjacency matrix
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i=0;i<V;i++) {
      adj.add(new ArrayList<>());
    }
    Collections.addAll(adj.get(0), 1,1,1,0,0);
    Collections.addAll(adj.get(1), 1,1,0,0,0);
    Collections.addAll(adj.get(2), 1,0,1,0,0);
    Collections.addAll(adj.get(3), 0,0,0,1,0);
    Collections.addAll(adj.get(4), 0,0,0,0,1);
    System.out.println("Input: "+ V);
    int i=0;
    for(ArrayList<Integer> curr: adj){
      System.out.print(i++ + ": ");
      curr.stream().forEach(el -> System.out.print(el + " "));
      System.out.println();
    }

    // To convert adj matrix to adj list
    
    // ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    // for(int i=0;i<V;i++) { 
    //     adjList.add(new ArrayList<>());
    // }
    // for(int i=0;i<V;i++) { 
    //     for(int j=0;j<V;j++) { 
    //         if(i!=j && adj.get(i).get(j)==1) {
    //             adjList.get(i).add(j);
    //             adjList.get(j).add(i);
    //         }
    //     }
    // }
    // System.out.println(adjList);

    System.out.println("Output: ");
    System.out.println(numProvinces(adj, V));
    
  }

  static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
    int sum=0;
    boolean[] visited = new boolean[V];
    for(int i=0;i<V;i++) {
        if(!visited[i]) {
            dfs(adj, visited,i);
            sum++;
        }
    }
    return sum;
  }

  // DFS on adj Matrix
static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int ind) {
    visited[ind] = true;
    for(int i=0;i<adj.get(ind).size();i++) {
        if(i==ind) {
            continue;
        }
        if(!visited[i] && adj.get(ind).get(i)==1) {
            dfs(adj,visited,i);
        }
    }
  }

}

package graphs;

import java.util.ArrayList;
import java.util.Collections;

class Template {

  public static void main(String args[]) {
    //input:
    // 5 4
    // 0 1 
    // 0 2
    // 0 3 
    // 2 4
    int V=5;
    int E=4;
    // input is in adjacency list
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

    // To convert adj matrix to adj list

    // //input:
    // // 5 2
    // // 0 1 
    // // 0 2
    // int V=5;
    // // input is in adjacency matrix
    // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    // for(int i=0;i<V;i++) {
    //   adj.add(new ArrayList<>());
    // }
    // Collections.addAll(adj.get(0), 1,1,1,0,0);
    // Collections.addAll(adj.get(1), 1,1,0,0,0);
    // Collections.addAll(adj.get(2), 1,0,1,0,0);
    // Collections.addAll(adj.get(3), 0,0,0,1,0);
    // Collections.addAll(adj.get(4), 0,0,0,0,1);

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
    
  }

}
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

    
  }

}
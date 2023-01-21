package codeforces.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WayTooLongWords {
  
  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);
    // input
    int n = scanner.nextInt();
    scanner.nextLine();
    List<String> input = new ArrayList<>();
    for(int i=0;i<n;i++) {
      input.add(scanner.nextLine());
    }
    
    scanner.close();

    for(int i=0;i<n;i++) {
      String word = input.get(i);
      if(word.length()>10) {
        String res = "" + word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length()-1); 
        System.out.println(res);
      }
      else {
        System.out.println(word);
      }
    }
  }
}

package codeforces.practice;

import java.util.Scanner;

public class Watermellon {

  public static void main(String args[]) {
    
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    scanner.close();

    if (input>2) System.out.println(input%2==0?"YES":"NO");
    else System.out.println("NO");
  }

}

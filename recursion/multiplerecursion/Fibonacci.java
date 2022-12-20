package recursion.multiplerecursion;

public class Fibonacci {
  
  public static void main(String args[]) {
  
    int n = 4;
    System.out.println("Input: "+ n);
    System.out.println("Output: " + fibonacci(n));
  }

  public static int fibonacci(int n) {
    if(n<=1) {
      return n;
    }
    return fibonacci(n-1) + fibonacci(n-2);
  }


}

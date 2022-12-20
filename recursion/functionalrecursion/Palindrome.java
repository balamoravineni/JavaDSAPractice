package recursion.functionalrecursion;

public class Palindrome {
  
  public static void main(String args[]) {
  
    String input = "MADSM";
    System.out.println("Input: " + input);
    System.out.println("Output: " + isPalindrome(input, 0));
  }

  private static boolean isPalindrome(String input, int low) {
    if(low>=input.length()/2) {
      return true;
    }
    return input.charAt(low)==input.charAt(input.length()-1-low) && isPalindrome(input, low+1);
  }

}

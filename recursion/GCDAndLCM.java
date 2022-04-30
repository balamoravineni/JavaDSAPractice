package recursion;

import java.util.Scanner;

public class GCDAndLCM {
    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        if(a<=b) {
            System.out.println("GCD: "+ gcd(a, b));
            System.out.println("LCM: "+ (a*b)/gcd(a, b));
        }
        else {
            System.out.println("GCD: "+ gcd(b, a));
            System.out.println("LCM: "+ (a*b)/gcd(b, a));
        }
    }

    private static int gcd(int a, int b) {
        if (a<0 || b<0) {
            return -1;
        }
        if(a==0) {
            return b;
        }
        return gcd (b%a, a);
    }

}

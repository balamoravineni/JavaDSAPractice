package recursion;

import java.util.Scanner;

public class PowerOfANumber{

    public static void main(String[] args) {
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers (num, pow): ");
        int num = scanner.nextInt();
        int pow = scanner.nextInt();
        scanner.close();

        System.out.println(power(num, pow));
    }

    private static int power(int num, int pow) {
        if(pow<0) {
            return -1;
        }
        if(pow==0) {
            return 1;
        }
        return num*power(num, pow-1);
    }

}
package recursion;

import java.util.Scanner;

public class DecimalToBinary {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        System.out.println(binary(num));
    }

    private static int binary(int n) {
        // if(n<0) {
        //     return -1;
        // }
        if(n==0) {
            return 0;
        }
        return binary(n/2)*10 + n%2;
    }

}

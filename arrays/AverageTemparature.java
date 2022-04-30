package arrays;

import java.util.Scanner;

public class AverageTemparature {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int days = scanner.nextInt();
        SingleDimensionArray tempOnDays = new SingleDimensionArray(days);
        for(int i=0;i<days;i++) {
            System.out.print("Enter day " + (i+1)+"'s temparature: ");
            tempOnDays.insert(i, scanner.nextInt());
        }
        scanner.close();
        double avgTemp = averageTemparature(tempOnDays.arr);
        System.out.println("Average Temparature: " + avgTemp);
        System.out.println("Number of Day(s) above average temparature: "+ numberOfDaysAboveAvgTemparature(tempOnDays.arr, avgTemp));
    }
    

    public static int numberOfDaysAboveAvgTemparature(int arr[], double avg) {
        int res = 0;
        for (int i=0;i<arr.length; i++) {
            if((double)arr[i]> avg) {
                res++;
            }
        }
        return res;
    }

    public static double averageTemparature( int[] arr) {
        int sum = 0;
        for (int i=0;i<arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum/arr.length;
    } 


}

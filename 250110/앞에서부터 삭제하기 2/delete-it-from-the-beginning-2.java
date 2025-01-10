import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        double maxAvg = 0.0;
        int sumVal = 0;
        int minVal = Integer.MAX_VALUE;

        for (int i = n - 1; i > 0; i--) { 
            sumVal += arr[i];
            minVal = Math.min(minVal, arr[i]);

            
            if (n - i - 1 > 0) { 
                double avg = (double)(sumVal - minVal) / (n - i - 1);
                maxAvg = Math.max(maxAvg, avg);
            }
        }

        System.out.printf("%.2f", maxAvg);
    }
}

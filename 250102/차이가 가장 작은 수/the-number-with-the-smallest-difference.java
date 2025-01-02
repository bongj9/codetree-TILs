import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        
        Arrays.sort(arr);
        
        
        int left = 0, right = 0;
        int minDifference = Integer.MAX_VALUE;
        
        while (right < n) {
            int diff = arr[right] - arr[left];
            
            
            if (diff >= m) {
                minDifference = Math.min(minDifference, diff);
                left++; 
            } else {
                right++; 
            }
        }
        
 
        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }
}

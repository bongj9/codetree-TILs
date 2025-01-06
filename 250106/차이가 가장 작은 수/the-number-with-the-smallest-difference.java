import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    public static int n, m;
    public static int[] arr = new int[MAX_N];
    
    public static TreeSet<Integer> s = new TreeSet<>();
    
    public static int ans = INT_MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            s.add(arr[i]);


        for(int i = 0; i < n; i++) {
            int x = arr[i];

        
            if(s.ceiling(m + x) != null)
                ans = Math.min(ans, s.ceiling(m + x) - x);

        
            if(s.floor(x - m) != null)
                ans = Math.min(ans, x - s.floor(x - m));
        }

        if(ans == INT_MAX)
            ans = -1;

        System.out.print(ans);
    }
}
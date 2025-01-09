import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n;
    public static int[] arr = new int[MAX_N];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

       
        for(int i = 0; i < n; i++)
            pq.add(-arr[i]);

       
        while(pq.size() >= 2) {
            
            int x = -pq.poll();
            int y = -pq.poll();

          
            int diff = x - y;
            if(diff != 0)
                pq.add(-diff);
        }

      
        if(pq.size() == 1)
            System.out.print(-pq.peek());
        else
            System.out.print(-1);
    }
}
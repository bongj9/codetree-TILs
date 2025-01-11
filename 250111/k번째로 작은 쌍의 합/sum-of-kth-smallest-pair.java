import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

class Tuple implements Comparable<Tuple> {
    int pairSum, idx1, idx2;

    public Tuple(int pairSum, int idx1, int idx2) {
        this.pairSum = pairSum;
        this.idx1 = idx1;
        this.idx2 = idx2;
    }

    @Override
    public int compareTo(Tuple t) {
        if(this.pairSum != t.pairSum)
            return this.pairSum - t.pairSum;  
        else if(this.idx1 != t.idx1)
            return this.idx1 - t.idx1;        
        else
            return this.idx2 - t.idx2;       
    }
}

public class Main {
    public static final int MAX_NUM = 100000;
    
    public static int n, m, k;
    
    public static int[] arr1 = new int[MAX_NUM];
    public static int[] arr2 = new int[MAX_NUM];
    public static PriorityQueue<Tuple> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        for(int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();

        Arrays.sort(arr1, 0, n);
        Arrays.sort(arr2, 0, m);
        
       
        for(int i = 0; i < n; i++)
            pq.add(new Tuple(arr1[i] + arr2[0], i, 0));
        
        for(int i = 0; i < k - 1; i++) {
            Tuple bestT = pq.poll();
            int idx1 = bestT.idx1;
            int idx2 = bestT.idx2;

       
            idx2++;
            if(idx2 < m)
                pq.add(new Tuple(arr1[idx1] + arr2[idx2], idx1, idx2));
        }

        System.out.print(pq.peek().pairSum);
    }
}

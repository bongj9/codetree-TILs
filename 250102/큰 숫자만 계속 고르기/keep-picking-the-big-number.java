import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq  = new PriorityQueue<>((a,b) -> b - a);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i  = 0 ; i < n ; i++){
            int input = Integer.parseInt(st.nextToken());
            pq.add(input);
        }
        for(int i = 0; i < m ; i++ ){
            int maxNum = pq.poll();
            maxNum -= 1;
            pq.add(maxNum);
        }
        System.out.print(pq.poll());
    }
}
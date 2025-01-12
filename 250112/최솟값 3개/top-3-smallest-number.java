import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b); // 최소 힙
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            pq.add(value); 

            if (pq.size() < 3) {
                sb.append("-1\n");
            } else {
                
                int first = pq.poll();
                int second = pq.poll();
                int third = pq.poll();
                int sum = first * second * third;

                pq.add(first);
                pq.add(second);
                pq.add(third);

                
                sb.append(sum).append("\n");
            }
        }

        System.out.print(sb);
    }
}

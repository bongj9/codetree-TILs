import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] position = new int[N + 1]; 
        Set<Integer>[] visited = new HashSet[N + 1]; 
        for (int i = 1; i <= N; i++) {
            position[i] = i;
            visited[i] = new HashSet<>();
            visited[i].add(i);
        }

        int[][] swaps = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            swaps[i][0] = Integer.parseInt(st.nextToken());
            swaps[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int repeat = 0; repeat < 3 * K; repeat++) {
            for (int i = 0; i < K; i++) {
                int a = swaps[i][0];
                int b = swaps[i][1];

              
                int temp = position[a];
                position[a] = position[b];
                position[b] = temp;

                visited[position[a]].add(a);
                visited[position[b]].add(b);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i].size()).append("\n");
        }
        System.out.print(sb);
    }
}

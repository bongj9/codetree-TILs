import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] M = new int[m];
        HashMap<Integer, Integer> maps = new HashMap<>();

        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken()); 
            maps.put(input, maps.getOrDefault(input, 0) + 1);
        }

        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            M[i] = Integer.parseInt(st.nextToken());
        }

        
        for (int index : M) {
            System.out.print(maps.getOrDefault(index, 0) + " "); 
        }
    }

}

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        TreeSet<Integer> treeSet = new TreeSet<>(); 

        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int query = Integer.parseInt(br.readLine());
            Integer result = treeSet.ceiling(query);
            sb.append(result != null ? result : -1).append("\n");
        }

        System.out.print(sb);
    }
}

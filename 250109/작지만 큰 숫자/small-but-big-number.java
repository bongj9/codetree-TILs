import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            set.add(input);
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int index = Integer.parseInt(st.nextToken());
            Integer max = set.floor(index); 
            
            if (max == null) { 
                System.out.println(-1);
            } else { 
                System.out.println(max);
                set.remove(max); // 사용한 값 삭제
            }
        }
    }
}

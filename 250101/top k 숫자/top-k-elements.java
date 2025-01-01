import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>((a,b) -> b -a);
        for(int i = 0 ; i < n ; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0 ; i < k ; i++){
            System.out.print(set.pollFirst()+ " ");
        }
    }
}
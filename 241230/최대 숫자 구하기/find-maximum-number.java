import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int [] inputs = new int[n];
        for(int i = 0 ;  i< st.countTokens(); i++){
                inputs[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= m ; i++){
            set.add(i);
        }
        for(int input : inputs){
            set.remove(input);
            sb.append(set.last()).append("\n");
        }

        System.out.print(sb);
    }
}
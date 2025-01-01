import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int [] arr = new int[100000];
        for(int i = 0; i< n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());       
        }
        for(int i = 1; i<=m ; i++){
            set.add(i);
        }
        int ans = 0;
        for(int i= 0; i<n;i++){
            if(set.floor(arr[i]) != null ){
                int num = set.floor(arr[i]);
                set.remove(num);

                ans++;
            }
            else 
                break;
        }
        System.out.print(ans);
    }   
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< n ; i++){
            int k = Integer.parseInt(st.nextToken());
            if(!map.containsKey(k)){
                map.put(k ,i+1);
            }else map.put(k ,map.get(k));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCase = Integer.parseInt(br.readLine());
    StringTokenizer st;
    HashMap<Integer, String> map = new HashMap<>();
    for(int i = 0 ;i< testCase; i++){
        st = new StringTokenizer(br.readLine());
        String inputName = st.nextToken();
        if(inputName.equals("add")){
            int key = Integer.parseInt(st.nextToken());
            String value = String.valueOf(st.nextToken());
            map.put(key, value);
        }
        if(inputName.equals("remove")){
            int key = Integer.parseInt(st.nextToken());
            map.remove(key);
        }
        if(inputName.equals("find")){
            int key = Integer.parseInt(st.nextToken());
            System.out.println(map.getOrDefault(key, "None"));
        }
    }
    }
}
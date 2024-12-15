import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String , Integer> maps = new HashMap<>();
        int testcase = Integer.parseInt(br.readLine());
        for(int i =0 ; i<testcase ; i++){
            String input = br.readLine();
            maps.put(input,maps.getOrDefault(input, 0)+1);
        }
        int maxValue = 0;
        for(Map.Entry<String,Integer> entry :  maps.entrySet()){
            if(maxValue < entry.getValue()){
                maxValue = entry.getValue();
            }
        }
        System.out.println(maxValue);
           
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for(int i = 0 ; i < n ; i ++ ){
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(!map.containsKey(x)){
                map.put(x,y);
            }else if(map.get(x) >  y){
                map.replace(x , y);
            }
            
            
        }
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
           cnt += entry.getValue();
        }
        System.out.println(cnt);

    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        String input = sc.nextLine();
        char[] charList = input.toCharArray();
        for(int i = 0 ; i< charList.length ; i++ ){
            map.put(charList[i], map.getOrDefault(charList[i],0)+1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("None");
    }
}
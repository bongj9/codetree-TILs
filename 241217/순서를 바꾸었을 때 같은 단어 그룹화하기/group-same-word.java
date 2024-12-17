import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n ; i++){
            String input = sc.nextLine();
            char [] charList = input.toCharArray();
            Arrays.sort(charList);
            String sortList = new String(charList);
            
            map.put(sortList, map.getOrDefault(sortList,0)+1);
            //스트링을 쪼개서 char로 등록
        }
        int maxCount = Collections.max(map.values());
        System.out.print(maxCount);

    }
}
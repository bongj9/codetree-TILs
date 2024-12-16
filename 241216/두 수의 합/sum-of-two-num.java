import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 배열 크기
        int k = sc.nextInt(); // 목표 합
        int count = 0;

        // 배열 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // HashMap을 사용해 효율적으로 합 계산
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = k - arr[i]; // 현재 값과 더해 k가 되는 값
            if (map.containsKey(complement)) {
                count += map.get(complement); // 해당 값의 빈도수만큼 카운트
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // 현재 값의 빈도수 업데이트
        }

        System.out.println(count);
    }
}

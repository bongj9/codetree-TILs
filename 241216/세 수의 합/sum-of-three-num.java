import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 배열 크기
        int k = sc.nextInt(); // 목표 합
        int count = 0;

        // 배열 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // HashMap을 이용한 세 숫자의 합 계산
        for (int i = 0; i < n - 2; i++) { // 첫 번째 숫자 고정
            HashMap<Integer, Integer> map = new HashMap<>(); // 두 번째 숫자를 저장할 맵
            for (int j = i + 1; j < n; j++) { // 두 번째 숫자부터 시작
                int target = k - arr[i] - arr[j]; // 필요한 세 번째 숫자
                if (map.containsKey(target)) { 
                    count += map.get(target); // 해당 숫자가 있다면 카운트 증가
                }
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1); // 현재 숫자를 맵에 추가
            }
        }

        System.out.println(count);
    }
}

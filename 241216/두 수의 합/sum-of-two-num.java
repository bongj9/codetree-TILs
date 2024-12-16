import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 배열 크기
        int k = sc.nextInt(); // 목표 합
        int count = 0;

        // HashMap으로 값 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, sc.nextInt());
        }

        // 이중 for문으로 합 계산
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) { // i 이후의 값부터 탐색
                if (map.get(i) + map.get(j) == k) { // 두 값의 합이 k와 같다면
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

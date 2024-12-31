import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // TreeSet 초기화
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0); // 초기 값 추가

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            // x보다 작은 가장 큰 값과 x보다 큰 가장 작은 값 탐색
            Integer lower = set.lower(x);
            Integer higher = set.higher(x);

            // 가장 가까운 숫자 선택
            int closestNumber;
            if (lower == null) {
                // lower가 없으면 higher 선택
                closestNumber = higher;
            } else if (higher == null) {
                // higher가 없으면 lower 선택
                closestNumber = lower;
            } else {
                // 둘 다 존재할 경우 거리 비교
                if (x - lower <= higher - x) {
                    closestNumber = lower;
                } else {
                    closestNumber = higher;
                }
            }

            // 결과 저장
            sb.append(closestNumber).append("\n");

            // TreeSet에 현재 값 추가
            set.add(x);
        }

        // 결과 출력
        System.out.print(sb);
    }
}

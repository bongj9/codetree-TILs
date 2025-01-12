import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int a, sum;

    public Pair(int a, int sum) {
        this.a = a;
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.a != p.a) {
            return this.a - p.a; // `a`를 기준으로 오름차순 정렬
        } else {
            return this.sum - p.sum; // 만약 `a`가 같다면 `sum`을 기준으로 오름차순 정렬
        }
    }
}

public class Main {
    public static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            pq.add(new Pair(value, value)); // Pair 객체를 우선순위 큐에 추가

            // 결과 계산
            if (pq.size() < 3) {
                sb.append("-1\n"); // 3개 미만이면 -1 출력
            } else {
                int sum = 0;
                List<Pair> tempList = new ArrayList<>();
                for (int j = 0; j < 3; j++) { // 최솟값 3개 추출
                    Pair p = pq.poll();
                    sum += p.sum;
                    tempList.add(p); // 추출한 값을 리스트에 저장
                }

                // 추출한 값을 다시 큐에 복원
                pq.addAll(tempList);
                sb.append(sum).append("\n");
            }
        }

        // 결과 출력
        System.out.print(sb);
    }
}

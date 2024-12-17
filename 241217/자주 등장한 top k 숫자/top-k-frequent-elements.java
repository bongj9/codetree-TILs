import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 원소 개수
        int k = sc.nextInt(); // 출력할 숫자 개수
        
        HashMap<Integer, Integer> map = new HashMap<>(); // 숫자의 빈도수를 저장할 HashMap
        
        // 입력 받기 및 빈도수 계산
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 우선순위 큐 (정렬 조건에 맞게 정렬)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) return b[0] - a[0]; // 빈도수가 같다면 숫자 내림차순
                return b[1] - a[1]; // 빈도수가 다르면 빈도수 내림차순
            }
        );
        
        // HashMap 데이터를 우선순위 큐에 넣기
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        
        // 상위 k개 숫자 출력
        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll()[0] + " ");
        }
    }
}

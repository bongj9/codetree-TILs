import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long cnt = 0; // 합계 변수를 long으로 선언
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 같은 x값이 없으면 추가, 있으면 더 작은 y로 업데이트
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (map.get(x) > y) {
                map.put(x, y); // 더 작은 y로 업데이트
            }
        }

        // 남아있는 점들의 y값 합산
        for (int y : map.values()) {
            cnt += y;
        }

        System.out.println(cnt);
    }
}

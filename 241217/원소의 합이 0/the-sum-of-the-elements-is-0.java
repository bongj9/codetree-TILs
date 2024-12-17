import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        // 입력 받기
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();
        for (int i = 0; i < n; i++) B[i] = sc.nextInt();
        for (int i = 0; i < n; i++) C[i] = sc.nextInt();
        for (int i = 0; i < n; i++) D[i] = sc.nextInt();

        // 두 배열 A와 B의 합을 저장할 HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // 두 배열 C와 D의 합 중, (A + B)의 합과 0이 되는 경우를 찾기
        int cnt = 0;
        for (int c : C) {
            for (int d : D) {
                int target = -(c + d);
                if (map.containsKey(target)) {
                    cnt += map.get(target);
                }
            }
        }

        // 결과 출력
        System.out.println(cnt);
    }
}

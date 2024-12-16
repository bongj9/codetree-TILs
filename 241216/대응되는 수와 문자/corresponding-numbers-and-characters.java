import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n, m 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // HashMap 선언
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> reverseMap = new HashMap<>(); // 값을 기준으로 키를 찾기 위한 추가 맵

        // n개의 데이터를 입력받아 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            map.put(i + 1, input);
            reverseMap.put(input, i + 1); // 값-키 쌍을 저장
        }

        // m개의 요청 처리
        for (int i = 0; i < m; i++) {
            String input = br.readLine();

            // 숫자인지 확인
            if (Character.isDigit(input.charAt(0))) {
                int key = Integer.parseInt(input);
                System.out.println(map.get(key)); // 키로 값 검색
            } else {
                System.out.println(reverseMap.get(input)); // 값으로 키 검색
            }
        }
    }
}

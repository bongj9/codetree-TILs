import java.util.*;
import java.io.*;

class Person {
    int position;
    int speed;

    public Person(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int T = Integer.parseInt(st.nextToken()); // 시간 (초)

        // 초기 상태 저장
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            people.add(new Person(position, speed));
        }

        // 매초마다 처리
        for (int t = 1; t <= T; t++) {
            // 1. 위치 업데이트
            for (Person p : people) {
                p.position += p.speed;
            }

            // 2. 그룹 형성
            // 사람을 위치 순서로 정렬
            people.sort(Comparator.comparingInt(p -> p.position));

            // 그룹 속도 업데이트: 뒤에서부터 처리
            for (int i = N - 2; i >= 0; i--) {
                if (people.get(i).position == people.get(i + 1).position) {
                    people.get(i).speed = Math.min(people.get(i).speed, people.get(i + 1).speed);
                }
            }
        }

        // 마지막 그룹 개수 계산
        int groupCount = 1; // 첫 번째 그룹은 항상 존재
        for (int i = 1; i < N; i++) {
            if (people.get(i).position != people.get(i - 1).position) {
                groupCount++;
            }
        }

        // 출력
        System.out.println(groupCount);
    }
}

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

            // 그룹 생성
            List<List<Person>> groups = new ArrayList<>();
            List<Person> currentGroup = new ArrayList<>();
            currentGroup.add(people.get(0));

            for (int i = 1; i < N; i++) {
                if (people.get(i).position == people.get(i - 1).position) {
                    // 같은 위치면 같은 그룹
                    currentGroup.add(people.get(i));
                } else {
                    // 새로운 그룹 생성
                    groups.add(currentGroup);
                    currentGroup = new ArrayList<>();
                    currentGroup.add(people.get(i));
                }
            }
            groups.add(currentGroup);

            // 3. 그룹 속도 업데이트
            for (List<Person> group : groups) {
                int minSpeed = group.stream().mapToInt(p -> p.speed).min().getAsInt();
                for (Person p : group) {
                    p.speed = minSpeed;
                }
            }
        }

        // 마지막 그룹 수와 그룹별 인원수 계산
        people.sort(Comparator.comparingInt(p -> p.position));
        int groupCount = 0;
        int[] groupSizes = new int[N];
        int index = 0;

        for (int i = 1; i < N; i++) {
            if (people.get(i).position != people.get(i - 1).position) {
                groupCount++;
                groupSizes[index++] = 1;
            } else {
                groupSizes[index - 1]++;
            }
        }
        groupCount++;

        // 출력
        System.out.println(groupCount);
    }
}

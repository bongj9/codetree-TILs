import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int G = Integer.parseInt(st.nextToken()); // 그룹의 수

        // 각 그룹 정보 저장
        Map<Integer, List<Integer>> personToGroups = new HashMap<>();
        List<Set<Integer>> groups = new ArrayList<>();

        for (int i = 0; i < G; i++) {
            st = new StringTokenizer(br.readLine());
            int groupSize = Integer.parseInt(st.nextToken());
            Set<Integer> group = new HashSet<>();
            for (int j = 0; j < groupSize; j++) {
                int person = Integer.parseInt(st.nextToken());
                group.add(person);
                personToGroups.putIfAbsent(person, new ArrayList<>());
                personToGroups.get(person).add(i);
            }
            groups.add(group);
        }

        // 초대받은 사람 추적
        Set<Integer> invited = new HashSet<>();
        invited.add(1); // 1번 사람은 항상 초대

        // BFS로 그룹 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 사람이 속한 그룹 탐색
            List<Integer> groupIndices = personToGroups.getOrDefault(current, new ArrayList<>());
            for (int groupIndex : groupIndices) {
                Set<Integer> group = groups.get(groupIndex);
                if (group == null) continue; // 이미 처리된 그룹은 무시

                // 그룹 내 모든 사람 초대
                for (int person : group) {
                    if (!invited.contains(person)) {
                        invited.add(person);
                        queue.add(person);
                    }
                }

                // 현재 그룹 처리 완료
                groups.set(groupIndex, null); // 그룹 제거
            }
            personToGroups.remove(current); // 현재 사람에 대한 그룹 정보 제거
        }

        // 결과 출력
        System.out.println(invited.size());
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> al = new ArrayList<>();  // 동적 배열로 사용할 ArrayList
        Scanner sc = new Scanner(System.in);        // 입력을 받기 위한 Scanner 객체

        int n = sc.nextInt();  // 명령어의 개수 입력
        sc.nextLine();         // 줄바꿈 처리

        // 주어진 명령을 처리
        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            
            // "push_back A" 명령 처리
            if (command.startsWith("push_back")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                al.add(value);
            }
            // "pop_back" 명령 처리
            else if (command.equals("pop_back")) {
                if (!al.isEmpty()) {
                    al.remove(al.size() - 1);
                } else {
                    System.out.println("배열이 비어있습니다.");
                }
            }
            // "size" 명령 처리
            else if (command.equals("size")) {
                System.out.println(al.size());
            }
            // "get k" 명령 처리
            else if (command.startsWith("get")) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;  // 1-based index를 0-based로 변환
                if (index >= 0 && index < al.size()) {
                    System.out.println(al.get(index));
                } else {
                    System.out.println("잘못된 인덱스입니다.");
                }
            }
        }

        sc.close();  // Scanner 닫기
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> al = new ArrayList<>();
        Scanner sc = new Scanner();

        int n = sc.nextInt();
        scanner.nextLine(); 

        // 주어진 명령을 처리
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            
            // "push_back A" 명령 처리
            if (command.startsWith("push_back")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                array.add(value);
            }
            // "pop_back" 명령 처리
            else if (command.equals("pop_back")) {
                if (!array.isEmpty()) {
                    array.remove(array.size() - 1);
                } else {
                    System.out.println("배열이 비어있습니다.");
                }
            }
            // "size" 명령 처리
            else if (command.equals("size")) {
                System.out.println(array.size());
            }
            // "get k" 명령 처리
            else if (command.startsWith("get")) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;  // 1-based index를 0-based로 변환
                if (index >= 0 && index < array.size()) {
                    System.out.println(array.get(index));
                } else {
                    System.out.println("잘못된 인덱스입니다.");
                }
            }
        }

        scanner.close();
    }
}
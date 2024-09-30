import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> al = new ArrayList<>();  
        Scanner sc = new Scanner(System.in);        

        int n = sc.nextInt(); 
        sc.nextLine();        

        
        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            
            if (command.startsWith("push_back")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                al.add(value);
            }
            else if (command.equals("pop_back")) {
                if (!al.isEmpty()) {
                    al.remove(al.size() - 1);
                } else {
                    System.out.println("배열이 비어있습니다.");
                }
            }
            else if (command.equals("size")) {
                System.out.println(al.size());
            }
            else if (command.startsWith("get")) {
                int index = Integer.parseInt(command.split(" ")[1]) - 1;  // 1-based index를 0-based로 변환
                if (index >= 0 && index < al.size()) {
                    System.out.println(al.get(index));
                } else {
                    System.out.println("잘못된 인덱스입니다.");
                }
            }
        }

        sc.close();  
    }
}
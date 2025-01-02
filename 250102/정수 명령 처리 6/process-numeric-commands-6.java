import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); 
        int n = Integer.parseInt(br.readLine()); 
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); 
            
            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    pq.add(value); 
                    break;
                
                case "size":
                    System.out.println(pq.size()); 
                    break;
                
                case "pop":
                    System.out.println(pq.isEmpty() ? -1 : pq.poll()); 
                    break;
                
                case "empty":
                    System.out.println(pq.isEmpty() ? 1 : 0); // 비어있는지 확인
                    break;
                
                case "top":
                    System.out.println(pq.isEmpty() ? -1 : pq.peek()); // 최솟값 출력
                    break;
                
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}

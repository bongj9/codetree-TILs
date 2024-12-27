import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); 

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); 
            TreeMap<Integer, Integer> map = new TreeMap<>(); 

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                  
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (command.equals("D")) {
                    if (map.isEmpty()) continue; 
                    int key = (num == 1) ? map.lastKey() : map.firstKey();
                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1); 
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.print(sb);
    }
}

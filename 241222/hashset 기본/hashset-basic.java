import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            String operation = command[0];
            int x = Integer.parseInt(command[1]);

            switch (operation) {
                case "add":
                    set.add(x);
                    break;
                case "remove":
                    set.remove(x);
                    break;
                case "find":
                    sb.append(set.contains(x)).append("\n");
                    break;
            }
        }

        
        System.out.print(sb.toString());
    }
}

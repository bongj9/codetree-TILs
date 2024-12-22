import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < n; i++) {
            String color = br.readLine();
            map.put(color, map.getOrDefault(color, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double frequency = (double) entry.getValue() / n * 100;
            System.out.printf("%s %.4f%n", entry.getKey(), frequency);
        }
    }
}

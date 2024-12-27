import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "add":
                    int addValue = Integer.parseInt(st.nextToken());
                    treeSet.add(addValue);
                    break;
                case "remove":
                    int removeValue = Integer.parseInt(st.nextToken());
                    treeSet.remove(removeValue);
                    break;
                case "find":
                    int findValue = Integer.parseInt(st.nextToken());
                    sb.append(treeSet.contains(findValue)).append("\n");
                    break;
                case "lower_bound":
                    int lbValue = Integer.parseInt(st.nextToken());
                    Integer lbResult = treeSet.ceiling(lbValue);
                    sb.append(lbResult != null ? lbResult : "None").append("\n");
                    break;
                case "upper_bound":
                    int ubValue = Integer.parseInt(st.nextToken());
                    Integer ubResult = treeSet.higher(ubValue);
                    sb.append(ubResult != null ? ubResult : "None").append("\n");
                    break;
                case "largest":
                    Integer largest = treeSet.isEmpty() ? null : treeSet.last();
                    sb.append(largest != null ? largest : "None").append("\n");
                    break;
                case "smallest":
                    Integer smallest = treeSet.isEmpty() ? null : treeSet.first();
                    sb.append(smallest != null ? smallest : "None").append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}

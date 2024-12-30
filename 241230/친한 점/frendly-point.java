import java.util.*;
import java.io.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x != o.x) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        TreeSet<Point> points = new TreeSet<>();

    
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int queryX = Integer.parseInt(st.nextToken());
            int queryY = Integer.parseInt(st.nextToken());

            Point query = new Point(queryX, queryY);

            Point result = points.ceiling(query);
            if (result == null) {
                sb.append("-1 -1\n");
            } else {
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }
}

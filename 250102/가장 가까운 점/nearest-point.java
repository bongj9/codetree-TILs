import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int defaultDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public int compareTo(Pair p) {
        if (this.defaultDistance() != p.defaultDistance()) {
            return Integer.compare(this.defaultDistance(), p.defaultDistance());
        } else if (this.x != p.x) {
            return Integer.compare(this.x, p.x);
        } else {
            return Integer.compare(this.y, p.y);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.offer(new Pair(x, y));
        }

        for (int i = 0; i < m; i++) {
            Pair closest = pq.poll(); 
            closest.x += 2; 
            closest.y += 2; 
            pq.offer(closest); 
        }

        Pair result = pq.poll(); 
        System.out.println(result.x + " " + result.y);
    }
}

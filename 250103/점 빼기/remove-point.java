import java.util.Scanner;
import java.util.TreeSet;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if(this.x != p.x)
            return this.x - p.x;  // x 기준 오름차순 정렬
        else
            return this.y - p.y;  // x가 같다면, y 기준 오름차순 정렬
    }
}

public class Main {
    public static final int MAX_N = 100000;
    
    public static int n, m;
    
    public static Point[] points = new Point[MAX_N];
    public static TreeSet<Point> s = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }

        for(int i = 0; i < n; i++)
            s.add(points[i]);
        
       
        while(m-- > 0) {
            int k = sc.nextInt();

            if(s.higher(new Point(k, -1)) == null)
                System.out.println("-1 -1");
            else {
                Point target = s.higher(new Point(k, -1));
                System.out.println(target.x + " " + target.y);
                s.remove(target);
            }
        }
    }
}
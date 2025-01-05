import java.util.Scanner;
import java.util.TreeSet;

class Pair implements Comparable<Pair> {
    int l, p;

    public Pair(int l, int p) {
        this.l = l;
        this.p = p;
    }

    @Override
    public int compareTo(Pair p2) {
        if(this.l != p2.l)
            return this.l - p2.l; 
        else
            return this.p - p2.p;  
    }
}

public class Main {

    public static int n, m;
    
    public static TreeSet<Pair> problems = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int l = sc.nextInt();


            problems.add(new Pair(l, p));
        }

        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            String command = sc.next();

            if(command.equals("ad")) {
                int p = sc.nextInt();
                int l = sc.nextInt();

                problems.add(new Pair(l, p));
            }
            else if(command.equals("sv")) {
                int p = sc.nextInt();
                int l = sc.nextInt();

                problems.remove(new Pair(l, p));
            }
            else {
                int x = sc.nextInt();

                if(x == 1)
                    System.out.println(problems.last().p);

                else
                    System.out.println(problems.first().p);
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int max = Math.max(a,b);
    
        int min = Math.min(a,b);
    
        if (a == min) {
            a = min + 10;
            b = max * 2;
        } else {
            a = max * 2;
            b = min + 10;
        }
        System.out.print(a+" "+b);

    }
}
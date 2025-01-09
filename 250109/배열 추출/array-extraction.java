import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n; i++){
            int input = Integer.parseInt(br.readLine());
            if(input != 0){
                pq.add(-input);
            }else if(pq.isEmpty()){
                System.out.println(0);
            }else System.out.println(-pq.poll());
        }
    }
}
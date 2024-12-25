import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //정답은 동적 자료구조
        HashSet<Integer> answer = new HashSet<>();
        HashSet<Integer> A = new HashSet<>();
        HashSet<Integer> B = new HashSet<>();


        // int [] A = new int[N];
        // int [] B = new int[M];
        //
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            int input = Integer.parseInt(st.nextToken());
            A.add(input);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            int input = Integer.parseInt(st.nextToken());
            B.add(input);
        }
        for(int i : A){
            if(!B.contains(i)){
                answer.add(i);
            }
        }

        for(int i : B){
            if(!A.contains(i)){
                answer.add(i);
            }
        }
        System.out.println(answer.size());

    }
}
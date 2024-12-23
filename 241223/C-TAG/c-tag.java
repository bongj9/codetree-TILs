import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());

        String[] groupA = new String[N];
        String[] groupB = new String[N];

        for (int i = 0; i < N; i++) {
            groupA[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            groupB[i] = br.readLine();
        }

        int count = 0;

        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    Set<String> setA = new HashSet<>();
                    Set<String> setB = new HashSet<>();

                    for (String s : groupA) {
                        setA.add("" + s.charAt(i) + s.charAt(j) + s.charAt(k));
                    }

                    for (String s : groupB) {
                        setB.add("" + s.charAt(i) + s.charAt(j) + s.charAt(k));
                    }

                    boolean valid = true;
                    for (String comb : setA) {
                        if (setB.contains(comb)) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        count++;
                    }
                }
            }
        }

        
        System.out.println(count);
    }
}

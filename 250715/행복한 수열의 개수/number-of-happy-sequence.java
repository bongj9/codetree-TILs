import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int happycount = countHappySequences(grid, n, m);
        System.out.println(happycount);
    }

    // 행과 열에서 'm개 이상 연속된 동일 숫자'가 있는지 모두 검사
    static int countHappySequences(int[][] grid, int n, int m) {
        int happycount = 0;

        // 1) 행 검사
        for (int i = 0; i < n; i++) {
            if (isHappySequence(grid[i], m)) {
                happycount++;
            }
        }

        // 2) 열 검사
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = grid[i][j];
            }
            if (isHappySequence(column, m)) {
                happycount++;
            }
        }

        return happycount;
    }

    // 연속된 동일 숫자가 m개 이상 있는지 확인
    static boolean isHappySequence(int[] arr, int m) {
    int count = 1;
    if (count >= m) return true;   // ★ 루프 전에 한 번 검사

    for (int i = 1; i < arr.length; i++) {
        if (arr[i] == arr[i - 1]) {
            count++;
        } else {
            count = 1;
        }
        if (count >= m) {
            return true;
        }
    }
    return false;
}
}
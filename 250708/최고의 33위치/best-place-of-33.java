import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int answer = dp(grid, n, 0, 0);   // (row = 0, col = 0)부터 탐색
        System.out.println(answer);
    }

    /** row, col 을 왼쪽-위 꼭짓점으로 하는 3×3 블록부터 끝까지 순회하며 최대 동전 수를 반환 */
    private static int dp(int[][] g, int n, int row, int col) {
        // 더 이상 3×3을 놓을 수 없는 행까지 내려온 경우
        if (row > n - 3) return 0;

        // 해당 행에서 더 이상 3×3을 놓을 수 없는 열이면 다음 행 첫 열로 이동
        if (col > n - 3) return dp(g, n, row + 1, 0);

        // 현재 (row, col)을 왼쪽-위 꼭짓점으로 하는 3×3 합계
        int sum = 0;
        for (int i = row; i < row + 3; i++)
            for (int j = col; j < col + 3; j++)
                sum += g[i][j];

        // 현재 합 vs. 같은 행의 다음 열부터 얻을 수 있는 최대값 중 큰 것
        return Math.max(sum, dp(g, n, row, col + 1));
    }
}
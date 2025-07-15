import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] grid;
    static boolean[][] visited;
    static int answer = 0;
    // 상하좌우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // 모든 시작점에서 DFS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, grid[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    /**
     * @param x     현재 행
     * @param y     현재 열
     * @param depth 지금까지 선택한 칸 수 (1~3)
     * @param sum   지금까지의 합
     */
    static void dfs(int x, int y, int depth, int sum) {
        // 3칸을 다 선택했으면 최대값 갱신
        if (depth == 3) {
            answer = Math.max(answer, sum);
            return;
        }

        // 4방향으로 뻗어가며 3칸짜리 모양 모두 탐색
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + grid[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}
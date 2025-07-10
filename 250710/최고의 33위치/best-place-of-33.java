import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
    }

    static int dp(int[][] grid, int n, int row, int col){
        //멈추는 방식
        if(row + 3 > n) return 0;
        //다음 열로 이동 
        if(col > n - 3){
            return dp(grid, n, row + 1, col);
        }

        int sum = 0;
        for(int i = row ; i < row + 3 ; i++){
            for(int j = col ; j < col + 3 ; j++){
                sum += grid[i][j];

                return Math.main(sum, dp(grid,n,row,col + 1));
            }
    }
}
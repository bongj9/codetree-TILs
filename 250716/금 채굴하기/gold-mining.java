import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();      // 격자 크기
        int M = sc.nextInt();      // 금 한 개당 가격
        int[][] grid = new int[n][n];
        int totalGold = 0;         // 전체 금 개수 (최적화용)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) totalGold++;
            }
        }

        int answer = 0;
        // 1) 가능한 모든 “센터”를 찍는다
        for(int cx = 0; cx < n; cx++){
            for(int cy = 0; cy < n; cy++){

                // 2) K 반경(Y축 거리 + X축 거리 ≤ K) 을 늘려 가면서
                for(int K = 0; K <= 2*n; K++){
                    int cost = K*K + (K+1)*(K+1);
                    // 이익이 날 여지가 없으면 더 큰 K도 패스
                    if(cost > totalGold * M) break;

                    // 3) 이 마름모 안에 있는 금을 센다
                    int cnt = 0;
                    for(int x = 0; x < n; x++){
                        for(int y = 0; y < n; y++){
                            // 맨해튼 거리 ≤ K → 마름모 영역
                            if(Math.abs(cx - x) + Math.abs(cy - y) <= K) {
                                if(grid[x][y] == 1) cnt++;
                            }
                        }
                    }

                    // 4) 수익성 검사: cnt * M ≥ cost
                    if(cnt * M >= cost) {
                        answer = Math.max(answer, cnt);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

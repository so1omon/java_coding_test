package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1832
 * Solution using
 * 2023/03/22
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.Stack;

class Solution_18_보행자_천국 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][][] dp = new int[m][n][4]; // 상 좌 하 우

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j] = new int[]{0,0,1,1};
                    continue;
                }
                int type = cityMap[i][j];
                dp[i][j] = new int[4];
                if(type==1){ // 통행 금지구역
                    continue;
                }
                // 상
                if(i!=0){ // 맨 위가 아니면 위에서 내려주는 만큼
                    dp[i][j][0] = dp[i-1][j][2];
                }
                // 좌
                if(j!=0){
                    dp[i][j][1] = dp[i][j-1][3];
                }

                // 하, 우 (타입에 따라서)
                if(type==0){ //자유 통행
                    dp[i][j][2] = (dp[i][j][0] + dp[i][j][1])%MOD;
                    dp[i][j][3] = (dp[i][j][0] + dp[i][j][1])%MOD;
                }else{
                    dp[i][j][2] = (dp[i][j][0])%MOD;
                    dp[i][j][3] = (dp[i][j][1])%MOD;
                }
            }
        }

        // [2] 또는 [3], 상관없음
        return dp[m-1][n-1][2];
    }

}

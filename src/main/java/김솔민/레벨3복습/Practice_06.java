package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898#
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Practice_06 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] dp = new int[n][m]; // 높이n * 너비m

        for(int[] puddle : puddles){
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }

        dp[0][0] = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==-1){
                    continue;
                }
                if(i>0 && dp[i-1][j]!=-1){
                    dp[i][j]+=dp[i-1][j] % 1000000007;
                }
                if(j>0 && dp[i][j-1]!=-1){
                    dp[i][j]+=dp[i][j-1] % 1000000007;
                }
            }
        }

        return dp[n-1][m-1]% 1000000007;
    }
}

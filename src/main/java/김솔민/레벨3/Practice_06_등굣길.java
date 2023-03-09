package 김솔민.레벨3;
import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42898#
 * Solution using
 * 2023/03/06
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_06_등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        for(int[] puddle : puddles){
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }
        dp[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 && j==0) || dp[i][j]==-1){
                    continue;
                }
                int left = j!=0?Math.max(dp[i][j-1],0):0;
                int upward = i!=0?Math.max(dp[i-1][j],0):0;

                dp[i][j] = (left+upward)%1000000007;

            }
        }

        return dp[n-1][m-1];
    }
}

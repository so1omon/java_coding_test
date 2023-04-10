package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12971
 * Solution using
 * 2023/04/05
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution_06 {
    public int solution(int sticker[]) {
        int answer = 0;

        if(sticker.length==1){
            return sticker[0];
        }

        int[][] dp1 = new int[sticker.length+1][2];
        int[][] dp2 = new int[sticker.length+1][2];
        dp1[0] = new int[]{sticker[0], 0};
        dp2[0] = new int[]{0,0};

        for(int i=1;i<sticker.length;i++){
            dp1[i][0] = dp1[i-1][1]+sticker[i];
            dp1[i][1] = Math.max(dp1[i-1][0], dp1[i-1][1]);
            dp2[i][0] = dp2[i-1][1]+sticker[i];
            dp2[i][1] = Math.max(dp2[i-1][0], dp2[i-1][1]);
        }

        return Math.max(dp1[sticker.length-1][1], dp2[sticker.length-1][0]);
    }
}
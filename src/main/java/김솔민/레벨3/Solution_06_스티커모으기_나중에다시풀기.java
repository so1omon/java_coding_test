package 김솔민.레벨3;
import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12971
 * Solution using
 * 2023/03/06
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_06_스티커모으기_나중에다시풀기 {
    public int solution(int sticker[]) {
        int len = sticker.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = sticker[0];
        dp2[0] = 0;

        //dp1
        for(int i=1;i<len;i++){
            if(i==1 || i==len-1){
                dp1[i] = dp1[i-1];
            }
            else{
                dp1[i] = Math.max(dp1[i-1], sticker[i]+dp1[i-2]);
            }
        }

        //dp2
        if(sticker.length!=1){
            dp2[1] = sticker[1];
            for(int i=2;i<len;i++){
                dp2[i] = Math.max(dp2[i-1], sticker[i]+dp2[i-2]);
            }
        }
        System.out.println(dp1[len-1] +" " + dp2[len-1]);
        return Math.max(dp1[len-1], dp2[len-1]);
    }
}

package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64062
 * Solution using
 * 2023/04/05
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_04 {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int left = 0;
        int right = 200000000;

        while(left<=right){
            int mid = (left+right)/2;
            // System.out.println(mid);
            int cnt = 0;
            int max = 0;
            for(int stone : stones){
                if(stone<=mid){
                    cnt++;
                    max = Math.max(max, cnt);
                }else{
                    cnt=0;
                }
            }

            if(max<=k-1){
                answer = Math.max(mid, answer);
                left = mid+1;
            }else{
                right = mid-1;
            }
        }


        return answer+1;
    }
}
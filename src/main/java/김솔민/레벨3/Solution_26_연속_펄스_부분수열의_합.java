package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/161988
 * 2023/03/29
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.ArrayList;
import java.util.List;

class Solution_26_연속_펄스_부분수열의_합 {
    public long solution(int[] sequence) {
        long answer = 0;
        int len = sequence.length;
        // sequence를 두 개로 분리해서 부분합 최댓값 구하기
        for(int i=0;i<len;i+=2){
            sequence[i]*=(-1);
        }

        long temp_sum = 0;
        long max = 0;

        for(int i=0;i<len;i++){
            temp_sum+=sequence[i];
            max = Math.max(temp_sum, max);
            if(temp_sum<0){// 합을 구할 때 0보다 작아지면 다음 껄로 넘어가기
                temp_sum =0;
                continue;
            }
        }
        temp_sum = 0;
        for(int i=0;i<len;i++){
            sequence[i]*=(-1);
        }
        for(int i=0;i<len;i++){
            temp_sum+=sequence[i];
            max = Math.max(temp_sum, max);
            if(temp_sum<0){// 합을 구할 때 0보다 작아지면 다음 껄로 넘어가기
                temp_sum =0;
                continue;
            }
        }

        return max;
    }
}

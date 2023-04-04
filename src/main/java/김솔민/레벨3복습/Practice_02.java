package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938#
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;
class Practice_02 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(s < n){
            return new int[]{-1};
        }

        Arrays.fill(answer, s/n);

        for(int i=0;i<s%n;i++){
            answer[n-i-1]++;
        }

        return answer;
    }
}

package 김솔민.레벨3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12987
 * Solution using
 * 2023/03/02
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_03_숫자_게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int idx = B.length-1;
        // 전략 : A,B 둘다 오름차순 정렬 (B는 A의 순서를 알기 때문에 순서가 중요하지 않음)
        // A에서 B[idx]를 확인하고, 더 크다면 패스
        // 더 작다면 idx++, answer++
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=A.length-1;i>=0;i--){
            if(A[i]<B[idx]){
                idx--;
                answer++;
            }
        }

        return answer;
    }
}

package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12987
 * Solution using
 * 2023/04/05
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Solution_03 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        List<Integer> teamA = new ArrayList<>();
        List<Integer> teamB = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            teamA.add(A[i]);
            teamB.add(B[i]);
        }
        Collections.sort(teamA);
        Collections.sort(teamB);

        int ptr = 0;
        for(int i=0;i<teamB.size();i++){
            if(teamB.get(i) > teamA.get(ptr)){
                ptr++;
                answer++;
            }else{
                continue;
            }
        }


        return answer;
    }
}
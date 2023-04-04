package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Practice_11 {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a1, a2)->{
            return a1[1] - a2[1];
        });

        for(int[] route : routes){
            q.add(route);
        }
        // 종료 시점을 기준으로 오름차순
        // 하나 뽑고 종료 시점보다 시작시점이 빠르거나 같은애들 계속 뽑기
        // 다 없애고 count++
        while(!q.isEmpty()){
            int target = q.peek()[1];
            while(!q.isEmpty() && q.peek()[0]<=target){
                q.poll();
            }
            answer++;
        }


        return answer;
    }
}

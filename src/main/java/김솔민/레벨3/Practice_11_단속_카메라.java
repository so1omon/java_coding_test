package 김솔민.레벨3;
import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42884#
 * Solution using
 * 2023/03/10
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_11_단속_카메라 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (arr1, arr2)->{
            return arr1[1]-arr2[1];
        });

        int cam = Integer.MIN_VALUE;

        for(int[] route : routes) {
            if(cam < route[0]) {
                // 현재 카메라의 위치가 route의 시작 지점보다 작으면
                // 새로운 cam을 route의 종료 지점에 설치한다
                cam = route[1];
                answer++;
            }
        }

        return answer;
    }
}

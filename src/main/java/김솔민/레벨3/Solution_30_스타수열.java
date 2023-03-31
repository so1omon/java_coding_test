package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * 2023/03/31
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;

class Solution_30_스타수열 {
    public int solution(int[] a) {
        int answer = 0;

        // 3번 중복 -> 무조건 뺴기
        // 2번 중복 -> i가 1이거나 3번째/4번째 뒤가 자기랑 똑같으면 빼기
        int[][] occupy = new int[500000][2]; // 가능한 스타수열 수, 마지막 점유인덱스
        for(int i=0;i<a.length;i++){
            occupy[i][1] = -1;
        }

        for(int i=0;i<a.length;i++){
            int target = a[i];
            if(i-occupy[target][1]<=1){ // 맨 처음이거나 점유인덱스 바로 뒤 또는 점유인덱스 내
                if(i!=a.length-1 && a[i+1]!=target){
                    occupy[target][0]++;
                }
                occupy[target][1] = i+1;
            }else{
                occupy[target][1] = i;
                occupy[target][0]++;
            }
            answer = Math.max(answer, occupy[target][0]);
        }


        return answer*2;
    }
}

package 김솔민.레벨3;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927#
 * Solution using
 * 2023/03/04
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_03_야근지수 {
    public long solution(int n, int[] works) {
        long answer = 0;

        // works를 정렬
        // works 맨 뒤에서부터 temp를 저장 (max값 확인용도)
        // works[i]!=temp일 때까지 반복해서 n을 빼고, n이 0이 되는 시점에
        // 값 계산하기

        Arrays.sort(works);

        int maxIdx = works.length-1;

        int temp = works[maxIdx];

        for(int i=maxIdx;works[i]!=0;i--){

            if(works[i]!=temp){
                temp = works[maxIdx];
                i = maxIdx+1;
                continue;
            }
            if(n==0 || temp ==0){
                break;
            }
            n--;
            works[i]--;

            if(i==0){
                temp = works[maxIdx];
                i = maxIdx+1;
            }
        }

        for(int work : works){
            answer+=Math.pow(work, 2);
        }

        return answer;
    }
}

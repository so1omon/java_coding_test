package 김솔민.레벨1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * Solution using
 * 2023/01/07
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_14_MyAnswer_Success {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        int total = 0;

        while(total<progresses.length){
            int result = 0; //1회 순환 시 작업이 끝난 갯수

            for(int i=0;i<progresses.length;i++){
                if(progresses[i]!=-1)
                    progresses[i]+=speeds[i];
                if(progresses[i]>=100){
                    progresses[i]=-1;
                }
            }

            for(int j=total;j< progresses.length;j++){
                if(progresses[j]!=-1){
                    break;
                }else{
                    result++;
                }
            }

            if(result!=0){
                total+=result;
                answer.add(result);
            }
        }

        int[] answerTotal = new int[answer.size()];
        int i=0;
        for(int ans : answer){
            answerTotal[i++]=ans;
        }
        return answerTotal;
    }

    public static void main(String[] args) {
        Solution_14_MyAnswer_Success solution14 = new Solution_14_MyAnswer_Success();
        int[] progresses={93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(solution14.solution(progresses, speeds));
    }
}

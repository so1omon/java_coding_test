package 김솔민;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java
 *  Solution using ArrayList
 *  2023/01/02
 *
 *
 *  <Memo>
 *  </Memo>
 */
class Solution_07_MyAnswer_Success {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //1. n명의 1,1,1,1 배열 만들기

        List<Integer> total = new ArrayList<>();

        for(int i=0;i<n;i++){
            total.add(1);
        }

        //2. lost만큼 1씩 빼기

        for(int i=0;i<lost.length;i++){
            int targetIdx = lost[i]-1;
            int origin_clothes = total.get(targetIdx);
            total.set(targetIdx, origin_clothes-1);
        }

        //3. reserve만큼 1씩 더하기
        for(int i=0;i<reserve.length;i++){
            int targetIdx = reserve[i]-1;
            int origin_clothes = total.get(targetIdx);
            total.set(targetIdx, origin_clothes+1);
        }

        System.out.println(total);
        //4. 전체 배열을 돌면서 구하기
        for(int i=0;i<n;i++){
            if(total.get(i)==0){
                if(i!=n-1){ // 마지막 원소가 아닌 경우
                    if(total.get(i+1)==2){
                        total.set(i, 1);
                        total.set(i+1, 1);
                        continue;
                    }
                }
                if(i!=0){ // 첫 번째 원소가 아닌 경우
                    if(total.get(i-1)==2){
                        total.set(i-1, 1);
                        total.set(i, 1);
                        continue;
                    }
                }
            }
        }

        //5. 결과 구하기
        for(int i=0;i<n;i++){
            if(total.get(i)!=0){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_07_MyAnswer_Success solution07 = new Solution_07_MyAnswer_Success();

        int n = 4;
        int[] lost = {2};
        int[] reserve = {4};
        System.out.println(solution07.solution(n,lost, reserve));

    }
}

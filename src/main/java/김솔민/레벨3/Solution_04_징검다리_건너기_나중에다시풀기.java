package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using Binary Search
 * 2023/03/03
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_04_징검다리_건너기_나중에다시풀기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;

        while(min<=max){
            int mid = (min+max)/2;

            // 건널 수 있으면 늘리기
            if(canGo(stones, k, mid)){
                min = mid+1;
                answer = answer>mid?answer:mid;
            }else{ // 못건너면 줄이기
                max = mid-1;
            }


        }

        return answer;
    }

    boolean canGo(int[] stones, int k, int cnt){
        int skip = 0;

        for(int stone : stones){
            if(stone<cnt){
                skip++;
            }else{
                skip = 0;
            }
            if(skip==k){
                return false;
            }
        }

        return true;

    }
}

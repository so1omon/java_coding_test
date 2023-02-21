package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 * Solution using
 * 2023/02/21
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_33_택배배달과_수거하기 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 전략 : 맨 뒤에서부터 cap만큼 뺼 수 있을 때까지 뺴기
        // curD (배달 가야할 마지막 지점), curP(수거해야 할 마지막 지점) 구하기
        // 배달가는 반복, 수거 반복 2번의 반복을 계속해서 돌기
        int curD = getTotalPoint(deliveries, n);
        int curP = getTotalPoint(pickups, n);

        while(!((curD== -1) && (curP==-1))){
            // 1. curD와 curP를 비교하고, 더 큰 값으로 answer+=(max+1)*2 (인덱스)
            if(curD > curP){
                answer+=(curD+1)*2;
            }else{
                answer+=(curP+1)*2;
            }
            // 2. curD와 curP에 대해서 cap만큼 뺄수 있을 때까지 빼고, 더이상 못빼면 -1 할당
            curD = deliverAndPickup(deliveries, curD, cap);
            curP = deliverAndPickup(pickups, curP, cap);
        }

        return answer;
    }


    // 배달 지점 구하기
    int getTotalPoint(int[] road, int idx){

        for(int i=idx-1;i>=0;i--){
            if(road[i]!=0){
                return i;
            }
        }

        return -1;
    }

    int deliverAndPickup(int[] road, int idx, int cap){
        int temp = 0;
        while(idx!=-1){
            // curD부터 택배가 존재하는 지점까지 temp보다 크거나 같을 때까지 계속 더하기
            temp+=road[idx];
            road[idx] = 0;
            // 만약 cap과 같다면 -> 마지막으로 더한 지점에서 getTotalPoint 실행
            if (temp==cap){
                return getTotalPoint(road, idx);
                // cap보다 크다면 -> 현재 지점의 값을 그 차이만큼 빼고 현재 지점으로 옮기기
            }else if (temp>cap){
                road[idx] = temp-cap;
                return idx;
            }

            idx = getTotalPoint(road, idx);
        }

        return idx;
    }
}

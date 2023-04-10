package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979
 * Solution using
 * 2023/04/05
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_01 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        for(int i=-1;i<stations.length;i++){
            int interval;

            if(i==-1){
                interval = stations[0] - w -1;
            }else if(i==stations.length-1){
                interval = n - stations[i] - w;
            }else{
                interval = stations[i+1]-stations[i]-2*w-1;
            }
            // System.out.println(interval);
            if(interval>0){

                int result = (interval/(1+2*w));
                if(interval%(1+2*w)!=0){
                    result+=1;
                }
                answer += result;
            }
        }

        return answer;
    }
}

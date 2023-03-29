package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 * 2023/03/29
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Solution_24_디스크_컨트롤러_나중에다시풀기 {
    public int solution(int[][] jobs) {
        int answer = 0;

        // 정렬 -> q빼기 -> 반복
        PriorityQueue<int[]> q = new PriorityQueue<>((arr1, arr2)->{
            if(arr1[1] == arr2[1]){
                return arr2[0]-arr1[0];
            }
            return arr1[1]-arr2[1];
        });

        Arrays.sort(jobs, (arr1, arr2)->{
            return arr1[0]-arr2[0];
        });


        int sum = 0;
        q.add(jobs[0]);

        int cur = 1; // jobs idx
        int time = jobs[0][0];


        while(cur<jobs.length && jobs[cur][0]==time){
            q.add(jobs[cur]);
            cur++;
        }


        while(!q.isEmpty()){
            int[] target = q.poll();
            time+=target[1];
            sum+=time-target[0];

            while(cur<jobs.length){
                if(jobs[cur][0]<=time){
                    q.add(jobs[cur]);
                    cur++;
                }else{
                    break;
                }
            }


            if(cur<jobs.length && q.isEmpty()){
                int[] first = jobs[cur];
                q.add(first);
                time = first[0];
                cur++;

                while(cur<jobs.length && jobs[cur][0]==first[0]){
                    q.add(jobs[cur]);
                    cur++;
                }
            }
        }


        return sum/jobs.length;
    }
}

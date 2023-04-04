package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12927#
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Practice_03 {
    public long solution(int n, int[] workss) {
        long answer = 0;
        Integer[] works = new Integer[workss.length];
        for(int i=0;i<workss.length;i++){

            works[i] = Integer.valueOf(workss[i]);
        }

        Arrays.sort(works,(x,y)->y-x);

        int temp = works[0];
        int i=0;


        while(n!=0){
            if(temp==0) break;
            if(works[i]==temp){
                works[i]--;
                n--;
                i=(i+1)%works.length;
            }else{
                i=0;
                temp = works[i];
            }
        }

        for(int j : works){
            answer+=Math.pow(j, 2);
        }

        return answer;
    }
}

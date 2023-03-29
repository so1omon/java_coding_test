package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/152995#
 * 2023/03/29
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Solution_25_인사고과_나중에다시풀기 {
    public int solution(int[][] scores) {
        int len = scores.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(new int[]{scores[i][0], scores[i][1],i});
        }
        list.sort((arr1, arr2)->{
            if(arr1[0]==arr2[0]){
                return arr1[1]-arr2[1];
            }
            return arr2[0]-arr1[0];
        });


        int max = 0;
        int rank = 1;
        int buffer = 0;
        int max_score=scores[0][0]+scores[0][1];

        for(int i=0;i<len;i++){
            int[] target = list.get(i);
            if(target[1]<max){
                if(target[2]==0) return -1;
            }else{
                max = target[1];
                if(target[0]+target[1] > max_score){
                    rank++;
                }
            }
        }


        return rank;
    }
}

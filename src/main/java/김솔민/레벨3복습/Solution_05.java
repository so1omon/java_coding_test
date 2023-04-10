package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 * Solution using
 * 2023/04/05
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;
class Solution_05 {
    static int[] min_interval = new int[2];
    static int min_value = Integer.MAX_VALUE;
    public int[] solution(String[] gems) {

        Map<String, Integer> map = new HashMap<>();
        Set<String> gemSet = new HashSet<>();
        for(String gem : gems){
            gemSet.add(gem);
        }
        int kinds = gemSet.size();

        int first = 0;
        for(int i=0;i<gems.length;i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
            while(first<i && map.get(gems[first])!=1){
                map.put(gems[first], map.getOrDefault(gems[first], 0)-1);
                if(map.get(gems[first])==0){
                    map.remove(first);
                }
                first++;
            }

            if(map.keySet().size()==kinds && min_value > i-first){
                min_value = i-first;
                min_interval[0] = first+1;
                min_interval[1] = i+1;
            }
        }

        return min_interval;
    }
}
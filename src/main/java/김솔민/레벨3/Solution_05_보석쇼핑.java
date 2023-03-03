package 김솔민.레벨3;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 * Solution using
 * 2023/03/03
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_05_보석쇼핑 {
    public int[] solution(String[] gems) {

        // 최초에 모든 보석의 종류수를 구하기
        Set<String> set = new HashSet<>();
        Map<String, Integer> gemMap = new HashMap<>();
        for(String gem : gems){
            set.add(gem);
        }

        int gemLen = set.size();
        // 맨앞부터 하나씩 담기 (Q,map에 담기)
        Queue<String> gemQ = new LinkedList<>();

        int start=1;
        int min = gems.length;

        int ptr = 0;
        for(int i=0;i<gems.length;i++){
            gemQ.add(gems[i]);
            gemMap.put(gems[i], gemMap.getOrDefault(gems[i], 0)+1);

            // 하나를 담을 때마다 다음 과정을 끝까지 반복
            // Queue에 맨 앞에 있는 보석의 개수가 2 이상이면 dequeue
            while(gemMap.get(gemQ.peek())>1){
                String target = gemQ.peek();
                gemMap.put(target, gemMap.get(target)-1);
                gemQ.poll();
                ptr++;
            }

            // map.size()==gemLen이면 즉시 범위 리턴
            if(gemMap.size()==gemLen && gemQ.size()<min){
                min = gemQ.size();
                start = ptr+1;
            }

        }

        return new int[]{start,start+min-1};
    }
}

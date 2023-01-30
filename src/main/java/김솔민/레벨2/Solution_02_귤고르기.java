package 김솔민.레벨2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 * Solution using
 * 2023/01/29
 *
 *
 * <Memo>
 *   Collections.sort(mapValues, Collections.reverseOrder());
 * </Memo>
 */
class Solution_02_귤고르기 {
    public int solution(int k, int[] tangerine) {

        //1. tangerine을 정렬시키기
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : tangerine){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> mapValues = new ArrayList<>(map.values());

        Collections.sort(mapValues, Collections.reverseOrder());

        int sum = 0;
        int answer=0;
        int cur = 0;
        //2. k까지 set에 담기
        while(true){
            sum+=mapValues.get(cur++);
            // 만약 sum=k라면 반복문 종료
            if(sum>=k){
                answer++;
                break;
            }else if(sum<k){// sum<k라면 answer++해주고 다음꺼 돌리기
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution_02_귤고르기 solution02_귤고르기 = new Solution_02_귤고르기();
        int k=6;
        int[] targerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(solution02_귤고르기.solution(k, targerine));
    }
}

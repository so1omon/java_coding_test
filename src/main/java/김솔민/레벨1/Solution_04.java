package 김솔민.레벨1;

import java.util.HashMap;
import java.util.Iterator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 * Solution using HashMap
 */
class Solution_04 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){

            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }

        Iterator<Integer> iter = map.values().iterator();

        while(iter.hasNext()){
            int num = iter.next().intValue();
            answer=answer*(num+1);
        }

        return answer-1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution_04 sol = new Solution_04();
        System.out.print(sol.solution(clothes));
    }
}

package 김솔민;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/142086
 * Solution using
 * 2023/01/25
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_18_가장_가까운_글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();


        //1. s를 탐색하면서 Map<Character, Integer> 에 넣기, key : 발견한 문자, Integer : 마지막으로 해당 문자를 발견한 인덱스 number
        for(int i=0;i<s.length();i++){
            int foundIdx =map.getOrDefault(s.charAt(i), -1);

            if(foundIdx==-1){ // 발견 못했으면 answer에 -1 넣기
                answer[count++] = -1;
            }else{
                answer[count++] = i-foundIdx;
            }
            map.put(s.charAt(i), i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_18_가장_가까운_글자 solution18_가장_가까운_글자 = new Solution_18_가장_가까운_글자();
        String s = "banana";

        System.out.println(Arrays.toString(solution18_가장_가까운_글자.solution(s)));

    }
}

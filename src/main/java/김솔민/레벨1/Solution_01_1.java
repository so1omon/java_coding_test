package 김솔민.레벨1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * solution using HashMap plus Iterator
 */
class Solution_01_1 {
    public String solution(String[] participant, String[] completion ){
        String answer="";

        // 1. 참여자 HashMap 생성 (Key : 선수이름, value : 선수 카운트)
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant){
            map.put(player, map.getOrDefault(player,0)+1); // map.getOrDefault : player라는 값을 가진 value를 가져오기, 없으면 0(Default)
        }

        //2. 참여자 HashMap에서 완주한 선수 빼기
        for (String player : completion){
            map.put(player, map.get(player)-1);
        }

        //3. value가 0이 아닌 key값을 hashmap에서 찾기
        Iterator<Map.Entry<String,Integer>> iter = map.entrySet().iterator(); // HashMap을 (key,value)로 순회하게 하는 객체

        while(iter.hasNext()){ //
            Map.Entry<String, Integer>next = iter.next();
            if (next.getValue()!=0){
                answer=next.getKey();
            }
            break;
        }


        return answer;
    }
    public static void main(String[] args) {
        String[] part = {"eden", "kiki", "leo"};
        String[] comp = {"eden", "kiki",};

        Solution_01_1 sol = new Solution_01_1();
        System.out.println(sol.solution(part, comp));

    }
}

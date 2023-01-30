package 김솔민.레벨1;

import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 * solution using HashMap
 */
class Solution_01 {
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
        for (String key : map.keySet()){ // map이 가지고 있는 Key를 하나씩 꺼내기

            if(map.get(key)!=0){
                answer=key;
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        String[] part = {"eden", "kiki", "leo"};
        String[] comp = {"eden", "kiki",};

        Solution_01 sol = new Solution_01();
        System.out.println(sol.solution(part, comp));

    }
}

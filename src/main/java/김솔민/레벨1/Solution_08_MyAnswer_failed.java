package 김솔민.레벨1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/72411
 *  Solution using
 *  2023/01/02
 *
 *  <Memo>
 *  </Memo>
 */
class Solution_08_MyAnswer_failed {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        //1. List<HashSet<Character>>로 orders 분해


        List<List<Character>> total = new ArrayList<>();
        for(String order : orders){
            List<Character> characters = new ArrayList<>();
            for (int i=0;i<order.length();i++){
                characters.add(order.charAt(i));
            }
            total.add(characters);
        }

        //2. List에서 두 개씩 비교하면서 course가 중첩된 만큼 HashMap<Character, Integer>에 count
        HashMap<Integer, Integer> counts = new HashMap<>();

        for(int i=0;i<total.size();i++) {
            for(int j=i+1;j<total.size();j++){
                int count = duplicated(total.get(i), total.get(j)).size();
                counts.put(count, counts.getOrDefault(count,0)+1 );
            }
        }
        System.out.println(counts);

        //3 orders에 targetSet의 각각의 요소가 포함되었는지 확인하여 2개 이상이면 바로 answer에 HashSet을 조합한 문자 넣기

        return answer;
    }

    public List<Character> duplicated(List<Character> target1,List<Character> target2){
        List<Character> result = new ArrayList<>();
        for(Character c: target1){
            if(target2.contains(c)){
                result.add(c);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_08_MyAnswer_failed solution08MyAnswer = new Solution_08_MyAnswer_failed();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        System.out.println(solution08MyAnswer.solution(orders,course ));

    }
}

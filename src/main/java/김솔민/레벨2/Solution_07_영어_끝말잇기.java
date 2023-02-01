package 김솔민.레벨2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * Solution using Map
 * 2023/02/01
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_07_영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 1. 각각의 사용자의 턴수 배열을 초깃값 0으로 생성
        // 없어도 될듯
        // int[] turns = new int[n];

        // 2. words를 담는 Map
        Map<String, Integer> answered = new HashMap<>();

        for(int i=0;i<words.length;i++){

            // 첫 번째 턴에서는 아무런 탈락 조건이 없기 때문에 저장만
            if(i==0){
                answered.put(words[i], 1);
            }else{
                // 탈락조건 1.
                // 직전 대답의 맨 마지막 char가 입력으로 들어온 단어의 첫 글자가 아닐 때
                if ((words[i-1].charAt(words[i-1].length()-1) !=
                    words[i].charAt(0)) ||
                    // 탈락조건 2.
                    // 이미 List안에 답이 저장되어 있을 때
                    answered.containsKey(words[i])){
                    System.out.println(i);
                    answer[0] = (i)%n + 1;

                    if((i+1)%n!=0){
                        answer[1] =((i+1)/n)+1;
                    }else{
                        answer[1] = (i+1)/n;
                    }

                    break;
                }else{
                    answered.put(words[i], 1);
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int n=3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        Solution_07_영어_끝말잇기 solution07_영어_끝말잇기 = new Solution_07_영어_끝말잇기();
        System.out.println(solution07_영어_끝말잇기.solution(n, words));
    }
}

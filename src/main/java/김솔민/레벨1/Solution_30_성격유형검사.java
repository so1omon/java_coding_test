package 김솔민.레벨1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * Solution using
 * 2023/01/28
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_30_성격유형검사 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] defaultStr = "RTCFJMAN".toCharArray();

        // 0. 모든 성격 유형에 대한 점수를 Map<Character, Integer>로 저장 (기본 0)
        Map<Character, Integer> map = new HashMap<>();
        for(char d : defaultStr){
            map.put(d, 0);
        }

        // 1. survey를 loop돌리기
        // 2. 각각의 질문을 char로 나누기 [0] [1]
        // 3. (점수 - 4) 가 양수 -> 그만큼 [0]을 더하기
        // 4. (점수 - 4) 가 음수 -> 그만큼 [1]을 더하기
        for(int i=0;i<survey.length;i++){
            char first = survey[i].charAt(0);
            char last = survey[i].charAt(1);
            int score = choices[i]-4;

            if(score < 0){
                map.put(first, map.get(first)-score);
            }else if(score>0){
                map.put(last, map.get(last)+score);
            }
        }
        // map에 점수 다 더해짐
        // 5. RT, CF, JM, AN 각각의 점수를 4번 돌려가면서 Map의 값이랑 비교
        // 6. 비교 결과를 1) 점수순 2) 순수 char 사전순으로 더 높은 지표를 answer에 갖다붙이기
        for (int i=0;i<defaultStr.length;i+=2){ // 성격유형 두개씩 검사
            int firstScore = map.get(defaultStr[i]);
            int secondScore = map.get(defaultStr[i+1]);

            if(firstScore>secondScore){
                answer+=defaultStr[i];
            }else if(firstScore<secondScore){
                answer+=defaultStr[i+1];
            }else{
                if(defaultStr[i]>defaultStr[i+1]){ // 더 큰값이 사전순으로 늦음
                    answer+=defaultStr[i+1];
                }else{
                    answer+=defaultStr[i];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        System.out.println(new Solution_30_성격유형검사().solution(survey, choices));
    }
}

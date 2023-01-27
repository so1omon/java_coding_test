package 김솔민;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17682
 * Solution using
 * 2023/01/27
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_29_1차_다트게임_파싱이비효율적인듯 {
    public int solution(String dartResult) {
        int answer = 0;
        List<String> total = new ArrayList<>();

        // 0. 직전에 얻은 점수를 저장 (0으로 해도 지장없음)
        int preScore = 0;
        // 1. 점수 | 보너스 | 옵션 3개로 파싱

        int cur = 0;

        for(int i=1;i<dartResult.length();i++){
            char tempChr = dartResult.charAt(i);
            if(Character.isDigit(tempChr)){
                if(Character.isDigit(dartResult.charAt(i-1))){
                    continue;
                }else{
                    total.add(dartResult.substring(cur, i));
                    cur=i;
                }
            }else if(i==dartResult.length()-1){
                total.add(dartResult.substring(cur));
            }
        }
        System.out.println(total);
        // 2. 반복문을 돌면서 연산 수행
        for(String target : total){
            String score = "";
            int bonus = 1;
            char option = '-';

            for(int i=0;i<target.length();i++){
                char ch = target.charAt(i);
                switch(ch){
                    case 'S':
                        break;
                    case 'D':
                        bonus=2;
                        break;
                    case 'T':
                        bonus=3;
                        break;
                    case '*':
                    case '#':
                        option=ch;
                        break;
                    default:
                        score+=ch;
                }


            }
            int parsedScore = Integer.parseInt(score);
            if(option=='*'){//2배
                answer+=preScore;
                preScore = (int)Math.pow(parsedScore, bonus)*2;
                answer+=preScore;
            }else if(option=='#'){
                preScore = (int)Math.pow(parsedScore, bonus)*(-1);
                answer+=preScore;
            }else{
                preScore = (int)Math.pow(parsedScore, bonus);
                answer+=preScore;
            }

            // System.out.println(answer);
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution_29_1차_다트게임_파싱이비효율적인듯 solution29_1차_다트게임 = new Solution_29_1차_다트게임_파싱이비효율적인듯();

        String dartResult = "1S2D*3T";

        System.out.println(solution29_1차_다트게임.solution(dartResult));
    }
}

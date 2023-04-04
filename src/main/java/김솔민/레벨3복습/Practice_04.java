package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12904#
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.Arrays;

class Practice_04 {
    public int solution(String s){
        int answer = 0;


        for(int i=0;i<s.length();i++){
            int left =i-1, right = i+1;
            int temp = 1;
            while(left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    temp+=2;
                    left--;
                    right++;
                }else break;
            }
            answer = Math.max(answer, temp);
        }
        for(int i=0;i<s.length()-1;i++){
            int left =i, right = i+1;
            int temp = 0;
            while(left>=0 && right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    temp+=2;
                    left--;
                    right++;
                }else break;
            }
            answer = Math.max(answer, temp);
        }



        return answer;
    }
}

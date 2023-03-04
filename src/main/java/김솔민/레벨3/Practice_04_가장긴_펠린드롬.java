package 김솔민.레벨3;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12904#
 * Solution using
 * 2023/03/04
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_04_가장긴_펠린드롬 {
    public int solution(String s)
    {
        int answer = 0;
        int size = s.length();
        // 전략 : 0번 인덱스부터 시작해서 좌우로 퍼져나가면서 비교하는 펠린드롬을 판별
        // 최댓값을 저장

        for(int i=0;i<size;i++){
            int targetOdd = felindrom(s, i-1, i+1, size);
            int targetEven = felindrom(s, i, i+1, size);
            // System.out.println("홀수 "+targetOdd);
            // System.out.println("짝수 "+targetEven);
            answer = answer<targetOdd?targetOdd:answer;
            answer = answer<targetEven?targetEven:answer;
        }

        return answer;
    }

    public int felindrom(String s, int left, int right, int size){
        while(left>=0 && right<size){
            if(s.charAt(right)!=s.charAt(left)){
                break;
            }
            right++;
            left--;
        }

        return right-left-1;
    }
}

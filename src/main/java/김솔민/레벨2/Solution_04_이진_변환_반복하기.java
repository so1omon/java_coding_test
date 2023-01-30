package 김솔민.레벨2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 * Solution using
 * 2023/01/30
 *
 * <Memo>
 * </Memo>
 */
class Solution_04_이진_변환_반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        // 편의상 정수형 리스트로 저장하기
        List<Integer> temp = new ArrayList<>();
        for(char ch : s.toCharArray()){
            temp.add(ch-'0');
        }

        // 1. temp 길이는 항상 1 이상이고, 길이가 1이면 반복문 종료
        // 2. s를 탐색해서 1의 갯수를 oneLength에 저장

        while(temp.size()>1){
            answer[0]++;
            int oneLength = temp.size();
            for(int i=0;i<temp.size();i++){
                if(temp.get(i)==0){
                    answer[1]++;
                    oneLength--;
                }
            }
            // 3. oneLength를 이진 변환해서 temp에 저장
            temp.clear();

            while(oneLength>=2){
                temp.add(oneLength%2);
                oneLength/=2;
            }
            temp.add(oneLength);
            Collections.sort(temp, Collections.reverseOrder());
        }




        return answer;
    }

    public static void main(String[] args) {
        Solution_04_이진_변환_반복하기 solution04_이진_변환_반복하기 = new Solution_04_이진_변환_반복하기();
        String s= "110010101001";

        System.out.println(solution04_이진_변환_반복하기.solution(s));
    }
}

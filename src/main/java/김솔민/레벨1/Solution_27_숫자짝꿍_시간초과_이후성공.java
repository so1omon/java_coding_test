package 김솔민.레벨1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using StringBuilder()
 * 2023/01/26
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_27_숫자짝꿍_시간초과_이후성공 {
    public String solution(String X, String Y) {

        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        //1. Map에 두 개의 각각 숫자의 갯수 넣기
        for(int i=0;i<X.length();i++){
            xMap.put(X.charAt(i), xMap.getOrDefault(X.charAt(i), 0)+1);
        }
        for(int i=0;i<Y.length();i++){
            yMap.put(Y.charAt(i), yMap.getOrDefault(Y.charAt(i), 0)+1);
        }

        List<Integer> total = new ArrayList<>();

        String iter = "9876543210";
        //2. 0~9까지 돌면서 개수 최소값 구하기
        for(char i : iter.toCharArray()){
            int count = Math.min(xMap.getOrDefault(i,0),
                    yMap.getOrDefault(i,0));

            for(int j=0;j<count;j++){
                answer.append(i);
            }
        }

        String totalAnswer = answer.toString();

        if(totalAnswer.length()==0){
            return "-1";
        }else if(totalAnswer.charAt(0)=='0'){
            return "0";
        }

        return totalAnswer;
    }
    public static void main(String[] args) {
        String X = "100";
        String Y = "2345";
        Solution_27_숫자짝꿍_시간초과_이후성공 solution27_숫자짝꿍 = new Solution_27_숫자짝꿍_시간초과_이후성공();
        System.out.println(solution27_숫자짝꿍.solution(X, Y));

    }
}

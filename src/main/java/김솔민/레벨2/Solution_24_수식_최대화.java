package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 * Solution using
 * 2023/02/10
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_24_수식_최대화 {
    // 전체 보드 만들기
    public long solution(String expression) {
        long answer = 0;

        // 1. 연산기호에 대한 매핑정보
        Map<Character, Boolean> map = new HashMap<>();

        for(Character s : "*+-".toCharArray()){
            if(expression.indexOf(s)!=-1){
                map.put(s, true);
            }
        }

        String operators = "";

        for(Character s : map.keySet()){
            operators+=s;
        }

        int[][] turns;
        if(operators.length()==1){
            turns = new int[1][1];
            turns[0] = new int[]{0};
        }else if(operators.length()==2){
            turns = new int[2][2];
            turns[0] = new int[]{0,1};
            turns[1] = new int[]{1,0};
        }else{
            turns = new int[6][3];
            turns[0] = new int[]{0, 1, 2};
            turns[1] = new int[]{0, 2, 1};
            turns[2] = new int[]{1, 0, 2};
            turns[3] = new int[]{1, 2, 0};
            turns[4] = new int[]{2, 0, 1};
            turns[5] = new int[]{2, 1, 0};
        }

        // 문자열 분리
        long max = 0L;
        boolean[] visited = new boolean[operators.length()];

        for(int[] turn : turns){

            long result = Math.abs(calculateRecursive(expression, operators, turn,
                visited, 0, turn.length));

            if(result>max){
                max=result;
            }
        }

        return max;
    }


    long calculateRecursive(String s, String operators, int turns[],
                            boolean[] visited, int r, int depth){
        if(depth==0){
            return (long)Integer.parseInt(s);
        }

        String operator = Character.toString(operators.charAt(turns[r]));
        String[] splitted = s.split("\\"+operator);

        long total = calculateRecursive(
            splitted[0], operators, turns, visited, r+1, depth-1);

        for(int i=1;i<splitted.length;i++){
            switch(operator){
                case "+":
                    total += calculateRecursive(splitted[i], operators, turns, visited, r+1, depth-1);
                    break;
                case "*":
                    total *= calculateRecursive(splitted[i], operators, turns, visited, r+1, depth-1);
                    break;
                case "-":
                    total -= calculateRecursive(splitted[i], operators, turns, visited, r+1, depth-1);
                    break;
                default:
                    break;
            }
        }
        return total;
    }
}
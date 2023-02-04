package 김솔민.레벨2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * YYYY/MM/DD
 *
 *
 * <Memo>
 *   Map 초기화 방법
 *      new HashMap<>(){{
 *        put(~~,~~);
 *        put(~~,~~);
 *        put(~~,~~);
 *      }}
 * </Memo>
 */
class Solution_13_괄호_회전하기_속도오래걸림 {
    // 커플 괄호
    private static Map<Character, Character> couple = new HashMap<>(){{
        put('[',']');
        put('(',')');
        put('{','}');
    }};

    public int solution(String s) {
        int answer = 0;

        // cf) map 초기화 방법 찾아볼 것

        // 1. x칸만큼 회전시켰을 때 올바른 괄호 문자열인지 판단해주는 함수 만들어주기
        // 1-1. x: 0~s-1 iter
        for (int i=0;i<s.length();i++){
            if(isValidBracket(i, s)){
                answer++;
            }
        }
        return answer;
    }

    public boolean isValidBracket(int x, String s){
        // 환형 배열
        char[] rotated = new char[s.length()];
        char[] target = s.toCharArray();
        Stack<Character> stack =new Stack<>();

        // 환형 배열 초기화
        for(int i=0; i<s.length();i++){
            int targetIdx = (i+x)%s.length();
            rotated[i] = target[targetIdx];
        }

        // stack으로 유효성 검증
        for(char ch : rotated){
            // 1. stack이 비어있으면 push
            if(stack.isEmpty()){
                stack.push(ch);
            }
            // 2. stack이 비어있지 않으면 앞에껄 꺼내보기 (peek)
            else{
                char compareCh = stack.peek();
                // 2-1. 꺼낸 결과값이 내 짝이면 pop
                if (couple.containsKey(compareCh) &&
                    couple.get(compareCh)==ch){
                    stack.pop();
                }
                // 2-2. 꺼낸 결과값이 내 짝이 아니면 push
                else{
                    stack.push(ch);
                }
            }


        }
        if(stack.isEmpty()){
            return true;
        }else return false;

    }

    public static void main(String[] args) {

    }
}

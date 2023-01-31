package 김솔민.레벨2;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 * Solution using Stack
 * 2023/01/31
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_06_짝지어_제거하기 {
    public int solution(String s)
    {
        // 1. 문자열 저장 스택 생성
        Stack<Character> stack = new Stack<>();
        // 2. s에서 하나씩 계속 넣으면서 동일하면 삭제, 다르면 push
        for(char ch : s.toCharArray()){
            if(stack.isEmpty() || stack.peek()!=ch){
                stack.push(ch);
            }else{
                stack.pop();
            }
        }
        // 3. 스택이 비어있으면 1, 아니면 0

        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "baabaa";
        Solution_06_짝지어_제거하기 solution06_짝지어_제거하기 = new Solution_06_짝지어_제거하기();

        System.out.println(solution06_짝지어_제거하기.solution(s));
    }
}

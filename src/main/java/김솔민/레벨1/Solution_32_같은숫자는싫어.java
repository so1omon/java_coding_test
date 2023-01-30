package 김솔민.레벨1;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * Solution using
 * 2023/01/29
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_32_같은숫자는싫어 {
    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for(int i : arr){
            // 스택 비어있으면 그냥 스택에 넣고 answer에 추가하기
            if(stack.isEmpty() || stack.peek()!=i){
                stack.push(i);
            }
        }

        int[] answer = new int[stack.size()];

        for(int i=answer.length-1;i>=0;i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution_32_같은숫자는싫어 solution31_폰켓몬 = new Solution_32_같은숫자는싫어();
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(solution31_폰켓몬.solution(arr));
    }
}

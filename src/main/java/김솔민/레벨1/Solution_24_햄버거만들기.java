package 김솔민.레벨1;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * Solution using stack
 * 2023/01/25
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_24_햄버거만들기 {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int ing : ingredient){
            switch(ing){
                case 1: // 1들어오면 -> 앞에 3이면 4개 없애기, 3 아니면 일단놔두기
                    if(stack.isEmpty() || stack.peek()!=3){
                        stack.push(ing);
                    }else{
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        answer++;
                    }
                    break;
                case 2: // 2들어오면 -> 앞에 1아니면 죄다없애기
                case 3: // 3들어오면 -> 앞에 2아니면 죄다없애기
                    if(stack.isEmpty()||stack.peek()!=ing-1){
                        stack.clear();
                    }else{
                        stack.push(ing);
                    }

                    break;
                default:
                    break;
            }
        }

        return answer;
    }
}

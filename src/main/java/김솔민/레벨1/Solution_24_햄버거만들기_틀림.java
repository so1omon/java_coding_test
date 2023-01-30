package 김솔민.레벨1;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * Solution using
 * 2023/01/25
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_24_햄버거만들기_틀림 {
    public int solution(int[] ingredient) {
        int answer = 0;
        boolean counterFlag = false; // 123 판별

        Stack<Integer> stack = new Stack<>();

        for(int i : ingredient){
            switch(i){
                case 1:
                    if(counterFlag){ //켜졌을 떄
                        if (stack.peek()==3){
                            //3, 2, 1 제거
                            stack.pop();
                            stack.pop();
                            stack.pop();
                            answer++;
                            if(stack.isEmpty()){
                                counterFlag=false;
                            }
                        }else{
                            stack.push(i);
                        }
                    }else{ //안켜졌을 때
                        counterFlag=true;
                        stack.push(i);
                    }
                    break;
                case 2:
                case 3:
                    if(stack.isEmpty()){
                        break;
                    }
                    if(counterFlag && stack.peek() == (i-1)){
                        stack.push(i);
                    }else{
                        //1이 아닐때까지 stack 제거
                        stack.clear();
                        counterFlag=false;
                    }
                    break;
                default:
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_24_햄버거만들기_틀림 solution24_햄버거만들기 = new Solution_24_햄버거만들기_틀림();

        int[] ingredient = {1,2,3,3,2,3,1};
        try {
            System.out.println(solution24_햄버거만들기.solution(ingredient));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

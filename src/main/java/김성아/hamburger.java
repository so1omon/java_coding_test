package 김성아;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class hamburger {
    public int solution(int[] ingredient) {
        int answer = 0;
        boolean counterFlag = false; // 123 판별

        Stack<Integer> stack = new Stack<>();

        for (int i : ingredient) {
            switch (i) {
                case 1:
                    if (counterFlag) { //켜졌을 떄
                        if (stack.peek() == 3) {
                            //3, 2, 1 제거
                            stack.pop();
                            stack.pop();
                            stack.pop();
                            answer++;
                            if (stack.isEmpty()) {
                                counterFlag = false;
                            }
                        } else {
                            stack.push(i);
                        }
                    } else { //안켜졌을 때
                        counterFlag = true;
                        stack.push(i);
                    }
                    break;
                case 2:
                case 3:
                    if (stack.isEmpty()) {
                        break;
                    }
                    if (counterFlag && stack.peek() == (i - 1)) {
                        stack.push(i);
                    } else {
                        //1이 아닐때까지 stack 제거

                        while (!stack.isEmpty())
                            stack.pop();
                        counterFlag = false;
                        break;

                    }
            }



        }
        return answer;
    }
}

package 김솔민.레벨2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * Solution using
 * 2023/03/02
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_08_택배상자_나중에다시풀기 {
  public int solution(int[] order) {
    int answer = 0;
    int idx = 0;
    int cur = 1;
    Stack<Integer> stack =new Stack<>();

    while(idx<order.length){
      while(order[idx]!=cur && cur<=order.length){
        stack.push(cur++);
      }
      if(cur>order.length){
        break;
      }
      idx++;
      cur++;

      while(idx<order.length&&!stack.isEmpty() && stack.peek() == order[idx]){
        stack.pop();
        idx++;
      }
    }
    return order.length-stack.size();
  }
}

package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 * Solution using
 * 2023/02/18
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_05_뒤에있는_큰수찾기 {
  public int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];

    // Stack 이용
    Stack<Number> stack = new Stack<>();

    for(int i=0;i<numbers.length;i++){
      // 1. Stack이 비어있다면 number를 저장
      Number num = new Number(i, numbers[i]);
      if(stack.isEmpty()){
        stack.push(num);
        continue;
      }

      // 1-1. 비지 않았다면 스택 맨위에 있는 요소가 자기보다 작을 때까지 계속 뽑고,
      // 뽑힌 요소들은 현재 number가 뒷수임이 자명하기 때문에 answer에 저장
      while(!stack.isEmpty() && stack.peek().value < num.value){
        Number selected = stack.pop();
        answer[selected.idx] = num.value;
      }

      stack.push(num);
    }

    // 2. 루프를 전부 돌고 난 후 스택에 남아 있는 요소들을 전부 -1처리
    for(Number restNum : stack){
      answer[restNum.idx] = -1;
    }

    return answer;
  }

  class Number{
    int idx;
    int value;
    public Number(int idx, int value){
      this.idx = idx;
      this.value = value;
    }
  }
}

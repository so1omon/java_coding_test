package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 * Solution using
 * 2023/02/18
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_04_롤케이크_자르기_시간오래걸림 {
  public int solution(int[] topping) {
    int answer = 0;

    // 형꺼, 동생꺼 Map 두개로 생성
    Map<Integer, Integer> older = new HashMap<>();
    Map<Integer, Integer> younger = new HashMap<>();

    // 맨 처음에 동생꺼로 topping 다 몰아서 넣어주기
    for(int t : topping){
      younger.put(t, younger.getOrDefault(t, 0)+1);
    }

    // topping을 하나씩 돌면서 동생꺼에서 형꺼로 하나씩 넘겨주고, keyset 길이로 비교
    for(int t : topping){
      older.put(t, older.getOrDefault(t, 0)+1);
      younger.put(t, younger.get(t)-1);

      if(younger.get(t)==0){
        younger.remove(t);
      }

      if(younger.size()==older.size()){
        answer++;
      }

    }
    return answer;
  }
}

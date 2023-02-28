package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 * Solution using
 * 2023/02/28
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_07_숫자_변환하기_나중에다시풀어보기 {
    public int solution(int x, int y, int n) {
        int cnt = 0;
        HashSet<Integer> curr = new HashSet<>();
        HashSet<Integer> next = null;
        curr.add(x);

        while(!curr.isEmpty()){
            if(curr.contains(y)){
                return cnt;
            }
            next = new HashSet<>();
            for(int i : curr){
                if(i+n<=y) next.add(i+n);
                if(i*2<=y) next.add(i*2);
                if(i*3<=y) next.add(i*3);

            }
            curr = next;
            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}

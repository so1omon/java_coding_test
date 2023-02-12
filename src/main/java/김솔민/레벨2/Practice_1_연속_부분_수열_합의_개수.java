package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * Solution using
 * 2023/02/12
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_1_연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int total = 0; // 전체 총합

        for(int elem : elements){
            total+=elem;
        }

        set.add(total);
        // i : 고를 개수
        // j : 시작지점
        // l : i에 따른 반복회수 돌리기
        for(int i=1;i<=(elements.length/2)+1;i++){

            for(int j=0;j<elements.length;j++){
                int temp = 0;
                for(int l=0;l<i;l++){
                    temp+=elements[(j+l)%elements.length];
                }
                set.add(temp);
                set.add(total-temp);
            }
        }


        return set.size();
    }

    public static void main(String[] args) {

    }
}

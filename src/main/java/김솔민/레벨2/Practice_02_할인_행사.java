package 김솔민.레벨2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 * Solution using
 * 2023/02/17
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_02_할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // map을 두개를 생성, 하나는 want+number ,나머지는 discount에 뽑아오는 목록
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();

        for(int i=0;i<want.length;i++){
            wantMap.put(want[i], wantMap.getOrDefault(want[i], 0)+number[i]);
        }

        for (int i=0;i<=discount.length-10;i++){

            int sum=0;
            for(int j=i;j<i+10;j++){
                String d=discount[j];
                discountMap.put(d, discountMap.getOrDefault(d, 0)+1);
                if(discountMap.get(d) > wantMap.getOrDefault(d,0)){

                    break;
                }
                sum++;
            }

            if(sum==10){
                answer++;
            }

            discountMap.clear();
        }
        return answer;
    }
}

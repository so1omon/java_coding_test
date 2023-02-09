package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77885
 * Solution using
 * 2023/02/09
 *
 *
 * <Memo>
 *   이번거 시간이 좀 오래걸렸음 개선해야할듯
 * </Memo>
 */
class Solution_21_2개_이하로_다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        // cf) long to 2진수로 변환하는 함수 있는지 찾아보기
        // long 연산법 익히기
        int count = 0;
        for (long number : numbers){
            // 1. 짝수일 때 : 무조건 x+1

            if(number%2==0){
                answer[count++]=number+1;
                continue;
            }
            // 2. 홀수일 때 : 맨 아래 비트부터 연속되는 1이 끝나는 지점을 찾고, 해당 지점과
            //  그 다음 비트를 반전시킨 값
            List<Integer> reversed = new ArrayList<>();
            while(number!=0){
                reversed.add((int)(number%2));
                number/=2;
            }

            int targetIdx=-1;
            for(int i=0;i<reversed.size();i++){
                if(reversed.get(i)==0){
                    targetIdx=i;
                    break;
                }
            }

            // 전부 다 11111111일때
            if(targetIdx==-1){
                reversed.add(0);
                targetIdx = reversed.size()-1;
            }

            reversed.set(targetIdx, 1);
            reversed.set(targetIdx-1, 0);

            long temp = 0L;
            for(int i=0;i<reversed.size();i++){
                temp+=(long)reversed.get(i)*(long)Math.pow(2,i);
            }
            answer[count++]=temp;
        }

        return answer;
    }
}

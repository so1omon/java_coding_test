package 김솔민;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * Solution using
 * 2023/01/06
 *
 *
 * <Memo>
 *     Arrays.copyOfRange(arr, startIdx, endIdx) : 배열 특정 영역 복사
 * </Memo>
 */
class Solution_13 {

    int result = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, numbers.length, target, 0);

        return result;
    }

    public void dfs(int[] numbers, int size, int target, int sum){
        if(size==0){
            if(target == sum){//탈출 조건 : total과 sum이 일치할 때
                result++;
            }return;
        }
        if(size>1) {
            dfs(Arrays.copyOfRange(numbers, 1, size), size-1, target,sum+numbers[0]);// +부터 더하기
            dfs(Arrays.copyOfRange(numbers, 1, size), size-1, target,sum-numbers[0]);// -으로 더하기
        }else{
            dfs(null, size-1, target,sum+numbers[0]);// +부터 더하기
            dfs(null, size-1, target,sum-numbers[0]);// +부터 더하기
        }
    }

    public static void main(String[] args) {
        Solution_13 soluttion13 = new Solution_13();
        int[] numbers={4,1,2,1} ;
        int target = 4;
        System.out.println(soluttion13.solution(numbers, target));
    }
}

package 김솔민.레벨1;

import java.util.HashSet;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * Solution using
 * 2023/01/29
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_31_폰켓몬 {
    public int solution(int[] nums) {
        // 1. numsLen = nums의 길이/2를 저장
        int numsLen = nums.length/2;

        // 2. 모든 nums를 set 자료구조에 저장
        Set<Integer> numsSet = new HashSet<>();

        for(int num : nums){
            numsSet.add(num);
        }

        // 3. return min(numsLen, set.size())

        return Math.min(numsLen, numsSet.size());
    }

    public static void main(String[] args) {
        Solution_31_폰켓몬 solution31_폰켓몬 = new Solution_31_폰켓몬();
        int[] nums = {3,1,2,3};
        System.out.println(solution31_폰켓몬.solution(nums));
    }
}

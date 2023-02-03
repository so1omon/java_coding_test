package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 * Solution using
 * 2023/02/03
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_11_점프와_순간이동 {
    public int solution(int n) {
        int ans = 1;

        // 전략 : n이 1일 때 -> 반복문 끝
        while(n!=1){
            // n이 짝수일 때 -> 2로 나누고 다시 돌림
            if(n%2==0){
                n/=2;
                // n이 홀수일 때 -> ans++하고 1빼고 다시 돌림
            }else{
                ans++;
                n--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5000;
        Solution_11_점프와_순간이동 solution11_점프와_순간이동 = new Solution_11_점프와_순간이동();

        System.out.println(solution11_점프와_순간이동.solution(n));
    }
}

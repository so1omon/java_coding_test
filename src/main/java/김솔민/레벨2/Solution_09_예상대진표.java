package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 * Solution using
 * 2023/02/02
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_09_예상대진표 {
    public int solution(int n, int a, int b){
        int answer = 0;

        while(a!=b){
            a++;
            b++;
            a/=2;
            b/=2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_09_예상대진표 solution09_예상대진표 = new Solution_09_예상대진표();
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution09_예상대진표.solution(n, a, b));
    }
}

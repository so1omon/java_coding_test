package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * Solution using long type conversion
 * 2023/02/05
 *
 *
 * <Memo>
 *   index type은 항상 int(Integer)로만 받을 수 있음
 * </Memo>
 */
class Solution_15_n제곱_배열자르기 {
    public int[] solution(int n, long left, long right) {

        // long -> integer 변환 (10^5 이하이기 때문에 가능)
        int boundary = (int)(right-left);
        int[] answer = new int[boundary+1];

        for(int i=0;i<boundary+1;i++){
            // left ~ right까지 indexing
            long target = (long)i+left;
            long col = target/(long)n;
            long row = target%(long)n;
            answer[i] = Math.max((int)col, (int)row)+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n=4;
        int left=7;
        int right=14;
        System.out.println(new Solution_15_n제곱_배열자르기().solution(n,left,right));
    }
}

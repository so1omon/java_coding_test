package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938#
 * Solution using
 * 2023/03/03
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_02_최고의_집합 {
    public int[] solution(int n, int s) {
        int[] answer;


        if(s<n){
            return new int[]{-1};
        }


        answer = new int[n];

        int common = (int)Math.ceil((double)s/(double)n);

        for(int i=0;i<n;i++){
            answer[i] = common;
        }

        for(int i=0;i<(common*n)-s;i++){
            answer[i]--;
        }



        return answer;
    }
}

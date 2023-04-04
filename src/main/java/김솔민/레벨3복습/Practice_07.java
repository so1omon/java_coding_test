package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */

class Practice_07 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;

        for(int i=1;i<len;i++){
            for(int j=0;j<=i;j++){
                int temp = 0;
                if(j!=i){
                    temp = triangle[i-1][j];
                }
                if(j!=0){
                    temp = Math.max(temp, triangle[i-1][j-1]);
                }
                triangle[i][j]+=temp;
            }
        }

        for(int i=0;i<len;i++){
            answer = Math.max(triangle[len-1][i], answer);
        }

        return answer;
    }
}
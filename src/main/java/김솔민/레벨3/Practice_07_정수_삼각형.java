package 김솔민.레벨3;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * Solution using
 * 2023/03/10
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_07_정수_삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                int max = 0;
                if(i-1>=0 && j!=i){
                    max = triangle[i-1][j];
                }
                if(i-1>=0 && j-1>=0){
                    max = triangle[i-1][j-1]>max?triangle[i-1][j-1]:max;
                }
                triangle[i][j] = triangle[i][j] + max;
            }
        }

        return Arrays.stream(triangle[n-1]).max().getAsInt();
    }
}

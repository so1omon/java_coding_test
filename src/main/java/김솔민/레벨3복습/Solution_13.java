package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 * 2023/04/10
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.HashMap;
import java.util.Map;

class Solution_13 {
    public int solution(int[][] total_board, int[][] skill) {
        int answer = 0;

        int[][] board = new int[total_board.length][total_board[0].length];
        // skill : (1/2 : 공격/회복), r1, c1, r2, c2, 값
        for(int i=0;i<skill.length;i++){
            skill[i][0] = skill[i][0]==1?-1:1;
            int r1 =  skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int value = skill[i][0]*skill[i][5];

            board[r1][c1]+=value;

            if(c2!=board[0].length-1){
                board[r1][c2+1]-=value;
            }
            if(c2!=board[0].length-1 && r2!=board.length-1){
                board[r2+1][c2+1]+=value;
            }
            if(r2!=board.length-1){
                board[r2+1][c1]-=value;
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=1;j<board[0].length;j++){
                board[i][j] += board[i][j-1];
            }
        }

        for(int j=0;j<board[0].length;j++){
            for(int i=1;i<board.length;i++){
                board[i][j] += board[i-1][j];
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(total_board[i][j] + board[i][j]>=1){
                    answer++;
                }
            }
        }

        return answer;
    }
}
package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92344
 * Solution using
 * 2023/03/17
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_13_파괴되지않은건물_나중에다시풀기 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] newBoard = new int[board.length][board[0].length];

        for (int[] s : skill) {
            if (s[0] == 1) {
                s[5] *= -1;
            }

            newBoard[s[1]][s[2]] += s[5];
            // s[3]이 인덱스 끝 아니면 -s[5] 추가
            if (s[3] != board.length - 1) {
                newBoard[s[3] + 1][s[2]] -= s[5];
            }
            // s[4]이 인덱스 끝 아니면
            if (s[4] != board[0].length - 1) {
                newBoard[s[1]][s[4] + 1] -= s[5];
            }
            if (s[3] != board.length - 1 && s[4] != board[0].length - 1) {
                newBoard[s[3] + 1][s[4] + 1] += s[5];
            }
        }

        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 1; j < newBoard[0].length; j++) {
                newBoard[i][j] += newBoard[i][j - 1];
            }
        }

        for (int j = 0; j < newBoard[0].length; j++) {
            for (int i = 1; i < newBoard.length; i++) {
                newBoard[i][j] += newBoard[i - 1][j];
            }
        }

        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[0].length; j++) {
                if (board[i][j] + newBoard[i][j] >= 1) {
                    answer++;
                }
            }
        }

        return answer;

    }
}

package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67259
 * Solution using
 * 2023/03/09
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;
class Solution_08_경주로_건설_나중에다시풀기 {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        // 전략 : 다음 방향으로 진행했을 때 최댓값보다 작은 값이 이미 세팅되었다면 update를 하지않음
        Queue<int[]> queue = new LinkedList<>();

        int[][][] cost = new int[n][n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        // [0],[1] : 현재 인덱스, [2]: 현재 cost, [3] : 나아갈 진행방향
        // 진행방향 - 0:상, 1:하, 2:좌, 3:우

        // 맨 처음에는 하, 우 방향으로만 진행 가능
        queue.add(new int[]{0,0,0,1});
        queue.add(new int[]{0,0,0,3});

        while(!queue.isEmpty()){
            int[] target = queue.poll();

            for(int i=0;i<4;i++){
                int ny = target[0] + dy[i], nx = target[1] + dx[i];
                int curCost = target[2] + (target[3]==i?100:600);

                // 업데이트 스킵 조건 :
                // 인덱스 범위 벗어나거나, board가 막혀있거나, 원래 cost가 현재 cost 이하일 때
                if(ny<0 || nx < 0 || ny>n-1 || nx> n-1 || board[ny][nx]==1 ||
                    cost[ny][nx][i]<=curCost) continue;
                cost[ny][nx][i]=curCost;
                queue.add(new int[]{ny, nx, curCost, i});
            }
        }

        for(int c : cost[n-1][n-1]){
            if(c < answer){
                answer = c;
            }
        }


        return answer;
    }
}

package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67259
 * Solution using
 * 2023/04/05
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;
class Solution_08 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int N = board.length;
        int INF = Integer.MAX_VALUE;
        int answer = INF;
        int[][][] cost = new int[N][N][4];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<4;k++){
                    cost[i][j][k] = INF;
                }
            }
        }
        cost[0][0] = new int[]{0,0,0,0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,1});
        q.add(new int[]{0,0,0,3});

        while(!q.isEmpty()){

            List<int[]> list = new ArrayList<>();
            while(!q.isEmpty()){
                list.add(q.poll());
            }
            for(int[] idx : list){

                for(int i=0;i<4;i++){
                    int[] newIdx = new int[]{idx[0]+dy[i], idx[1]+dx[i]};
                    int temp = idx[3]!=i?idx[2]+600:idx[2]+100;
                    if(newIdx[0]<0 || newIdx[1]<0 || newIdx[0]>=N || newIdx[1]>=N ||
                        cost[newIdx[0]][newIdx[1]][i]<=temp ||
                        board[newIdx[0]][newIdx[1]]==1){
                        continue;
                    }
                    cost[newIdx[0]][newIdx[1]][i]=temp;
                    q.add(new int[]{newIdx[0], newIdx[1], temp, i});
                }
            }
        }

        for(int i=0;i<4;i++){
            answer = Math.min(cost[N-1][N-1][i], answer);
        }

        return answer;
    }
}
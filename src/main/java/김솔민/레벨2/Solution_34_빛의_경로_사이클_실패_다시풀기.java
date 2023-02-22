package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86052
 * Solution using
 * 2023/02/22
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_34_빛의_경로_사이클_실패_다시풀기 {
    static List<Integer> answerList = new ArrayList<>();
    static Light[][] lightGrid;
    static int row;
    static int col;
    static int[][] vectors = new int[][]{
        {-1,0,0},{0,-1,1},{1,0,2},{0,1,3}
    };

    public int[] solution(String[] grid) {
        // 1. Light class를 2차원 배열로 만들기

        row = grid.length;
        col = grid[0].length();

        lightGrid = new Light[row][col];
        // 2. 2차원 배열을 모두 돌면서 recursive 수행
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                lightGrid[i][j] = new Light(grid[i].charAt(j));
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int[] idx = {i, j};
                for(int k=0;k<4;k++){
                    dfs(idx,  vectors[k]);
                }
            }
        }

        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    class Light{
        boolean[] visited = new boolean[]{false, false, false, false};
        int direction; // S:0, L:1, R:2

        public Light(char direction){
            switch(direction){
                case 'S':
                    this.direction=0;
                    break;
                case 'L':
                    this.direction=1;
                    break;
                case 'R':
                    this.direction=2;
                    break;
                default:
                    break;
            }
        }
    }

    // idx = 시작 인덱스지점, cnt = 사이클 길이, vector: 가는방향 [ x, y, (상하좌우) ]
    void dfs(int[] idx, int[] vector){
        Light target = lightGrid[idx[0]][idx[1]];
        // 종료 조건 : 해당 벡터로 이미 방문했을 때
        int cnt = 0;
        while(true){
            if(target.visited[vector[2]]){
                if(cnt!=0){
                    answerList.add(cnt);
                }
                return;
            }
            target.visited[vector[2]]=true;
            idx[0] = (idx[0] + vector[0]+row)%row;
            idx[1] = (idx[1] + vector[1] + col) % col;
            target = lightGrid[idx[0]][idx[1]];

            switch(target.direction){
                case 1: //L
                    vector = vectors[(vector[2]+1)%4];
                    break;
                case 2: //R
                    vector = vectors[(vector[2]+3)%4];
                    break;
                default:
                    break;
            }
            cnt++;
        }

    }

    public static void main(String[] args) {
        String[] grid = {"SL","LR"};
        System.out.println(new Solution_34_빛의_경로_사이클_실패_다시풀기().solution(grid));
    }
}

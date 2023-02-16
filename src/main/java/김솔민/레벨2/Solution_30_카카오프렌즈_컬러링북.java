package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1829
 * Solution using recursive
 * 2023/02/16
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_30_카카오프렌즈_컬러링북 {
    boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 1. 칠한 영역 찾기, 전에 방문하지 않았고 색칠이 되어있는 부분(not 0)여야 함
                if(visited[i][j]==false && picture[i][j]!=0){
                    numberOfArea++;
                    // 2. 칠한 영역에 대해 recursive로 칠한 횟수를 받아오고 visited처리

                    int sizeOfOneArea =
                        recursivePaint(picture, i, j, 0, picture[i][j]);
                    if(sizeOfOneArea>maxSizeOfOneArea){
                        maxSizeOfOneArea = sizeOfOneArea;
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public int recursivePaint(
        int[][] picture, int row, int col, int total, int color){

        // 탈출조건
        if(visited[row][col] || picture[row][col]!=color){
            return total;
        }else{
            visited[row][col]=true;
            total++;
        }

        // 4방향 전부 확인해서 좌표계 벗어나면 아무것도 안하고 그렇지 않으면 방문처리
        if(row!=picture.length-1){
            total=recursivePaint(picture, row+1, col, total, color);
        }
        if(row!=0){
            total=recursivePaint(picture, row-1, col, total, color);
        }
        if(col!=picture[0].length-1){
            total=recursivePaint(picture, row, col+1, total, color);
        }
        if(col!=0){
            total=recursivePaint(picture, row, col-1, total, color);
        }

        return total;
    }

    public static void main(String[] args) {

    }
}

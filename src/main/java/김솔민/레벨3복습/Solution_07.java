package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72413
 * Solution using
 * 2023/04/05
 *
 *
 * <Memo>
 * </Memo>
 */

class Solution_07 {
    public int solution(int n, int s, int a, int b, int[][] fares) {

        int INF = 20000001;

        int answer = INF;

        int[][] dist = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                // 같은 노드 -> 같은 노드
                if(i==j){
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = INF;
                }
            }
        }

        for(int[] fare : fares){
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }


        // 워샬 플로이드
        for(int j=1;j<=n;j++){
            for(int i=1;i<=n;i++){
                for(int k=1;k<=n;k++){
                    int target = dist[i][j] + dist[j][k];
                    if(dist[i][k] > target){
                        dist[i][k] = target;
                        dist[k][i] = target;
                    }
                }
            }
        }



        for(int i=1;i<=n;i++){
            int target = dist[i][a] + dist[i][b] + dist[i][s];
            if(answer > target){
                answer = target;
            }
        }


        return answer;
    }
}
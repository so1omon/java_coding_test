package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_01 {
    static boolean[][] win;
    public int solution(int n, int[][] results) {
        int answer = 0;
        win = new boolean[n+1][n+1];
        for(int[] result : results){
            win[result[0]][result[1]] = true;
        }

        for(int i=1;i<=n;i++){
            dfs(i, i, new boolean[n+1], n);
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(win[i][j]){
                    win[j][i] = true;
                }
            }
        }


        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=1;j<=n;j++){
                System.out.print(win[i][j] + " ");
                if(win[i][j]) cnt++;
            }
            System.out.println();
            if(cnt==n-1) answer++;

        }

        return answer;
    }

    void dfs(int origin, int target, boolean[] visited, int n){
        for(int i=1;i<=n;i++){
            if(win[target][i] && !visited[i]){
                visited[i] = true;
                win[origin][i] = true;
                dfs(origin, i, visited, n);
            }
        }

    }
}

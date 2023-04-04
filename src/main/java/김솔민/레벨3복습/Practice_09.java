package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Practice_09 {
    static int cnt = 0;
    static int N;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        N=n;
        visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers, i);
                cnt++;
            }
        }
        return cnt;
    }
    void dfs(int[][] map, int origin){
        if(visited[origin]){
            return;
        }
        visited[origin] = true;
        for(int i=0;i<N;i++){
            if(map[origin][i]==1 && !visited[i]){
                dfs(map, i);
            }
        }
    }
}
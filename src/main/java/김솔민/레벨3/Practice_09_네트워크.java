package 김솔민.레벨3;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * Solution using
 * 2023/03/10
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_09_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                bfs(computers, visited, i, n);
                answer++;
            }
        }

        return answer;
    }

    void bfs(int[][] computers, boolean[] visited, int i, int n){
        if(visited[i]){
            return;
        }
        visited[i] = true;

        for(int j=0;j<n;j++){
            if(i==j) continue;
            if(computers[i][j]==1){
                bfs(computers, visited, j, n);
            }
        }
    }
}

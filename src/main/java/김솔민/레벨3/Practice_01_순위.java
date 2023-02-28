package 김솔민.레벨3;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * Solution using
 * 2023/02/28
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_01_순위 {
    boolean[][] map;
    Map<Integer, Integer> originMap = new HashMap<>();
    Map<Integer, Integer> reversedMap = new HashMap<>();

    public int solution(int n, int[][] results) {
        int answer = 0;

        // 전략 : 승패표 Map 만들기
        // key 하나씩 돌면서 bfs로 갈 수 있는 경로 모두 탐색
        // 마지막으로 Map을 뒤집어 까기
        // 두개의 Map 배열을 합쳤을 때 길이가 4인 원소들을 발견하면 answer++

        map = new boolean[n+1][n+1];

        for(int[] result : results){
            map[result[0]][result[1]] = true;
        }

        for(int i=1;i<=n;i++){
            bfs(i, i, new boolean[n+1], n);
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(map[i][j]){
                    // 1. originMap
                    originMap.put(i, originMap.getOrDefault(i,0)+1);
                    // 2. reversedMap
                    reversedMap.put(j, reversedMap.getOrDefault(j,0)+1);
                }
            }
        }

        for(int i=1;i<n+1;i++){
            if( originMap.getOrDefault(i,0) +
                reversedMap.getOrDefault(i,0) == n-1){
                answer++;
            }
        }

        return answer;
    }


    void bfs(int origin, int target, boolean[] visited, int n){
        for(int i=1;i<=n;i++){
            if(map[target][i] && !visited[i]){
                visited[i] = true;
                map[origin][i] = true;
                bfs(origin, i, visited, n);
            }
        }
    }

}

package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12978?language=java
 * Solution using Dijkstra
 * 2023/02/13
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_27_배달 {
    public int solution(int N, int[][] road, int K) {
        int answer=0;
        int MAX_NODE = N+1;
        int MAX_VALUE = 500001;

        int[][] graph = new int[MAX_NODE][MAX_NODE];

        //1. 그래프 초기화
        for(int i=0;i<MAX_NODE;i++){
            for(int j=0;j<MAX_NODE;j++){
                if(i==j){
                    graph[i][j] = 0;
                }else{
                    graph[i][j]=MAX_VALUE;
                }
            }
        }

        //2. 간선정보 초기화
        //2-1. 간선에 중복된 길이 있으면 더 가중치가 작은 값으로 덮어씌우기
        for(int[] r : road){
            graph[r[0]][r[1]] = graph[r[1]][r[0]] = Math.min(graph[r[0]][r[1]], r[2]);
        }

        //3. 방문 기록
        boolean[] visited = new boolean[MAX_NODE];

        //4. 거리기록 초기화
        int[] dist = new int[MAX_NODE];
        for(int i=0;i<MAX_NODE;i++){
            dist[i] = MAX_VALUE;
        }

        dist[1] = 0;

        //5. dijkstra
        while(true){
            int min_idx = -1;
            int min_value = MAX_VALUE;
            if(!visited[1]){
                min_idx=1;
                min_value = dist[min_idx];
            }else{
                for(int i=1;i<MAX_NODE;i++){
                    if(!visited[i] && dist[i] < min_value){
                        min_idx =i;
                        min_value = dist[i];
                    }
                }
            }
            if(min_idx==-1){
                break;
            }else{
                visited[min_idx]=true;
            }

            for(int i=1;i<MAX_NODE;i++){
                dist[i] = Math.min(dist[i], graph[min_idx][i] + min_value);
            }
        }

        for(int d : dist){
            if(d<=K){
                answer++;
            }
        }

        return answer;
    }

}

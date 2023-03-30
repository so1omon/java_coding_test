package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * 2023/03/30
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;

class Solution_29_섬_연결하기_나중에다시풀기 {
    public int solution(int n, int[][] costs) {
        int INF = Integer.MAX_VALUE;
        int min = INF;

        int origin = costs[0][0];
        Map<Integer, List<int[]>> map = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        for(int[] cost : costs){
            if(!map.containsKey(cost[0])){
                map.put(cost[0], new ArrayList<>());
            }
            if(!map.containsKey(cost[1])){
                map.put(cost[1], new ArrayList<>());
            }
        }

        for(int[] cost : costs){
            map.get(cost[0]).add(new int[]{cost[1], cost[2]});
            map.get(cost[1]).add(new int[]{cost[0], cost[2]});
        }
        for(int key : map.keySet()){
            visited.put(key, false);
        }

        int sum = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((arr1, arr2)->{
            return arr1[1]-arr2[1];
        });

        q.add(new int[]{origin, 0});

        while(!q.isEmpty()){
            // q에 맨 위에꺼 가져오기
            int[] target = q.poll();
            if(visited.get(target[0])){
                continue;
            }
            visited.put(target[0], true);

            sum+=target[1];
            // 갈 수 있는 경로를 map에서 찾아오고, 이 중 visited되지 않은 것들만 q에 넣기
            for(int[] go : map.get(target[0])){
                if(!visited.get(go[0])){
                    q.add(go);
                }
            }

        }

        return sum;
    }
}

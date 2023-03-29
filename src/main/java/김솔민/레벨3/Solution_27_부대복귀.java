package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/132266
 * 2023/03/29
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;
class Solution_27_부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] road : roads){
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }

        Queue<Integer> q = new LinkedList();
        q.add(destination);

        boolean[] visited = new boolean[n+1];
        int[] des = new int[n+1];
        for(int i=0;i<n+1;i++){
            des[i] = -1;
        }

        int dest = 0;
        int temp = -1;
        des[destination] = 0;
        visited[destination] = true;

        while(!q.isEmpty()){
            dest++;
            List<Integer> tempList = new ArrayList<>();
            while(!q.isEmpty()){
                tempList.add(q.poll());
            }
            for(int target : tempList){
                for(int d : map.get(target)){
                    if(!visited[d]){
                        q.add(d);
                        visited[d] = true;
                        des[d]= dest;
                    }
                }
            }

        }

        for(int i=0;i<sources.length;i++){
            answer[i] = des[sources[i]];
        }

        return answer;
    }
}

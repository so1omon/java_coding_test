package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 * 2023/03/30
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;

class Solution_28_가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] e : edge){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }


        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            while(!q.isEmpty()){
                temp.add(q.poll());
            }
            for(int i : temp){
                for(int d : map.get(i)){
                    if(!visited[d]){
                        visited[d] = true;
                        q.add(d);
                    }
                }

            }

            if(q.isEmpty()){
                answer = temp.size();
                break;
            }

        }



        return answer;
    }
}

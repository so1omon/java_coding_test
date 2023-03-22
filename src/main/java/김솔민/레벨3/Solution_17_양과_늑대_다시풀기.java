package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92343
 * Solution using
 * 2023/03/21
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Solution_17_양과_늑대_다시풀기 {
    static int max_sheep;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        max_sheep = 0;
        // 각 노드를 visited, type으로 구분
        // 양 type(0)을 우선으로 dfs 돌리기
        // 만약 저장한 늑대의 수가 양과 같아진다면 더이상 탐색 안하고 이전으로 돌리기
        Node[] nodes = new Node[info.length+1];
        nodes[0] = new Node(info[0]);
        for(int i=0;i<info.length;i++){
            nodes[i] = new Node(info[i]);
        }



        for(int[] edge: edges){
            nodes[edge[1]].parent = nodes[edge[0]];
            nodes[edge[0]].child.add(nodes[edge[1]]);
        }

        dfs(nodes[0], 0, 0, new ArrayList<>());
        return max_sheep;
    }

    class Node{
        boolean visited = false;
        int type;
        Node parent;
        List<Node> child = new ArrayList<>();

        Node(int type){
            this.type = type;
        }
    }

    void dfs(Node origin, int sheep, int wolf, List<Node> canGo){
        if(origin.type==0){
            sheep++;
        }else{
            wolf++;
        }

        if(sheep<=wolf){
            return;
        }else{
            max_sheep = Math.max(sheep, max_sheep);
        }

        for(int i=0;i<origin.child.size();i++){
            canGo.add(origin.child.get(i));
        }

        for(Node t : canGo){
            List<Node> copied = new ArrayList<>(canGo);
            copied.remove(t);
            dfs(t, sheep, wolf, copied);
        }
    }

}

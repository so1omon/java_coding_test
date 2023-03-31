package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/76503
 * 2023/03/31
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;

class Solution_31_모두_0으로_만들기 {
    public long solution(int[] total_a, int[][] edges) {
        long answer = 0L;
        long[] a = new long[total_a.length];
        for(int i=0;i<total_a.length;i++){
            a[i] = (long)total_a[i];
        }
        // 편의상 0번 지점을 루트 노드로 정하고, Node트리 구성
        // Node 리스트를 별도로 저장하고, 맨 처음 시작 시 선형적으로 탐색하여 리프노드 탐색
        Node[] nodearr = new Node[a.length];
        Node root = new Node(a[0]);
        nodearr[0] = root;



        for(int[] edge : edges){
            Node node1 = nodearr[edge[0]];
            if(node1==null){
                node1 = new Node(a[edge[0]]);
                nodearr[edge[0]] = node1;
            }
            Node node2 = nodearr[edge[1]];
            if(node2==null){
                node2 = new Node(a[edge[1]]);
                nodearr[edge[1]] = node2;
            }
            node1.nodes.add(node2);
            node2.nodes.add(node1);
        }



        Queue<Node> q = new LinkedList<>();
        for(int i=1;i<a.length;i++){
            if(nodearr[i].nodes.size()==1){
                q.add(nodearr[i]);
            }
        }

        while(!q.isEmpty()){
            Node target = q.poll();
            Node parent = target.nodes.iterator().next();

            answer+=Math.abs(target.value);
            parent.value+=target.value;
            parent.nodes.remove(target);
            if(parent!=root && parent.nodes.size()==1){
                q.add(parent);
            }
        }

        // 리프 노드부터 큐에 모두 집어넣고, 연결된 지점으로 값을 올려준 후 올려준 노드의 리프여부 탐색
        // 리프 노드라면 큐에 집어넣기
        // 큐가 전부 비어 있다면 루트노드를 탐색해 value를 검증하고 0이면 counter 값 리턴,
        // 0이 아니면 -1 리턴
        if(root.value!=0){
            return -1;
        }


        return answer;
    }

    class Node{
        long value;
        Set<Node> nodes = new HashSet<>();
        Node(long value){
            this.value = value;
        }
    }
}

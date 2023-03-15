package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42892
 * Solution using
 * 2023/03/14
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;
class Solution_11_길찾기_게임 {
    List<Integer> preOrderList = new ArrayList<>();
    List<Integer> postOrderList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {

        List<int[]> list = new ArrayList<>();

        for(int i=0;i<nodeinfo.length;i++){
            list.add(new int[]{nodeinfo[i][0], i, nodeinfo[i][1]});
        }

        Collections.sort(list, (arr1, arr2)->{
            return arr2[2]-arr1[2];
        });

        Node start = new Node(list.get(0));

        for(int i=1;i<list.size();i++){
            insert(start, new Node(list.get(i)));
        }


        preOrder(start);
        postOrder(start);


        int[][] answer = new int[2][preOrderList.size()];

        for(int i=0;i<answer[0].length;i++){
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }

        return answer;
    }

    class Node{
        int x;
        int idx;

        Node xSub = null;
        Node ySub = null;

        Node(int x, int idx){
            this.x = x;
            this.idx = idx+1;
        }

        Node(int[] args){
            this.x = args[0];
            this.idx = args[1]+1;
        }

    }

    void insert(Node origin, Node target){
        // 왼쪽 자식으로 보내기
        if (origin.x>target.x){
            if(origin.xSub==null){
                origin.xSub = target;
                return;
            }else{
                insert(origin.xSub, target);
            }
        }
        // 오른쪽 자식으로 보내기
        else{
            if(origin.ySub==null){
                origin.ySub = target;
                return;
            }else{
                insert(origin.ySub, target);
            }
        }
    }

    void preOrder(Node start){
        // 찍고 자식 2개
        preOrderList.add(start.idx);

        if(start.xSub!=null){
            preOrder(start.xSub);
        }

        if(start.ySub!=null){
            preOrder(start.ySub);
        }
    }

    void postOrder(Node start){

        if(start.xSub!=null){
            postOrder(start.xSub);
        }

        if(start.ySub!=null){
            postOrder(start.ySub);
        }

        // 자식 2개하고 찍기
        postOrderList.add(start.idx);
    }
}

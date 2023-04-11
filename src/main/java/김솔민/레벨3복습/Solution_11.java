package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42892
 * 2023/04/10
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_11 {
    List<Integer> preList = new ArrayList<>();
    List<Integer> postList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {

        int[][] answer = new int[2][nodeinfo.length];
        List<Node> list = new ArrayList<>();
        for(int i=0;i<nodeinfo.length;i++){
            Node node = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
            list.add(node);
        }

        list.sort((a,b)->{
            if(a.depth==b.depth){
                return a.x-b.x;
            }
            return b.depth-a.depth;
        });

        Node root = list.get(0);


        for(int i=1;i<list.size();i++){

            search(root, list.get(i));
        }

        preOrder(root);
        postOrder(root);

        for(int i=0;i<nodeinfo.length;i++){
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }


        return answer;
    }

    void preOrder(Node root){
        preList.add(root.idx);

        if(root.left!=null){
            preOrder(root.left);
        }

        if(root.right!=null){
            preOrder(root.right);
        }
    }

    void postOrder(Node root){
        if(root.left!=null){
            postOrder(root.left);
        }

        if(root.right!=null){
            postOrder(root.right);
        }

        postList.add(root.idx);
    }

    void search(Node root, Node target){
        if(root.x < target.x){
            if(root.right==null){
                root.right = target;
            }else{
                search(root.right, target);
            }
        }else{
            if(root.left==null){
                root.left = target;
            }else{
                search(root.left, target);
            }
        }
    }

    class Node{
        int idx;
        int depth;
        int x;

        Node left = null;
        Node right = null;

        Node(int idx, int x, int depth){
            this.idx = idx;
            this.depth = depth;
            this.x = x;
        }

    }
}
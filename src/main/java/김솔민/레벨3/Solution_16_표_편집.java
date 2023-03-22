package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 * Solution using
 * 2023/03/21
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;
class Solution_16_표_편집 {
    public String solution(int n, int k, String[] cmd) {
        // 전략 : array와 int 두 개로 관리
        // 삭제 시 stack에 내 앞에 있었던 요소를 기준으로 저장
        char[] answer = new char[n];
        for(int i=0;i<answer.length;i++){
            answer[i] = 'O';
        }

        Stack<Node> stack = new Stack<>();

        Node root = new Node(0, null);
        Node ptr = root;

        for(int i=1;i<n;i++){
            ptr.post = new Node(i, ptr);
            ptr = ptr.post;
        }

        ptr = root;
        for(int i=0;i<k;i++){
            ptr = ptr.post;
        }

        for(String chcmd : cmd){
            switch(chcmd.charAt(0)){
                case 'U':
                    for(int i=0;i<Integer.parseInt(chcmd.substring(2));i++){
                        ptr = ptr.prev;
                    }

                    break;
                case 'D':
                    for(int i=0;i<Integer.parseInt(chcmd.substring(2));i++){
                        ptr = ptr.post;
                    }
                    break;
                case 'C':
                    if(ptr.prev!=null){
                        ptr.prev.post = ptr.post;
                    }
                    if(ptr.post!=null){
                        ptr.post.prev = ptr.prev;
                    }

                    stack.push(ptr);

                    if(ptr.post!=null){
                        ptr = ptr.post;
                    }else{
                        ptr = ptr.prev;
                    }

                    break;
                case 'Z':
                    Node target = stack.pop();

                    if(target.prev==null){
                        target.post.prev = target;
                    }else if(target.post==null){
                        target.prev.post = target;
                    }else{
                        target.post.prev = target;
                        target.prev.post = target;
                    }

                    break;
            }


        }

        while(!stack.isEmpty()){

            answer[stack.pop().value] = 'X';
        }


        return String.valueOf(answer);
    }

    class Node{
        int value;
        Node prev;
        Node post;

        Node(int value, Node prev){
            this.value = value;
            this.prev = prev;
        }
    }

}

package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77486
 * 2023/04/10
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Solution_12 {
    public int[] solution(String[] enroll, // 각 판매원 이름
                          String[] referral, // 각 판매원의 부모
                          String[] seller, // 판매 집계데이터
                          int[] amount) {

        int[] answer = new int[enroll.length];
        Node center = new Node(null);

        Map<String, Node> map = new HashMap<>();

        for(int i=0;i<enroll.length;i++){
            if(referral[i].equals("-")){
                map.put(enroll[i], new Node(null));
            }else{
                map.put(enroll[i], new Node(map.get(referral[i])));
            }
        }

        for(int i=0;i<seller.length;i++){
            upward(map.get(seller[i]), amount[i]* 100);
        }


        for(int i=0;i<enroll.length;i++){
            answer[i] = map.get(enroll[i]).money;
        }

        return answer;
    }

    void upward(Node target, int amount){
        int dist = amount/10;
        target.money += amount - dist;

        if(dist!=0 && target.parent!=null){
            upward(target.parent, dist);
        }
    }


    class Node{
        Node parent=null;
        int money = 0;

        Node(Node parent){
            this.parent = parent;
        }

    }
}
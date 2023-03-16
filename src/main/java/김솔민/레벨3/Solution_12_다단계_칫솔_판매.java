package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/77486
 * Solution using
 * 2023/03/14
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
class Solution_12_다단계_칫솔_판매 {
    static Map<String, Node> map = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // 노드 만들기
        Node center = new Node("center", null);
        map.put("center", center);


        for(int i=0;i<enroll.length;i++){
            if(referral[i].equals("-")){
                Node newNode = new Node(enroll[i], center);
                center.childs.add(newNode);
                map.put(enroll[i], newNode);
            }else{
                Node target = map.get(referral[i]);
                Node newNode = new Node(enroll[i], target);
                target.childs.add(newNode);
                map.put(enroll[i], newNode);
            }
        }

        // 판매기록 만들기
        for(int i=0;i<seller.length;i++){
            Node target = map.get(seller[i]);
            target.addAmount(amount[i]*100);
        }

        int[] answer = new int[enroll.length];

        for(int i=0;i<enroll.length;i++){
            Node target = map.get(enroll[i]);
            answer[i] = target.amount;
        }

        return answer;
    }

    class Node{
        String name;
        int amount = 0;
        List<Node> childs = new ArrayList<>();
        Node parent;

        Node(String name, Node parent){
            this.name = name;
            this.parent = parent;
        }

        void addAmount(int amount){
            int rest = amount/10;
            if(rest == 0 || this.parent == null){
                this.amount+=amount;
            }else{
                this.amount+=amount-rest;

                this.parent.addAmount(rest);
            }
        }
    }
}

package 김솔민.레벨3;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * Solution using
 * 2023/03/10
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_08_이중_우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {};

        // 전략 : Max Priority Queue, Min Priority Queue 두 개를 관리
        // 삽입 시 두 큐에 모두 삽입
        // 최댓값 삭제 시 Max에서 삭제, 최솟값 삭제 시 Min에서 삭제
        // 마지막으로 각각의 우선순위 Queue의 교집합을 구하기
        PriorityQueue<Integer> maxQ =
            new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        boolean state = false;

        for(String operation : operations){
            String[] split = operation.split(" ");
            int target = Integer.parseInt(split[1]);

            if(split[0].equals("I")){ // 삽입
                if(state){
                    Set<Integer> set1 = new HashSet<>();
                    Set<Integer> set2 = new HashSet<>();

                    while(!maxQ.isEmpty()){
                        set1.add(maxQ.poll());
                    }

                    while(!minQ.isEmpty()){
                        set2.add(minQ.poll());
                    }

                    set1.retainAll(set2);
                    for(Integer s : set1){
                        maxQ.add(s);
                        minQ.add(s);
                    }
                    state = false;
                }
                maxQ.add(target);
                minQ.add(target);

            }else if(split[0].equals("D")){ // 삭제
                if(target==1){
                    if(!maxQ.isEmpty()) maxQ.poll();
                }else{
                    if(!minQ.isEmpty()) minQ.poll();
                }
                state = true;
            }
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        while(!maxQ.isEmpty()){
            set1.add(maxQ.poll());
        }

        while(!minQ.isEmpty()){
            set2.add(minQ.poll());
        }

        set1.retainAll(set2);

        if(set1.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{
                Collections.max(set1), Collections.min(set1)
            };
        }
    }
}

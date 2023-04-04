package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;
class Practice_08 {
    static PriorityQueue<Integer> minQ = new PriorityQueue<>((p,q) -> p-q);
    static PriorityQueue<Integer> maxQ = new PriorityQueue<>((p,q) -> q-p);
    static Set<Integer> minSet = new HashSet<>();
    static Set<Integer> maxSet = new HashSet<>();

    public int[] solution(String[] operations) {
        int[] answer = {};

        for(String op : operations){
            String[] split = op.split(" ");
            String cmd = split[0];
            int value = Integer.parseInt(split[1]);
            if(cmd.equals("I")){
                retain(false);
                minQ.add(value);
                maxQ.add(value);
            }else{
                if(value<0 && !minQ.isEmpty()){
                    minQ.poll();
                }else if(!maxQ.isEmpty()){
                    maxQ.poll();
                }
            }

        }
        retain(true);

        if(minSet.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{
                Collections.max(minSet),
                Collections.min(minSet)
            };
        }
    }

    void retain(boolean flag){
        while(!minQ.isEmpty()){
            minSet.add(minQ.poll());
        }
        while(!maxQ.isEmpty()){
            maxSet.add(maxQ.poll());
        }

        minSet.retainAll(maxSet);
        for(int i : minSet){
            minQ.add(i);
            maxQ.add(i);
        }
        if(!flag){
            minSet.clear();
            maxSet.clear();
        }
    }
}
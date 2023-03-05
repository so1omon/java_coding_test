package 김솔민.레벨1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 2023/01/26
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_33_프린터 {
    public int solution(int[] priorities, int location) {
        int turn = 1;
        Queue<Job> printer = new LinkedList<>();
        List<Integer> prioritiesList = new ArrayList<>();

        for(int i=0;i<priorities.length;i++){
            printer.add(new Job(i, priorities[i]));
            prioritiesList.add(priorities[i]);
        }

        while(true){
            int maxPriority = Collections.max(prioritiesList);

            Job target = printer.peek();

            if(target.priority == maxPriority ){
                if(target.location == location){
                    break;
                }else{
                    printer.remove();
                    prioritiesList.remove(
                        prioritiesList.indexOf(target.priority));

                    turn++;
                }
            }else{
                printer.add(printer.poll());
            }
        }
        return turn;
    }


    class Job{
        int location;
        int priority;

        public Job(int location, int priority){
            this.location = location;
            this.priority = priority;
        }
    }
}

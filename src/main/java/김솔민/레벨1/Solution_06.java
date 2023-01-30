package 김솔민.레벨1;

import java.util.*;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42587
 *  Solution using Queue and defining class
 *  2022/12/30
 *
 *  <Memo>
 *      ArrayInitializer {a,b,c,...} is not allowed to be passed via parameter!!!
 *      [List].stream().anyMatch(labmda) : 리스트를 순회하여 조건식에 true로 반환되는 요소가 하나라도 존재하면 true 반환
 *  </Memo>
 */
class Solution_06 {
    public int solution(int[] priorities, int location) {
        int turn = 0;

        List<PrintJob> printer = new ArrayList<PrintJob>();

        for(int i=0;i<priorities.length;i++){
            printer.add(new PrintJob(priorities[i], i));
        }

        while(!printer.isEmpty()){
            PrintJob job = printer.remove(0);
            //만약에 꺼낸 job보다 우선순위가 높은게 printer 리스트에 존재한다면 다시 맨앞으로 넣게
            if(printer.stream().anyMatch(otherJob -> job.priority <otherJob.priority)){
                printer.add(job);
            }else{
                turn++;
                if(job.location==location){
                    return turn;
                }
            }
        }
        return turn;
    }

    class PrintJob {
        int priority;
        int location;

        public PrintJob(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }

    public static void main(String[] args) {
        Solution_06 solution06 = new Solution_06();
        System.out.println(solution06.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution06.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}

package 김솔민;

import java.util.HashSet;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java
 *  Solution using Set
 *  2023/01/02
 *
 *  <Memo>
 *  </Memo>
 */
class Solution_07 {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for(int i:reserve){
            resSet.add(i);
        }
        for(int i:lost){
            if (resSet.contains(i)) {
                resSet.remove(i);
            }else{
                lostSet.add(i);
            }
        }


        for(int i: resSet){
            if(lostSet.contains(i-1)){
                lostSet.remove(i-1);
            }else if(lostSet.contains(i+1)){
                lostSet.remove(i+1);
            }
            System.out.println("resSet:"+resSet+" lostSet"+lostSet);
        }

        return n-lostSet.size();

    }

    public static void main(String[] args) {
        Solution_07 solution07 = new Solution_07();

        int n = 6;
        int[] lost = {2,4,5};
        int[] reserve = {1,3,6};
        System.out.println(solution07.solution(n,lost, reserve));

    }
}

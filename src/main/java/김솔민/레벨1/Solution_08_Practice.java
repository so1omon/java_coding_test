package 김솔민.레벨1;

import java.util.HashSet;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/72411
 *  Combination Practice
 *  2023/01/04
 *
 *  <Memo>
 *  </Memo>
 */
class Solution_08_Practice {

    HashSet<String> answer = new HashSet<>();
    public void combination(String pick, String rest, int count){
        if(count==0){
            answer.add(pick);
            return;
        }
        for(int i=0;i<rest.length();i++){
            combination(pick+rest.charAt(i), rest.substring(i+1), count-1);
        }
    }

    public void sol(String pick, int count){
        combination("", pick, count);
        answer.forEach(a->System.out.println(a));
    }

    public static void main(String[] args) {
        String test1 = "ABCF";
        int count = 4;

        Solution_08_Practice solution08Practice = new Solution_08_Practice();
        solution08Practice.sol(test1, count);


    }
}

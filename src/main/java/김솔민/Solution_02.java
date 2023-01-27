package 김솔민;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * Solution using Sort
 */
class Solution_02 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 1. Sorting
        Arrays.sort(phone_book);

        // 2. 한 번의 Loop로 2개씩 비교

        for(int i=0;i< phone_book.length-1;i++){
            // 3. 앞의 숫자가 뒤의 숫자의 접두어인지 확인
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer=false;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] phone_book = {"119","97674223","1195524421"};
        Solution_02 sol = new Solution_02();
        System.out.print(sol.solution(phone_book));
    }
}

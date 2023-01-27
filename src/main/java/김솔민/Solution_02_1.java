package 김솔민;

import java.util.HashMap;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 * Solution using Hash
 */
class Solution_02_1 {
    public boolean solution(String[] phone_book) {

        // 1. Hashing
        HashMap<String, Integer> map = new HashMap<>();

        // 2. Hash 찾기
        for (int i=0;i< phone_book.length;i++){
            map.put(phone_book[i], 1);
        }

        for (int i=0;i< phone_book.length;i++){
            for(int j=1;j< phone_book.length-1;j++){
                // 3. 자신이랑 같은 번호는 제외
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String[] phone_book = {"119","97674223","1195524421"};
        Solution_02_1 sol = new Solution_02_1();
        System.out.print(sol.solution(phone_book));
    }
}

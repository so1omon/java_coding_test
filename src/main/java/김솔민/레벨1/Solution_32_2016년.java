package 김솔민.레벨1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12901
 * Solution using
 * 2023/01/29
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_32_2016년 {
    public String solution(int a, int b) {
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED","THU"};
        Map<Integer, Integer> dayByMonth = new HashMap<>();
        dayByMonth.put(1, 31);
        dayByMonth.put(2, 29);
        dayByMonth.put(3, 31);
        dayByMonth.put(4, 30);
        dayByMonth.put(5, 31);
        dayByMonth.put(6, 30);
        dayByMonth.put(7, 31);
        dayByMonth.put(8, 31);
        dayByMonth.put(9, 30);
        dayByMonth.put(10, 31);
        dayByMonth.put(11, 30);
        dayByMonth.put(12, 31);

        int totalDay = 0;
        // 연도를 넘어가지 않음
        // total day를 구하고, 이를 7로 나눈 값을 days의 인덱스로 대입
        for(int i=1;i<a;i++){
            totalDay+=dayByMonth.get(i);
        }
        totalDay+=b-1;
        return days[(totalDay)%7];
    }
    public static void main(String[] args) {
        Solution_32_2016년 solution31_폰켓몬 = new Solution_32_2016년();
        int a = 5;
        int b = 24;
        System.out.println(solution31_폰켓몬.solution(a, b));
    }
}

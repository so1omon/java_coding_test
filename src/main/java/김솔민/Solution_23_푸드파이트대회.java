package 김솔민;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 * Solution using
 * 2023/01/25
 *
 *
 * <Memo>
 *     String 뒤집기 - new StringBuffer({String}).reverse().toString();
 * </Memo>
 */
class Solution_23_푸드파이트대회 {
    public String solution(int[] food) {
        String answer = "";

        for(int i=1;i<food.length;i++){
            answer+=Integer.toString(i).repeat(food[i]/2);
        }
        String reverse = new StringBuffer(answer).reverse().toString();


        return answer+'0'+reverse;
    }

    public static void main(String[] args) {
        Solution_23_푸드파이트대회 solution23_푸드파이트대회 = new Solution_23_푸드파이트대회();

        int[] food = {1, 3, 4, 6};
        System.out.println(solution23_푸드파이트대회.solution(food));
    }
}

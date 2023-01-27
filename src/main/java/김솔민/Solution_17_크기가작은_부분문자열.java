package 김솔민;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 * Solution using
 * 2023/01/25
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_17_크기가작은_부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;

        // 1. t에서 연속된 p 길이의 부분문자열 추출
        // 2. 추출한 부분문자열이 p가 나타내는 수보다 작으면 answer++

        for(int i=0;i<=t.length() - p.length();i++){ // 이러면 t길이 - p길이 까지만 탐색
            String partString = t.substring(i, p.length()+i);

            if(Long.parseLong(partString) <= Long.parseLong(p)){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_17_크기가작은_부분문자열 solution17_크기가작은_부분문자열 = new Solution_17_크기가작은_부분문자열();

        String t ="3141592";
        String p = "0";
        System.out.println(solution17_크기가작은_부분문자열.solution(t, p));
    }
}

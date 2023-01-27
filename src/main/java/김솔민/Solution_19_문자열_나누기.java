package 김솔민;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * YYYY/MM/DD
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_19_문자열_나누기 {
    public int solution(String s) {
        int answer = 0;

        /*
        먼저 첫 글자를 읽습니다. 이 글자를 x라고 합시다.
        이제 이 문자열을 왼쪽에서 오른쪽으로 읽어나가면서, x와 x가 아닌 다른 글자들이 나온 횟수를 각각 셉니다. 처음으로 두 횟수가 같아지는 순간 멈추고, 지금까지 읽은 문자열을 분리합니다.
        s에서 분리한 문자열을 빼고 남은 부분에 대해서 이 과정을 반복합니다. 남은 부분이 없다면 종료합니다.
        만약 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없다면, 역시 지금까지 읽은 문자열을 분리하고, 종료합니다.
        문자열 s가 매개변수로 주어질 때, 위 과정과 같이 문자열들로 분해하고, 분해한 문자열의 개수를 return 하는 함수 solution을 완성하세요.
        * */

        //1. 문자열을 계속 분해하는 반복문 작성
        //1-1. 탈출 조건 : index가 문자열의 길이와 같아질 때
        int idx = 0;
        char startChar='X';
        int sameChar = 0;
        int difChar = 0;

        while(true){
            if (idx==s.length()) {
                answer++;
                break;
            } else if (startChar == 'X') { // 시작문자 세팅
                startChar = s.charAt(idx++);
                sameChar++;
            } else { // 시작 문자가 있을 때
                if (sameChar == difChar) { // 조건 만족하면 초기화
                    answer++;
                    sameChar = 0;
                    difChar = 0;
                    startChar = 'X';
                    continue;
                }

                if (s.charAt(idx) == startChar) {
                    sameChar++;
                } else {
                    difChar++;
                }
                idx++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_19_문자열_나누기 solution19_문자열_나누기 = new Solution_19_문자열_나누기();
        String s = "banana";

        System.out.println(solution19_문자열_나누기.solution(s));
    }
}

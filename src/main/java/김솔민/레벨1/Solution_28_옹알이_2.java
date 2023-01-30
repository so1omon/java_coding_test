package 김솔민.레벨1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 * Solution using
 * 2023/01/27
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_28_옹알이_2 {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] ableBabbling ={"aya", "ye", "woo", "ma"};

        // 0. babbling을 순회
        // 1. 각 ableBabbling을 순회하면서 startsWith()인 것들을 추리고, 매치되면 해당 문자열부분 삭제(substr)

        for(String babble : babbling){
            // 계속 돌면서
            int targetIdx = 0;
            String tempAble ="";

            while(true){
                int compareIdx = targetIdx;
                for(String able : ableBabbling){
                    if(babble.startsWith(able,targetIdx) && !able.equals(tempAble)){
                        targetIdx+=able.length();
                        tempAble = able;
                        break;
                    }
                }

                if(targetIdx==compareIdx){  // 답이 아닌 친구
                    break;
                }else if(targetIdx== babble.length()){
                    answer++;
                    break;
                }
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        Solution_28_옹알이_2 solution28_옹알이_2 = new Solution_28_옹알이_2();

        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println(solution28_옹알이_2.solution(babbling));
    }
}

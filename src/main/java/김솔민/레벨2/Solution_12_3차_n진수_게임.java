package 김솔민.레벨2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 * Solution using
 * 2023/02/03
 *
 *
 * <Memo>
 *
 * </Memo>
 */
class Solution_12_3차_n진수_게임 {
    private static char[] overTen = {'A','B','C','D','E', 'F'};

    public String solution(int n, int t, int m, int p) {
        // 0. 결과값을 저장할 String 변수
        String answer = "";

        // 1. 특정 조건이 넘어가지 않을 때까지 0부터 시작해서 계속 진법변환한 String을
        //    answer에 붙이기
        // 1-1. 특정 조건 : 인덱스를 p, m+p, (t-1)*m+p까지 접근하므로 최소한
        //                t*m까지는 문자열을 미리 만들어두어야 함
        for(int i=0;answer.length()<=t*m;i++){
            // 2. i -> n진법 String으로 변환시키는 함수 만들기
            answer+=changeNum(n, i);
        }

        String result = "";
        // 2. p-1, m+p-1, ..., (t-1)*m+p-1 순으로 접근해서 result에 갖다붙이기

        // System.out.println(answer);
        for(int i=p-1;i<=(t-1)*m+p-1;i+=m){
            result+=answer.charAt(i);
        }

        return result;
    }

    // i를 n진법 String으로 변환
    public String changeNum(int n, int i){
        List<Character> changed = new ArrayList<>();

        if(i==0){
            return "0";
        }

        while(i!=0){
            int target = i%n;
            if(target>=10){ // 10을 넘으면 overTen 적용
                changed.add(overTen[target-10]);
            }else{
                changed.add((char)(target+'0'));
            }
            i/=n;
        }
        // System.out.println(changed);
        // Collections.sort(changed, Collections.reverseOrder());
        String result = "";
        for(int j=changed.size()-1;j>=0;j--){
            result+=changed.get(j);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_12_3차_n진수_게임 solution123차_n진수_게임 = new Solution_12_3차_n진수_게임();

        System.out.println(solution123차_n진수_게임.solution(16,16,2,2));
    }
}

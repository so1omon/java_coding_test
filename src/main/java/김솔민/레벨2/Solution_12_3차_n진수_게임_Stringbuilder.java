package 김솔민.레벨2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 * Solution using StringBuilder
 * 2023/02/03
 *
 *
 * <Memo>
 *  String에 직접적인 연산을 하기보다 stringBuiler를 사용하는게 훨씬 빠른 결과값을 가져옴
 *  StringBuilder sb = new StringBuilder();
 *  sb.append(char | String) : 스트링빌더에 character 또는 문자열 붙이기
 *  sb.reverse() : 스트링빌더 문자들 역순으로 바꾸기
 *  sb.toString() : String으로 변환
 * </Memo>
 */
class Solution_12_3차_n진수_게임_Stringbuilder {
    private static char[] overTen = {'A','B','C','D','E', 'F'};

    public String solution(int n, int t, int m, int p) {
        // 0. 결과값을 저장할 String 변수
        StringBuilder sb = new StringBuilder();
        // 1. 특정 조건이 넘어가지 않을 때까지 0부터 시작해서 계속 진법변환한 String을
        //    answer에 붙이기
        // 1-1. 특정 조건 : 인덱스를 p, m+p, (t-1)*m+p까지 접근하므로 최소한
        //                t*m까지는 문자열을 미리 만들어두어야 함
        for(int i=0;sb.length()<=t*m;i++){
            // 2. i -> n진법 String으로 변환시키는 함수 만들기
            sb.append(changeNum(n, i));
        }

        StringBuilder result = new StringBuilder();
        // 2. p-1, m+p-1, ..., (t-1)*m+p-1 순으로 접근해서 result에 갖다붙이기

        String target = sb.toString();
        for(int i=p-1;i<=(t-1)*m+p-1;i+=m){
            result.append(target.charAt(i));
        }

        return result.toString();
    }

    // i를 n진법 String으로 변환
    public String changeNum(int n, int i){
        StringBuilder changed = new StringBuilder();
        if(i==0){
            return "0";
        }

        while(i!=0){
            int target = i%n;
            if(target>=10){ // 10을 넘으면 overTen 적용
                changed.append(overTen[target-10]);
            }else{
                changed.append((char)(target+'0'));
            }
            i/=n;
        }

        return changed.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_12_3차_n진수_게임_Stringbuilder solution123차_n진수_게임 = new Solution_12_3차_n진수_게임_Stringbuilder();

        System.out.println(solution123차_n진수_게임.solution(16,16,2,2));
    }
}

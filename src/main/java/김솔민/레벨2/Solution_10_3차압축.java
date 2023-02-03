package 김솔민.레벨2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * 2022/02/02
 *
 *
 * <Memo>
 *   Character -> String 형변환
 *      단일 character일 때 : Character.toString(ch);
 *      character 배열일 때 : String.valueOf(charray);
 *   List -> Array 전환
 *      List<Integer> list = new ArrayList<>();
 *      list.stream().mapToInt(Integer::intValue).toArray();
 * </Memo>
 */
class Solution_10_3차압축 {
    public int[] solution(String msg) {

        // 0. 저장할 색인 번호 List 생성
        List<Integer> indexes = new ArrayList<>();
        // 1. A~Z까지 문자열이 담긴 Map 생성
        Map<String, Integer> dict = new HashMap<>();

        int count=1;

        for(int i='A'-0;i<='Z'-0;i++){
            char alphabet = (char)i;
            dict.put(Character.toString(alphabet), count++);
        }

        // 2. msg를 index로 순회
        while(msg.length()!=0){
            int tempIdx = 0;
            // 2-1. 문자열 길이를 늘려가면서 순회 (while로 변경)
            for(int i=1;i<=msg.length();i++){
                String target = new String(msg);
                if(i!=msg.length()){
                    target=target.substring(0,i);
                }

                // 2-2. 이 과정에서 사전에 등록되어 있으면 임시 변수에 색인 번호만 저장
                if(dict.containsKey(target)){
                    tempIdx = dict.get(target);

                    // 끝까지 다 돌았으면 msg를 없애버리기
                    if(i==msg.length()){
                        msg="";
                        break;
                    }
                }else{
                    // 2-3. 사전에 등록되어있지 않으면 사전에 등록하고 msg 자르기
                    dict.put(target, count++);
                    msg = msg.substring(i-1);
                    break;
                }
            }
            // 색인 번호 저장
            indexes.add(tempIdx);
        }

        int[] answer = new int[indexes.size()];
        int iter =0;
        for(Integer index : indexes){
            answer[iter++] = index;
        }

        return answer;
    }

    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        Solution_10_3차압축 solution103차압축 = new Solution_10_3차압축();

        System.out.println(solution103차압축.solution(msg));
    }
}

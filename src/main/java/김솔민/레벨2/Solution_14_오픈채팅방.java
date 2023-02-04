package 김솔민.레벨2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * YYYY/MM/DD
 *
 *
 * <Memo>
 *   Entry 사용법
 *      1. Map.entry([key], [value]) : key, value 쌍을 갖는 Entry 객체 반환
 *      2. Map.Entry<S, T> : key, value 쌍으로 S, T 타입을 갖는 객체 선언
 *      3. [Entry].(getKey() | getValue()) : Entry의 key, value 가져오기
 * </Memo>
 */
class Solution_14_오픈채팅방 {
    public String[] solution(String[] record) {
        // 제약 조건 : 중복된 닉네임이 있을 수 있기 때문에, 사용자 고유 닉네임도 같이 활용하기

        // 1. 유저의 활동 패턴을 저장할 리스트(integer) 생성 (나가기:0, 들어오기:1)
        // cf) entrySet 찾아보기
        List<Map.Entry<String, Integer>> patterns = new ArrayList<>();

        // 2. 유저의 id : 유저의 닉네임을 저장할 Map 생성
        Map<String, String> userInfo = new HashMap<>();
        // 3. record를 돌아가면서 parsing -> splitted
        for(String r : record){
            String[] splitted = r.split(" ");
            // 3-1. splitted[0]이 Enter일 경우 : pattern에 enter(0) 저장
            //      Map에 유저정보 저장

            if(splitted[0].equals("Enter")){
                patterns.add(Map.entry(splitted[1], 0));
                userInfo.put(splitted[1], splitted[2]);
            }
            // 3-2. splitted[0]이 Leave일 경우 : pattern에 leave(1) 저장
            else if(splitted[0].equals("Leave")){
                patterns.add(Map.entry(splitted[1], 1));
            }
            // 3-3. splitted[0]이 Change일 경우 : Map에 유저정보 수정
            else{
                userInfo.put(splitted[1], splitted[2]);
            }
        }
        List<String> answerList = new ArrayList<>();

        // 4. 최종적으로 patterns와 map을 활용해 answer 생성

        for(Map.Entry<String, Integer> pattern : patterns){
            // getKey, getValue
            String userName = userInfo.get(pattern.getKey());

            if(pattern.getValue()==0){ //들어오기
                answerList.add(userName+"님이 들어왔습니다.");
            }else{//나가기
                answerList.add(userName+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[answerList.size()];
        int count = 0;
        for(String ans : answerList){
            answer[count++]=ans;
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}

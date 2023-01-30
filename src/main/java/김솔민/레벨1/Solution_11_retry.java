package 김솔민.레벨1;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 * Solution using
 * 2023/01/06
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_11_retry {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 1. report 중복 제거
        HashSet<String> reportNotDup = new HashSet<>();
        HashMap<String, ArrayList<String>> countList = new HashMap<>();
        HashMap<String, Integer> reporterMap = new LinkedHashMap<>();


        for(String r : report){
            reportNotDup.add(r);
        }

        for(String id : id_list){
            reporterMap.put(id, 0);
        }

        // 2. reportNotDup을 순회하여 신고 몇번 당했는지 countList 만들기
        for(String s : reportNotDup){
            String[] temp = s.split(" ");

            ArrayList<String> tempArray = countList.getOrDefault(temp[1], null);
            tempArray.add(temp[0]);
            countList.put(temp[1], tempArray);
        }

        // 3. LinkedHashMap인 reporterMap애 countList의 values를 순회하여
        // values의 크기가 2 이상이면 배열 순회 후 reporterMap에 count++
        for(List<String> list : countList.values()){
            if(list.size()>=k){
                for(String target : list){
                    reporterMap.put(target, reporterMap.getOrDefault(target, 0)+1);
                }
            }
        }

        int[] answer = new int[reporterMap.values().size()];
        int i=0;
        for(Integer count : reporterMap.values()){
            answer[i++] =count;
        }
        return answer;
    }

    public static void main(String[] args) {

        Solution_11_retry solution11MyAnswer = new Solution_11_retry();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(solution11MyAnswer.solution(id_list,report, k));
    }
}

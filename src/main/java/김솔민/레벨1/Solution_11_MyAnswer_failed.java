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
class Solution_11_MyAnswer_failed {
    public int[] solution(String[] id_list, String[] report, int k) {


        HashMap<String, HashSet<String>> reportMap = new LinkedHashMap<>();
        List<String> totalReportList = new ArrayList<>();

        HashMap<String, Integer> countReport = new HashMap<>();

        for(String id : id_list){
            reportMap.put(id, new HashSet<>());
        }

        for(String r : report){
            //1. report split 해서 [누가 -> 누구를 신고했는지] 가져오고, 이를 reportMap<신고한 사람 String, 신고당한 사람 SET> 에 저장
            String[] reported=r.split(" "); //report[0]은 신고한 사람, report[1]은 신고당한 사람
            HashSet temp = reportMap.getOrDefault(reported[0], new HashSet<String>());
            temp.add(reported[1]);
            reportMap.put(reported[0], temp);
        }


        //2. reportMap을 순회하여, countReport map에 신고당한 횟수를 저장, 이후 countReport에 신고당한 횟수가 2 이상인 사람들만 배열로 추출
        //totalReportList
        reportMap.values().forEach(s->{
            s.forEach(r->{
                countReport.put(r,countReport.getOrDefault(r,0)+1);
            });
        });

        countReport.forEach((s,r)->{
            if(r>=2){
                totalReportList.add(s);
            }
        });
        int[] answer = new int[reportMap.values().size()];

        //3. 다시 repotMap을 순회하여, 신고당한 사람 SET에 totalReportList가 몇 명 포함되었는지 answer에 add
        int i=0;
        for(HashSet h : reportMap.values()){
            int total=0;

            Iterator<String> iter = h.stream().iterator();
            while(iter.hasNext()){
                if(totalReportList.contains(iter.next())){
                    total++;
                }
            }
            answer[i++]=total;
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution_11_MyAnswer_failed solution11MyAnswer = new Solution_11_MyAnswer_failed();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        for(int i : solution11MyAnswer.solution(id_list,report, k)){
            System.out.println(i);
        };
    }
}

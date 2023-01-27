package 김솔민;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * Solution using
 * 2023/01/25
 *
 *
 * <Memo>
 *     SimpleDateFormat Symbol
 *      yyyy : 연도 4글자
 *      MM : 월 2글자
 *      dd : 일 2글자
 * </Memo>
 */
class Solution_16_개인정보수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) throws Exception{

        List<Integer> answerList  = new ArrayList<>();

        Map<String, Date> termMap = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date nowDate = format.parse(today); // 현재 날짜 Date
        Calendar calendar = Calendar.getInstance(); // 날짜연산 controller

        //1. term Map 생성 (key : 약관명, value : 약관만료기한)
        for (String term : terms){
            String[] splitted = term.split(" "); // [0] : 약관명 , [1] : 약관기한(달)
            calendar.setTime(nowDate);
            calendar.add(Calendar.MONTH, (-1)*Integer.parseInt(splitted[1]));
            termMap.put(splitted[0], calendar.getTime());
            calendar.clear();
        }

        //2. privacy 돌려가면서 termMap에 나와 있는 Date와 비교해서 이전 시점이면 answer에 담기
        for (int i=0;i<privacies.length;i++){ // i : 약관번호
            String[] splitted = privacies[i].split(" "); // [0] : 비교날짜, [1] : 약관명
            Date expired = termMap.get(splitted[1]);

            Date target = format.parse(splitted[0]);
            if(expired.compareTo(target)>=0){ // expired가 nowDate보다 과거 시간, 즉 보관 불가능
                answerList.add(i+1);
            }
        }

        int[] answer = new int[answerList.size()];
        int count = 0;
        for (int ans :answerList){
            answer[count++] = ans;
        }

        return answer;
    }
    public static void main(String[] args) throws Exception{
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] result = new Solution_16_개인정보수집_유효기간().solution(today, terms, privacies);

        for(int r : result){
            System.out.print(r);
        }
    }
}

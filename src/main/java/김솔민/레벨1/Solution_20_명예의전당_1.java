package 김솔민.레벨1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/138477
 * Solution using
 * 2023/01/25
 *
 *
 * <Memo>
 *     List 자르기
 *      {List}.stream().skip(n).limit(k).collect(Collectors.toList()) : List를 n부터 k개까지 자르기
 * </Memo>
 */
class Solution_20_명예의전당_1 {
    public int[] solution(int k, int[] scores) {
        int[] answer = new int[scores.length];
        int count = 0;
        List<Integer> ranking = new ArrayList<>();

        //1. score를 받아서 매번 Ranking에 넣고 내림차순 정렬
        //2. Ranking을 k만큼 자르기
        //3. 최하위 점수를 answer에 넣기
        for(int score : scores){
            ranking.add(score);
            Collections.sort(ranking, Collections.reverseOrder());

            ranking = ranking.stream().limit(k).collect(Collectors.toList());
            answer[count++] = ranking.get(ranking.size()-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_20_명예의전당_1 solution20_명예의전당_1 = new Solution_20_명예의전당_1();
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        System.out.println(Arrays.toString(solution20_명예의전당_1.solution(k, score)));
    }
}

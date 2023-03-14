package 김솔민.레벨3;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * Solution using
 * 2023/03/10
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_12_여행_경로 {
    static List<String> answerList = new ArrayList<>();;

    public String[] solution(String[][] tickets) {
        String cur = "ICN";

        bfs(cur, tickets, new boolean[tickets.length], 0, cur);

        Collections.sort(answerList);

        return answerList.get(0).split(" ");
    }

    void bfs(String start, String[][] tickets, boolean[] visited, int depth,
             String total){
        if(depth==tickets.length){
            answerList.add(total);
        }

        for(int i=0;i<tickets.length;i++){
            if(start.equals(tickets[i][0])&&!visited[i]){
                visited[i] = true;
                bfs(tickets[i][1], tickets, visited, depth+1,
                    total + " " + tickets[i][1]);
                visited[i] = false;
            }
        }

    }
}

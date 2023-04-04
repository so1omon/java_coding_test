package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43164
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Practice_12 {

    class Solution {
        static Map<String, List<Edge>> map = new HashMap<>();
        static List<String> answerList = new ArrayList<>();
        static int n;
        public String[] solution(String[][] tickets) {
            String[] answer = {};

            n = tickets.length;
            for(String[] t : tickets){
                if(map.containsKey(t[0])){
                    map.get(t[0]).add(new Edge(t[1]));
                }else{
                    List<Edge> list = new ArrayList<>();
                    list.add(new Edge(t[1]));
                    map.put(t[0], list);
                }
            }

            String[] saved = new String[n+1];
            saved[0] = "ICN";
            dfs(saved, "ICN", 1);

            Collections.sort(answerList);
            for(String s : answerList){
                System.out.println(s);
            }

            return answerList.get(0).split(" ");
        }

        void dfs(String[] saved, String cur, int cnt){
            if(cnt==n+1){
                answerList.add(String.join(" ", saved));
                return;
            }

            List<Edge> list = map.getOrDefault(cur, new ArrayList<>());

            for(int i =0;i<list.size();i++){
                Edge e= list.get(i);
                if(e.visited){
                    continue;
                }
                e.visited = true;
                saved[cnt] = e.to;
                dfs(saved, e.to, cnt+1);
                e.visited = false;
            }

        }

        class Edge{
            boolean visited = false;

            String to;

            Edge(String t){
                this.to = t;
            }
        }
    }
}
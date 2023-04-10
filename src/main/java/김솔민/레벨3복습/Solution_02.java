package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 * Solution using
 * 2023/04/05
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;
class Solution_02 {
    static List<String> answerList = new ArrayList<>();
    static boolean[][] map;
    static String[] user_idss;
    public int solution(String[] user_ids, String[] banned_ids) {
        user_idss = user_ids;
        map = new boolean[banned_ids.length][user_ids.length];

        for(int i=0;i<banned_ids.length;i++){
            for(int j=0;j<user_ids.length;j++){
                map[i][j] = validate(user_ids[j], banned_ids[i]);
            }
        }

        dfs(new boolean[user_ids.length], banned_ids.length, 0, new String[banned_ids.length]);

        return answerList.size();
    }

    void dfs(boolean[] visited, int n, int depth, String[] saved){
        if(depth==n){
            String[] copied = Arrays.copyOf(saved, saved.length);
            Arrays.sort(copied);
            String joined = String.join("", copied);

            if(!answerList.contains(joined)){
                answerList.add(joined);
            }

            return;
        }

        for(int i=0;i<map[0].length;i++){
            if((!visited[i]) && (map[depth][i])){
                visited[i] = true;

                saved[depth] = user_idss[i];
                dfs(visited, n, depth+1, saved);
                visited[i] = false;
            }
        }

    }


    boolean validate(String origin, String regex){
        if(origin.length()!=regex.length()){
            return false;
        }

        for(int i=0;i<origin.length();i++){
            if(regex.charAt(i)=='*' || origin.charAt(i)==regex.charAt(i)){
                continue;
            }
            return false;
        }
        return true;
    }
}

package 김솔민.레벨3;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64064
 * Solution using
 * 2023/03/02
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_02_불량_사용자 {
    Set<String> banned_list;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        int userCnt = user_id.length;
        int banCnt = banned_id.length;

        banned_list = new HashSet<>();

        boolean[][] map = new boolean[userCnt][banCnt];

        for(int i=0;i<userCnt;i++){
            for(int j=0;j<banCnt;j++){
                if(isMatch(user_id[i], banned_id[j])){
                    map[i][j] = true;
                }else{
                    map[i][j] = false;
                }
            }
        }

        // 재귀로 구현
        // banned_id를 잡고 순회
        // 인덱스 하나를 잡고, 해당 열은 전부다 false처리
        // 만약 특정한 banned_id에서 매핑할 user_id가 없다면 아무것도 하지 않고 return
        dfs(map, 0, new int[banCnt], banCnt, new boolean[userCnt]);

        return banned_list.size();
    }

    public boolean isMatch(String comp, String regex){
        if(comp.length() != regex.length()){
            return false;
        }

        for(int i=0;i<comp.length();i++){
            if(regex.charAt(i)=='*' || comp.charAt(i)==regex.charAt(i)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }



    void dfs(
        boolean[][] map, int depth, int[] target, int n, boolean[] visited){
        // 탈출 조건
        if(depth==n){
            char[] arr = new char[target.length];

            for(int i=0;i<target.length;i++){

                arr[i] = (char)(target[i]+'0');
            }

            Arrays.sort(arr);
            String result = String.valueOf(arr);

            banned_list.add(result);

            return;
        }

        boolean flag = false;
        for(int i=0;i<map.length;i++){

            // 찾으면 해당 열 전부다 false 한 후 다시 원복
            if(map[i][depth] && !visited[i]){
                flag = true;
                visited[i] = true;
                target[depth] = i;
                dfs(map, depth+1, target, n, visited);
                visited[i] = false;
            }

        }

        if(!flag){
            return;
        }
    }

    public static void main(String[] args) {

    }
}

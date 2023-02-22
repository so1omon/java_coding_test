package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * 2023/02/22
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_35_단체사진찍기 {
    static int answer;
    static Map<String, List<Integer>> map;
    static String friends;

    public int solution(int n, String[] data) {
        answer = 0;
        map = new HashMap<>();
        friends="ACFJMNRT";
        for(String d : data){
            char[] splitted = d.toCharArray(); //"N ~ F = 0",
            String key = "";
            if(splitted[0]>splitted[2]){
                key +=splitted[0];
                key +=splitted[2];
            }else{
                key +=splitted[2];
                key +=splitted[0];
            }

            List<Integer> pool = map.getOrDefault(key, new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6)));
            int target = splitted[4] - '0';
            switch(splitted[3]){
                case '=':
                    pool.removeIf(elem -> (elem!=target));
                    break;
                case '<':
                    pool.removeIf(elem -> (elem>=target));
                    break;
                case '>':
                    pool.removeIf(elem -> (elem<=target));
                    break;
                default:
                    break;
            }

            if(pool.isEmpty()){
                return 0;
            }

            map.put(key, pool);
        }

        comb(0, 8, new char[8], new boolean[8]);

        return answer;
    }

    // r : 현재 위치
    void comb(int depth, int n, char[] frinedsArr, boolean[] visited){
        // 탈출 조건 : depth==n
        if(depth==n){
            // 이때부터 조건 check 시작
            for(String key : map.keySet()){
                String friendStr = String.valueOf(frinedsArr);
                // key.charAt(0)과 key.charAt(1)의 거리를 측정
                int idxDif = Math.abs(friendStr.indexOf(key.charAt(0)) - friendStr.indexOf(key.charAt(1)))-1;

                // 만약 두 거리가 map.get(key) 배열 안에 있을 경우 answer++
                if(!map.get(key).contains(idxDif)){
                    return;
                }
            }
            answer++;

        }else {
            for (int i = 0; i < 8; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                frinedsArr[depth] = friends.charAt(i);
                comb(depth+1, n, frinedsArr, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        System.out.println(new Solution_35_단체사진찍기().solution(n, data));
    }
}

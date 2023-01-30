package 김솔민.레벨1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 * Solution using recursion combination
 * 2023/01/26
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_25_삼총사 {
    private static int answer=0;

    public int solution(int[] number) {

        comb(number, number.length, 3, new boolean[number.length], 0);

        return answer;
    }

    public void comb(int[] origin, int n, int r, boolean[] visited, int depth){
        if(r==0){ // 조합 완성시킨 조건
            // static 변수에 채워넣기
            // 1. visited된 idx들을 저장
            List<Integer> targetList = new ArrayList<>();

            for(int i=0;i<visited.length;i++){
                if(visited[i]){
                    targetList.add(origin[i]);
                }
            }

            // 모든 합 구하기
            if(targetList.stream().mapToInt(i->i).sum()==0){
                answer++;
            };
            return;
        }

        if(depth==n){// 다 찾기 전에 실패한 조건
            // 다 찾기 전에 실패한 조건
            return;
        }

        visited[depth]=true;
        // 이번 index를 포함해서 조합을 구할건지
        comb(origin, n, r-1, visited, depth+1);

        // 이번 index를 제외해서 조합을 구할건지
        visited[depth]=false;
        comb(origin, n, r, visited, depth+1);

    }

    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        Solution_25_삼총사 solution25_삼총사 = new Solution_25_삼총사();
        System.out.println(solution25_삼총사.solution(number));
    }
}

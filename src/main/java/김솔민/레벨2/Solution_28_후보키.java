package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42890
 * Solution using Set and removeIf
 * 2023/02/13
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_28_후보키 {
    List<int[]> colComb = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;
        int col = relation[0].length;
        int row = relation.length;

        // 1. 1~컬럼길이까지 combination 가져오기
        for(int i=1;i<=col;i++){
            comb(new boolean[col], col, 0, i);
        }

        StringBuilder sb = new StringBuilder();
        // 2. 가져온 조합 경우의 수를 루프돌리기
        while(true){
            if(colComb.size()==0){
                break;
            }
            int[] targetArr = colComb.get(0);
            Set<String> set = new HashSet<>();

            for(int i=0;i<row;i++){
                for(int t=0;t<targetArr.length;t++){
                    sb.append(
                        relation[i][targetArr[t]]);
                }
                set.add(sb.toString());
                sb.delete(0, sb.length());
            }

            // 3. 특정 조합의 경우에서 후보 키 조건을 만족시킨다면, answer++
            //    그리고 해당 조합과 해당 조합을 포함하는 조합들도 버리기
            // 3-1. 후보 키 조건을 만족시키지 않는다면 바로 버리기
            // cf) 자바 array in operation 찾아보기
            if(set.size()!=row){
                colComb.remove(0);
            }else{
                answer++;
                colComb.removeIf(arr -> {
                    Set<Integer> baseSet = new HashSet<>();
                    Set<Integer> compareSet = new HashSet<>();
                    for(int t : targetArr) {
                        baseSet.add(t);
                    }
                    for(int a : arr) {
                        compareSet.add(a);
                    }
                    baseSet.removeAll(compareSet);
                    if(baseSet.size()==0){
                        return true;
                    }
                    return false;
                });
            }


        }

        return answer;
    }

    // 조합수 (r: 현재인덱스, depth: 뽑은 개수, n: 전체길이)
    void comb(boolean[] visited, int n, int r, int depth){

        // 탈출 조건 (성공시)
        if(depth==0){
            List<Integer> result = new ArrayList<>();
            for(int i=0;i<visited.length;i++){
                if(visited[i]){
                    result.add(i);
                }
            }
            int[] arr = new int[result.size()];
            int count =0;
            for(int i : result){
                arr[count++] = i;
            }
            colComb.add(arr);
            return;
        }

        // 탈출 조건 (실패시)
        if(r==n){
            return;
        }
        // 방문 했을 때
        visited[r] = true;
        comb(visited, n, r+1, depth-1);

        // 방문 안했을 때
        visited[r] = false;
        comb(visited, n, r+1, depth);


    }

}

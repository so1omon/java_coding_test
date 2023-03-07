package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72413
 * Solution using
 * 2023/03/07
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_07_합승택시요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {

        // 전략 : 1~n부터 시작해서 A, B, S까지 걸리는 운임비를 구하기
        // 택시비 총합 : (X->S) + (X->A) + (X->B)
        // 총합이 최소가 되는 값을 리턴

        // 예상 연산 횟수 : 3*n*logn -> O(nlogn)
        // n의 최댓값이 200이므로 연산 속도 보장
        int INF = 20000001;
        int answer = INF;

        // n번 간선 -> fareArr[n-1]
        int[][] fareArr = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // 같은 노드 -> 같은 노드
                if(i==j){
                    fareArr[i][j] = 0;
                }else{
                    fareArr[i][j] = INF;
                }
            }
        }

        for(int[] fare : fares){
            fareArr[fare[0]-1][fare[1]-1] = fare[2];
            fareArr[fare[1]-1][fare[0]-1] = fare[2];
        }


        // 워샬 플로이드
        for(int v=0;v<n;v++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int target = fareArr[i][v] + fareArr[v][j];
                    if(fareArr[i][j] > target){
                        fareArr[i][j] = target;
                        fareArr[j][i] = target;
                    }
                }
            }
        }



        for(int i=0;i<n;i++){
            int target = fareArr[i][a-1] + fareArr[i][b-1] + fareArr[i][s-1];
            if(answer > target){
                answer = target;
            }
        }


        return answer;
    }
}

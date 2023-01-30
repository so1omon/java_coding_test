package 김솔민.레벨1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2606
 * Solution using
 * 2023/01/07
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_15_바이러스 {

    HashMap<Integer, ArrayList<Integer>> network = new HashMap<>();

    public int solution(int comps, int vectNum, int[][] networks) {
        int answer = 0;

        // 1. key : 기준 컴퓨터, value : key에 연결되어 있는 컴퓨터 List로 값 받아오기
        for(int i=0;i<networks.length;i++){
            ArrayList<Integer> temp1 = network.getOrDefault(networks[i][0], new ArrayList<>());
            ArrayList<Integer> temp2 = network.getOrDefault(networks[i][1], new ArrayList<>());
            temp1.add(networks[i][1]);
            temp2.add(networks[i][0]);
            network.put(networks[i][0], temp1);
            network.put(networks[i][1], temp2);
        }

        System.out.println(network);
        // 2. comps+1 크기의 visit 배열 생성 (0번 인덱스는 버리기)
        int[] visit = new int[comps+1];
        // 3. 1번 컴퓨터 기준으로 dfs로 각각의 컴퓨터를 방문
        dfs(1, visit);

        for(int i=2;i<visit.length;i++){
            if(visit[i]==1){
                answer++;
            }
        }

        return answer;
    }

    public int[] dfs(int startIdx, int[] visit){
        if(visit[startIdx]==1){
            return visit;
        }else{
            visit[startIdx]=1;
            ArrayList<Integer> connected = network.getOrDefault(startIdx, new ArrayList<>());
            for(int i : connected) {
                if(visit[i]!=1){
                    dfs(i, visit);
                }
            }
        }
        return visit;
    }

    public static void main(String[] args) {
        Solution_15_바이러스 solution15 = new Solution_15_바이러스();
        Scanner sc = new Scanner(System.in);
        int comps = sc.nextInt();
        int vectNum = sc.nextInt();

        int[][] networkFull = new int[comps][comps];
        for (int i = 0; i < vectNum; i++) {
            networkFull[i][0] = sc.nextInt();
            networkFull[i][1] = sc.nextInt();
        }


        System.out.println(solution15.solution(comps, vectNum, networkFull));

    }
}

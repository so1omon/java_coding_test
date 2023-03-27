package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150367
 * Solution using
 * 2023/03/26
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;
class Solution_21_표현_가능한_이진트리_나중에다시풀기 {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i : toBin(423)){
            System.out.print(i);
        }
        System.out.println();
        // 변환시킨 이진수를 담을 List를 반복마다 보유하기
        // 이진수로 표현 시 개수가 짝수개면 맨 앞에 0을 채워줘야 함
        // 리프 노를 인덱스+1로 표현하면 1~2^노드깊이 -1
        for(int i=0;i<numbers.length;i++){
            List<Integer> temp = toBin(numbers[i]);

            if(dfs(temp, temp.size()/2, get2Log(temp.size())-1, temp.get(temp.size()/2))){
                answer[i] = 1;
            }
        }

        return answer;
    }

    List<Integer> toBin(long num){
        // 새 요구사항 : number를 이진수로 변환 시 길이가 2^n-1개가 아니면 그만큼 채워주기
        List<Integer> list = new ArrayList<>();
        while(num!=0L){
            list.add(0, (int)(num%2));
            num/=2;
        }

        int len = list.size();
        int cnt = 0;
        while(len!=0){
            len/=2;
            cnt++;
        }
        int limit = (int)Math.pow(2, cnt)-1;
        while(list.size()!=limit){
            list.add(0,0);
        }

        return list;
    }

    int get2Log(int target){
        int cnt = -1;
        target+=1;
        while(target!=0){
            target/=2;
            cnt++;
        }
        return cnt;
    }

    boolean dfs(List<Integer> target, int idx, int depth, int parent){
        // 탈출 지점 : depth<0일 때
        if(depth<0){
            return true;
        }
        int targetNum = target.get(idx);
        if(parent == 0 && targetNum==1){
            return false;
        }

        // 다음 왼쪽 노드 : idx - 2^(depth-1)
        // 다음 오른쪽 노드 : idx + 2^(depth-1)
        return dfs(target, idx-(int)Math.pow(2, depth-1), depth-1, targetNum) &&
            dfs(target, idx+(int)Math.pow(2, depth-1), depth-1, targetNum);
    }

}

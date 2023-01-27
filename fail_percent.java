package programmers;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.*;
import java.util.HashMap;

public class fail_percent {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int arr1[]=new int[N+1];//스테이지 도달한 플레이어 수
        int arr2[]=new int[N+1];//도전 중인 플레이어 수
        for(int n:stages){
            if(n>N){
                for(int i=1;i<=N;i++){
                    arr1[i]++;
                }
            }
            else{
            for(int i=1;i<=n;i++){
                arr1[i]++;
            }
            arr2[n]++;}
        }
        Map<Integer, Double> map = new HashMap<>();
        for(int i=1;i<=N;i++){
            if(arr1[i]==0)
                map.put(i,0.0);
            else {
                map.put(i,(double) arr2[i] / arr1[i]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(x,y)->Double.compare(map.get(y),map.get(x)));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}


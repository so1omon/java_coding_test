package 김성아.레벨2;
import java.util.*;
public class 배달 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        Queue<Integer>que=new LinkedList<>();
        int [][]arr=new int[N+1][N+1];
        for(int i=0;i<road.length;i++){
            if(arr[road[i][0]][road[i][1]]!=0){
                if(road[i][2]<arr[road[i][0]][road[i][1]]){
                    arr[road[i][0]][road[i][1]]=road[i][2];
                    arr[road[i][1]][road[i][0]]=road[i][2];
                }
            }
            else{
                arr[road[i][0]][road[i][1]]=road[i][2];
                arr[road[i][1]][road[i][0]]=road[i][2];}
        }
        for(int i=1;i<=N;i++){
            if(arr[1][i]!=0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int node=que.poll();
            for(int i=2;i<=N;i++){
                if(arr[node][i]!=0){
                    if(arr[1][i]==0||arr[1][i]>arr[1][node]+arr[node][i]){
                        arr[1][i]=arr[1][node]+arr[node][i];
                        que.add(i);
                    }
                }
            }
        }
        for(int i=2;i<=N;i++){
            if(arr[1][i]<=K){
                System.out.println(i);
                answer++;}
        }

        return answer+1;
    }
}

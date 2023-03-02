package 김성아.레벨3;

public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int wave=2*w+1;
        int pre=-w;
        int temp=0;
        for(int i=0;i<stations.length;i++){
            temp=stations[i]-pre-1;
            if(temp>2*w){
                temp-=2*w;
                answer+=(temp/wave);
                if(temp%wave!=0)
                    answer++;
            }
            pre=stations[i];
        }
        int last_station=n-stations[stations.length-1];
        if(last_station>w){
            temp=last_station-w;
            answer+=(temp/wave);
            if(temp%wave!=0)
                answer++;
        }
        return answer;
    }
}

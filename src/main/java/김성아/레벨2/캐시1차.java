package 김성아.레벨2;
import java.util.*;
public class 캐시1차 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String>que=new LinkedList<>();
        int count=0;
        if(cacheSize==0){
            answer=cities.length*5;
        }
        else{
            for(String city:cities){
                city=city.toUpperCase();
                if(que.contains(city)){
                    que.remove(city);
                    que.add(city);
                    answer++;}
                else{
                    if(cacheSize>count)
                        count++;
                    else
                        que.poll();
                    answer+=5;
                    que.add(city);}

            }
        }
        return answer;
    }
}

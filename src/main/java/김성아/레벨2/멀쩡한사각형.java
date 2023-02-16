package 김성아.레벨2;
import java.util.*;
public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer=0;
        long max=Math.max(w,h);
        long min=Math.min(w,h);
        for(int i=1;i<=min;i++){
            double n1=(double)max*(i-1)/min;
            double n2=(double)max*i/min;
            answer+=(Math.ceil(n2)-Math.ceil(n1));
            if(n1%1!=0&&n2%1!=0){
                answer++;
            }
            else if(n1%1!=0)
                answer++;
        }
        answer=min*max-answer;
        return answer;
    }
}

package 김성아;
import java.util.*;
public class prediction_list_of_matchs {
    public long solution(int n, int a, int b)
    {
        long answer = 0;
        while(a!=b){
            if(a!=1){
                if(a%2==1){
                    a++;}
                a/=2;}
            if(b!=1){
                if(b%2==1)
                    b++;
                b/=2;}
            answer++;
        }
        return answer;
    }
}

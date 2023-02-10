package 김성아.레벨2;
import java.util.*;
public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String,Integer>map=new HashMap<>();
        int order_arr[]=new int[n];
        int order_iter=0;
        String pre_str="";
        for(String str:words){
            if(order_iter==n)
                order_iter=0;
            if(pre_str==""){
                pre_str=str;
            }
            else if(map.get(str)!=null||pre_str.charAt(pre_str.length()-1)!=str.charAt(0))                 {answer[0]=order_iter+1;
                answer[1]=order_arr[order_iter]+1;
                return answer;

            }

            else{
                map.put(str,1);
                order_arr[order_iter]++;
                pre_str=str;
            }
            order_iter++;
        }
        answer[0]=0;
        answer[1]=0;
        return answer;
    }
}

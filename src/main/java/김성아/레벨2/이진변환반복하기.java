package 김성아.레벨2;
import java.util.*;
public class 이진변환반복하기 {
    public int[] solution(String s) {
        int[] answer=new int[2];
        int count=0;
        int tot_cnt=0;
        String s_ch="";
        while(s.length()>1){
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0')
                    count++;
                else
                    s_ch+="1";
            }
            //System.out.println(s_ch);
            int s_len=s_ch.length();
            Stack<Integer>stack=new Stack<>();
            while(s_len>=2){
                stack.push(s_len%2);
                s_len/=2;
            }
            stack.push(s_len);
            int ss=stack.size();
            s_ch="";
            s="";
            for(int i=0;i<ss;i++){
                System.out.println(stack.peek());
                s+=Integer.toString(stack.pop());
                //System.out.println(s_ch);
            }

            //System.out.println(s);
            tot_cnt++;
        }
        answer[0]=tot_cnt;
        answer[1]=count;
        return answer;
    }
}

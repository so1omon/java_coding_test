package 김성아;

import java.util.*;
public class delete_pair {
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.size()!=0){
                if(stack.peek()!=s.charAt(i)){
                    stack.push(s.charAt(i));
                }
                else
                    stack.pop();}
            else
                stack.push(s.charAt(i));
        }
        if(stack.empty())
            answer=1;

        return answer;
    }
}

package 김성아;

import java.util.*;
public class parenthesis_rotation {
    public int solution(String s) {
        int answer = 0;
        char ch;
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(i!=0){
                String temp=String.valueOf(s.charAt(0));
                s=s.substring(1);
                s+=temp;
                //System.out.println(s);
            }
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='}'){
                    if(!stack.empty()&&stack.peek()=='{')
                        stack.pop();
                    else
                        stack.push(s.charAt(j));
                }
                else if(s.charAt(j)==']'){
                    if(!stack.empty()&&stack.peek()=='[')
                        stack.pop();
                    else
                        stack.push(s.charAt(j));
                }
                else if(s.charAt(j)==')'){
                    if(!stack.empty()&&stack.peek()=='(')
                        stack.pop();
                    else
                        stack.push(s.charAt(j));
                }
                else{
                    stack.push(s.charAt(j));
                }
            }
            if(stack.empty())
                answer++;
            stack=new Stack<>();
        }


        return answer;
    }
}

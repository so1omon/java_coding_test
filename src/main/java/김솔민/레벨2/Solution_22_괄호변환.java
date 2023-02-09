package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * 2023/02/09
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_22_괄호변환 {
    public String solution(String p) {
        return recursive(p);
    }

    boolean isValidBracketString(String target){
        Stack<Character> stack = new Stack<>();

        for(char ch : target.toCharArray()){

            // '(' 이면 무조건 집어넣기
            if(ch=='('){
                stack.push(ch);
            }
            else{
                if(stack.empty() || stack.peek()!='('){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        if(stack.empty()){
            return true;
        }
        return false;
    }

    // v에 대한 재귀수행, 맨 처음에는 전체 문자열 넣기
    // 1. 올바른 괄호 문자열인지 판별, 맞다면 그대로 리턴 (함수 따로 만들기)
    // 2. u와 v로 분리, 맨 앞부터 괄호 갯수 세면서 0이 아닌 수로 동일해지면 멈추고 분리
    // 2-1. u가 올바른 괄호 문자열이라면, v에 대해 1단계부터 다시 수행해서 u에 붙인 결과물 리턴
    String recursive(String target){
        if(isValidBracketString(target)){
            return target;
        }

        int[] brackets= {0,0};
        // u,v 분리지점 (u의 맨 끝 인덱스)
        int sliceIdx = 0;
        for(int i=0;i<target.length();i++){
            if(target.charAt(i)=='('){
                brackets[0]++;
            }else{
                brackets[1]++;
            }
            if(brackets[0]==brackets[1]){
                sliceIdx = i;
                break;
            }
        }

        String u = target.substring(0, sliceIdx+1);
        String v = target.substring(sliceIdx+1);
        // System.out.println("u : "+u+" v : "+v);


        if(isValidBracketString(u)){
            return u + recursive(v);
        }else{
            // 3. 올바른 괄호 문자열이 아니라면, '('+ [v재귀수행] + ')' +
            //    [u의 첫번째, 마지막문자 제거 후 나머지 문자열 괄호 방향 뒤집기] 를 반환
            StringBuilder sb = new StringBuilder();

            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i)=='('){
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }
            return '(' + recursive(v) + ')' + sb.toString();

        }


    }
    public static void main(String[] args) {

    }
}

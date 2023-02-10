package 김성아.레벨2;
import java.util.*;
public class 스킬트리 {public int solution(String skill, String[] skill_trees) {
    int answer = 0;
    boolean[]arr=new boolean[26];
    for(int i=0;i<skill_trees.length;i++){
        Queue<Character>que=new LinkedList<>();
        for(int j=0;j<skill.length();j++){
            char ch=skill.charAt(j);
            arr[ch-65]=true;
            que.add(ch);
        }
        int j;
        for(j=0;j<skill_trees[i].length();j++){
            char temp=skill_trees[i].charAt(j);
            //System.out.println(que.peek());
            if(arr[temp-65]){
                if(que.peek()==temp){
                    que.poll();
                }
                else
                    break;
            }

        }
        if(j==skill_trees[i].length())
            answer++;
    }
    return answer;
}
}

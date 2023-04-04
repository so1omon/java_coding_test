package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;
class Practice_10 {
    public int solution(String begin, String target, String[] words) {
        int targetIdx = -1;
        for(int i=0;i<words.length;i++){
            if(target.equals(words[i])){
                targetIdx=i;
                break;
            }
        }
        if(targetIdx==-1){
            return 0;
        }


        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int cnt = 1;

        while(true){
            boolean[] visited = new boolean[words.length];
            List<String> list = new ArrayList<>();
            while(!q.isEmpty()){
                list.add(q.poll());
            }

            for(String s : list){
                for(int i=0;i<words.length;i++){
                    if(!visited[i] && can(s, words[i])){
                        if(i==targetIdx){
                            return cnt;
                        }
                        visited[i] = true;
                        q.add(words[i]);
                    }
                }
            }

            cnt++;
        }

    }

    boolean can(String origin, String comp){
        int cnt=0;
        for(int i=0;i<origin.length();i++){
            if(origin.charAt(i)!=comp.charAt(i)){
                if(cnt==1){
                    return false;
                }
                cnt++;
            }
        }
        return true;
    }
}
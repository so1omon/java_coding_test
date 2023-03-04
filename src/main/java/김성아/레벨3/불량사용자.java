package 김성아.레벨3;
import java.util.*;
public class 불량사용자 {
    Set<Set<String>>answer;
    public int solution(String[] user_id, String[] banned_id) {
        answer=new HashSet<>();
        Set<String>dup_check=new LinkedHashSet<>();
        dfs(dup_check,user_id,banned_id);
        return answer.size();
    }
    private void dfs(Set<String>dup_check,String[] user_id,String[]banned_id){
        if(dup_check.size()==banned_id.length){
            if(isBanList(dup_check,banned_id))
                answer.add(new HashSet<>(dup_check));
            return;
        }
        for(int i=0;i<user_id.length;i++){
            if(dup_check.add(user_id[i])){
                dfs(dup_check,user_id,banned_id);
                dup_check.remove(user_id[i]);}
        }
    }
    private boolean isBanList(Set<String>set,String[]banned_id){
        int index=0;
        for(String set_id:set){
            String ban_id=banned_id[index++];
            if(set_id.length()!=ban_id.length())
                return false;
            for(int k=0;k<ban_id.length();k++){
                if(ban_id.charAt(k)=='*')
                    continue;
                else if(ban_id.charAt(k)!=set_id.charAt(k))
                    return false;
            }
        }
        return true;
    }
}

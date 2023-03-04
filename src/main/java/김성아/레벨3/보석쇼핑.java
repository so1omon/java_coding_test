package 김성아.레벨3;
import java.util.*;
public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer =new int[2];
        Set<String>set=new HashSet<>();
        for(int i=0;i<gems.length;i++){
            set.add(gems[i]);
        }
        int min=100000000;
        int end_i=0;
        int start_i=0;
        int gem_len=set.size();
        set.clear();
        int i=start_i;
        while(i<gems.length){
            set.add(gems[i]);
            if(set.size()==gem_len){
                end_i=i;
                set.clear();
                for(int j=end_i;j>=start_i;j--){
                    set.add(gems[j]);
                    if(set.size()==gem_len){
                        start_i=j;
                        if(min>end_i-start_i){
                            min=end_i-start_i;
                            answer[0]=start_i+1;
                            answer[1]=end_i+1;
                        }
                        i=start_i;
                        set.clear();
                        break;
                    }
                }
            }
            i++;
        }
        return answer;
    }
}

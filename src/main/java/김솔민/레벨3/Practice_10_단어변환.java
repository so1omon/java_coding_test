package 김솔민.레벨3;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * Solution using
 * 2023/03/10
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_10_단어변환 {
    public int solution(String begin, String target, String[] words) {

        List<String> temp = Arrays.asList(words);
        if(temp.indexOf(target)==-1){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(begin);

        int min = 0;

        while(!q.isEmpty()){

            Set<String> set = new HashSet<>();

            while(!q.isEmpty()){
                set.add(q.poll());
            }

            for(String elem : set){
                if(elem.equals(target)){
                    return min;
                }else{
                    for(String t : temp){
                        if(isOneAlphabetDif(elem, t)==1){
                            q.add(t);
                        }
                    }
                }
            }
            min++;
        }


        if(min == Integer.MAX_VALUE ) return 0;
        return min;
    }

    public int isOneAlphabetDif(String s1, String s2){
        int diff = 0;
        if (s1.equals(s2)){
            return diff;
        }

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
        }
        return diff;
    }
}

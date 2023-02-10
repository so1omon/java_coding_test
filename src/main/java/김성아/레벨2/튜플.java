package 김성아.레벨2;

import java.util.*;
public class 튜플 {
    public int[] solution(String s) {
        int[] answer;
        HashMap<Integer,Integer>map=new HashMap<>();
        s=s.substring(2,s.length()-2);
        s=s.replace("},{","-");
        String[] s_split=s.split("-");
        for(String str:s_split){
            String ch_arr[]=str.split(",");
            for(int i=0;i<ch_arr.length;i++){
                int ch_i=Integer.valueOf(ch_arr[i]);
                if(map.get(ch_i)!=null){
                    map.put(ch_i,map.get(ch_i)+1);
                }
                else
                    map.put(ch_i,0);
            }
        }
        int index=0;
        int ans_temp[]=new int[map.size()];
        answer=new int[map.size()];
        for(int key:map.keySet()){
            ans_temp[map.get(key)]=key;
        }
        for(int i=0;i<map.size();i++){
            answer[i]=ans_temp[map.size()-1-i];
        }
        return answer;
    }
}

package 김성아.레벨2;
import java.util.*;
public class 방금그곡3차 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        Map<Integer,String>map=new HashMap<>();
        for(int i=0;i<musicinfos.length;i++){
            String[]temp=musicinfos[i].split(",");
            String[]time1=temp[0].split(":");
            String[]time2=temp[1].split(":");
            int hour1=Integer.parseInt(time2[0]);
            int min1=Integer.parseInt(time2[1]);
            int d1=hour1*60+min1;
            int hour2=Integer.parseInt(time1[0]);
            int min2=Integer.parseInt(time1[1]);
            int d2=hour2*60+min2;
            int tot_time=d1-d2;
            int music_len=temp[3].replace("#","").length();
            int melody_len=m.replace("#","").length();
            if(music_len<tot_time){
                int index=0;
                int add_len=tot_time-music_len;
                for(int j=0;j<add_len;j++){
                    temp[3]+=temp[3].charAt(index++);
                    if(index<temp[3].length()){
                        if(temp[3].charAt(index)=='#'){
                            temp[3]+=temp[3].charAt(index++);
                        }
                    }
                }
            }
            else{
                int cnt=0;
                for(int j=0;j<temp[3].length();j++){
                    if(temp[3].charAt(j)=='#')
                        continue;
                    else
                        cnt++;
                    if(cnt==tot_time){
                        if(temp[3].length()>j+1&&temp[3].charAt(j+1)=='#')
                            temp[3]=temp[3].substring(0,j+2);
                        else
                            temp[3]=temp[3].substring(0,j+1);
                        break;
                    }
                }
            }
            for(int j=0;j<temp[3].length();j++){
                if(temp[3].charAt(j)==m.charAt(0)){
                    if(temp[3].length()-j<m.length())
                        break;
                    else{
                        String s=temp[3].substring(j,j+m.length());
                        if(temp[3].length()>j+m.length()&&temp[3].charAt(j+m.length())=='#')
                            continue;
                        if(s.equals(m)){
                            if(map.get(tot_time)==null){
                                map.put(tot_time,temp[2]);}
                            break;
                        }
                    }
                }
            }
            if(!map.isEmpty()){
                for(int key:map.keySet()){
                    answer=map.get(key);
                }}
        }
        return answer;
    }
}

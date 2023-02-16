package 김성아.레벨2;
import java.util.*;
public class 방금그곡3차 {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int max_t = -1;
        for(int i=0;i<musicinfos.length;i++) {
            String[] temp = musicinfos[i].split(",");
            String[] time1 = temp[0].split(":");
            String[] time2 = temp[1].split(":");
            int hour1 = Integer.parseInt(time2[0]);
            int min1 = Integer.parseInt(time2[1]);
            int d1 = hour1 * 60 + min1;
            int hour2 = Integer.parseInt(time1[0]);
            int min2 = Integer.parseInt(time1[1]);
            int d2 = hour2 * 60 + min2;
            int tot_time = d1 - d2;

            //System.out.println(tot_time);
            temp[3] = convert(temp[3]);
            m = convert(m);
            //재생시간<=악보길이
            if (tot_time <= temp[3].length()) {
                temp[3] = temp[3].substring(0, tot_time);
            }
            //악보길이<재생시간
            else {
                int add_len = tot_time - temp[3].length();
                for (int j = 0; j < add_len; j++) {
                    temp[3] += temp[3].charAt(j);
                }
            }
            int music_len = tot_time;
            int m_len = m.length();
            //악보,음 대조
            if(temp[3].contains(m)&&max_t<tot_time){
                answer=temp[2];
                max_t=tot_time;
            }
        }
        return max_t!=-1 ? answer:"(None)";
    }
    public String convert(String str){
        str=str.replaceAll("C#","c");
        str=str.replaceAll("D#","d");
        str=str.replaceAll("F#","f");
        str=str.replaceAll("G#","g");
        str=str.replaceAll("A#","a");
        return str;
    }
}

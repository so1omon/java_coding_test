package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72414
 * Solution using
 * 2023/03/21
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.ArrayList;
import java.util.List;

class Solution_15_광고_삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        if(play_time.equals(adv_time)){
            return "00:00:00";
        }

        int MAX_SIZE = timeToInt(play_time)+1;
        int[] watched = new int[MAX_SIZE];
        for(String log : logs){
            String[] split = log.split("-");
            int startIdx = timeToInt(split[0]);
            int endIdx = timeToInt(split[1]);
            watched[startIdx]++;
            if(endIdx!=MAX_SIZE){
                watched[endIdx]--;
            }
        }

        for(int i=1;i<watched.length;i++){
            watched[i] += watched[i-1];
        }

        int max_idx = 0;
        long max_value = 0;
        int capacity = timeToInt(adv_time);
        long temp_amount = 0;

        for(int i=0;i<capacity;i++){
            temp_amount+=watched[i];
        }

        max_value = temp_amount;

        for(int i=0;i<watched.length-capacity;i++){
            temp_amount += watched[i+capacity]-watched[i];
            if (temp_amount > max_value){
                max_value = temp_amount;
                max_idx = i+1;
            }
        }


        return intToTime(max_idx);
    }

    int timeToInt(String time){
        String[] split = time.split(":");

        // 수정 가능
        return Integer.parseInt(split[0])*60*60 +
            Integer.parseInt(split[1])*60 +
            Integer.parseInt(split[2]);
    }

    String intToTime(int time){
        String result = "";
        int hour = time/3600;
        int minute = (time%3600)/60;
        int second = time%60;
        if(hour<10){
            result+='0' + String.valueOf(hour);
        }else{
            result+=String.valueOf(hour);
        }
        result+=':';
        if(minute<10){
            result+='0' + String.valueOf(minute);
        }else{
            result+=String.valueOf(minute);
        }
        result+=':';
        if(second<10){
            result+='0' + String.valueOf(second);
        }else{
            result+=String.valueOf(second);
        }

        return result;
    }

}

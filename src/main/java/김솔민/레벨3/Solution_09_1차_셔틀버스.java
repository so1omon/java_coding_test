package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17678
 * Solution using
 * 2023/03/13
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Solution_09_1차_셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        String curTime = "09:00";
        // 1. timetable 정렬
        Arrays.sort(timetable);

        // 2. n의 수만큼 09:00부터 시작해서 대기열을 만들기
        Map<String, Stack<String>> map = new HashMap<>();
        String[] timeArr = new String[n];
        timeArr[0] = curTime;
        map.put(curTime, new Stack<>());
        for(int i=1;i<n;i++){
            String key = addTime(curTime, t);
            map.put(key, new Stack<>());
            timeArr[i] = key;
            curTime = key;
        }



        int cur = 0;
        for(String time : timetable){
            // 매칭되는 대기열을 찾기
            while(cur<n){
                if(time.compareTo(timeArr[cur])<=0){
                    Stack<String> st = map.get(timeArr[cur]);
                    st.push(time);
                    if(st.size()==m){
                        cur++;
                    }
                    break;
                }else{
                    cur++;
                }
            }
            if(cur==n){
                break;
            }
        }
        // 3. 맨 뒤에 오는 셔틀버스 시간부터 비교
        // 3-1. 대기열이 꽉 차지 않음 : 버스 오는 시간 딱 맞춰서 타기
        // 3-2. 대기열이 꽉 찼을 때 : 대기열 뒤쪽부터 차례로 버스 오는 시간 딱 맞추지 않은 사람들을 체크, 있다면 해당 사람이 온 시간보다 늦게 오고 그 전 대기열 인원보다 빨리 오는 시간대로 바꿔서 타기
        // 3-3. 끝까지 다 탐색해도 자리가 나지 않을 때 : timetable의 가장 먼저 온 사람보다 일찍 오기
        cur = n-1;
        Stack<String> st = map.get(timeArr[cur]);
        if(st.size()<m){
            return timeArr[cur];
        }else{
            String min = st.pop();
            return addTime(min, -1);
        }
    }

    int[] strHourToArr(String str){
        return new int[]{
            Integer.parseInt(str.substring(0,2)),
            Integer.parseInt(str.substring(3))};
    }

    // 자릿수를 맞춰 놓으면 시간 비교하는 함수를 따로 만들 이유 없음
    String addTime(String str, int min){
        int[] time = strHourToArr(str);

        time[1] += min;
        if(time[1]>=60){
            time[0]++;
            time[1]-=60;
        }else if(time[1]<0){
            time[0]--;
            time[1]+=60;
        }

        String hour =
            time[0]<10?"0"+String.valueOf(time[0]):String.valueOf(time[0]);
        String minute =
            time[1]<10?"0"+String.valueOf(time[1]):String.valueOf(time[1]);

        return hour + ":" + minute;
    }
}

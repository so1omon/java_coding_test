package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60059
 * Solution using
 * 2023/04/06
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.*;

class Solution_10 {
    class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            int answer = 0;
            int time = hhmmToTime("09:00");
            Map<Integer, List<Integer>> map = new HashMap<>();

            for(int i=0;i<n;i++){
                map.put(time+(i*t) ,new ArrayList<>());
            }

            List<Integer> key = new ArrayList<>(map.keySet());
            Collections.sort(key);
            Arrays.sort(timetable);

            int ptr = 0;
            for(String s : timetable){
                int target = hhmmToTime(s);
                int targetKey = key.get(ptr);

                while(!(target<=targetKey && map.get(targetKey).size()<m)){
                    ptr++;
                    if(ptr>=n){
                        break;
                    }
                    targetKey = key.get(ptr);
                }
                if(ptr>=n){
                    break;
                }
                map.get(targetKey).add(target);
            }


            List<Integer> busStop = map.get(key.get(n-1));
            if(busStop.size()!=m){
                return timeToHHMM(key.get(n-1));
            }else{
                return timeToHHMM(busStop.get(m-1)-1);
            }

        }

        int hhmmToTime(String s){
            return Integer.parseInt(s.substring(0,2))*60 +
                Integer.parseInt(s.substring(3));
        }

        String timeToHHMM(int answer){
            String hour = String.valueOf(answer/60);
            hour = hour.length()==1?"0"+hour:hour;

            String minute = String.valueOf(answer%60);
            minute = minute.length()==1?"0"+minute:minute;

            return hour+":"+minute;
        }

    }
}
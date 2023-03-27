package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17676
 * 2023/03/27
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;

class Solution_23_1차_추석_트래픽 {
    public int solution(String[] lines) {
        int answer = 0;
        int MAX_TIME = 86400000;
        List<int[]> inputs = new ArrayList<>();

        for(String line : lines){
            String[] split = line.split(" ");
            int[] result = intervalToMilliSeconds(split[1], split[2]);
            inputs.add(result);
        }
        int max = 0;
        // 맨앞에꺼 하나 빼고, 다시 넣으면서 최대 개수 갱신
        for(int i=0;i<inputs.size();i++){
            int cnt = 1;

            for(int j=i+1;j<inputs.size();j++){
                if(inputs.get(j)[0] < inputs.get(i)[1]+1000){
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }



        return max;
    }

    int[] intervalToMilliSeconds(String start, String time){
        int[] millies = new int[]{0,0};

        String[] split =  start.split(":");
        millies[1]+=Integer.parseInt(split[0])*1000*60*60;
        millies[1]+=Integer.parseInt(split[1])*1000*60;

        millies[1]+=(int)(Double.valueOf(split[2])*1000);

        String[] split_3 = time.split("s");
        millies[0] = millies[1] - ((int)(Double.valueOf(split_3[0])*1000)) +1;

        return millies;
    }

}

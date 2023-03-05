package 김솔민.레벨3;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * Solution using
 * 2023/03/05
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_05_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<int[]>> map = new HashMap<>();
        Map<String, Integer> playsMap = new HashMap<>();
        int[] answer = new int[plays.length];
        int cnt = 0;

        for(int i=0;i<genres.length;i++){
            int[] target = {i, plays[i]};

            List<int[]> list = map.getOrDefault(genres[i], new ArrayList<>());

            list.add(target);
            map.put(genres[i], list);
            playsMap.put(
                genres[i], playsMap.getOrDefault(genres[i], 0)+plays[i]);
        }

        List<String> genreList = new ArrayList<>(playsMap.keySet());

        genreList.sort((s1, s2)->{
            return playsMap.get(s2) - playsMap.get(s1);
        });

        for(String key : genreList){
            List<int[]> target = map.get(key);

            target.sort((a, b)->{
                if(a[1]==b[1]){
                    return a[0]-b[0];
                }
                return b[1]-a[1];
            });

            if(target.size()==1){
                answer[cnt++] = target.get(0)[0];
            }else{
                answer[cnt++] = target.get(0)[0];
                answer[cnt++] = target.get(1)[0];
            }

        }

        return Arrays.copyOfRange(answer, 0, cnt);
    }
}

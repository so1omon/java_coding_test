package 김솔민.레벨3복습;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 * Solution using
 * 2023/04/04
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;
class Practice_05 {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        Map<String, List<Song>> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();

        for(int i=0;i<len;i++){
            List<Song> list = map.getOrDefault(genres[i], new ArrayList<>());
            list.add(new Song(i, plays[i]));
            total.put(genres[i], total.getOrDefault(genres[i], 0)+plays[i]);
            map.put(genres[i], list);
        }

        List<String> keyList = new ArrayList<>(total.keySet());
        keyList.sort((key1, key2)->total.get(key2) - total.get(key1));

        List<Integer> answerList = new ArrayList<>();

        for(String key : keyList){
            List<Song> target = map.get(key);
            target.sort((s1, s2)->{
                if(s1.play == s2.play){
                    return s1.idx - s2.idx;
                }
                return s2.play-s1.play;
            });
            answerList.add(target.get(0).idx);
            if(target.size()>=2){
                answerList.add(target.get(1).idx);
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
    class Song{
        int idx;
        int play;
        Song(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
    }
}

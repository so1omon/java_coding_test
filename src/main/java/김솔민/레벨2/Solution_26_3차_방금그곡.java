package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17683
 * Solution using
 * 2023/02/11
 *
 *
 * <Memo>
 *   Stringbuilder 길이 : sb.length();
 *   Stringbuilder 초기화 : sb.delete(0, sb.length());
 * </Memo>
 */
class Solution_26_3차_방금그곡 {
    StringBuilder sb = new StringBuilder();
    public String solution(String m, String[] musicInfos) {
        List<Music> answer = new ArrayList<>();
        m = convert(m);
        // 1. musicInfos 안에 있는 음을 음악 재생길이만큼 늘리기


        for(int i=0;i<musicInfos.length;i++){ // i = seq

            String[] musicInfo = musicInfos[i].split(",");
            // #음을 소문자로 변환해서 처리
            String[] startTime = musicInfo[0].split(":"); // hh:mm
            String[] endTime = musicInfo[1].split(":");// hh:mm
            int playTime =
                (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]))*60
                    + (Integer.parseInt(endTime[1])-Integer.parseInt(startTime[1]));

            String detail = convert(musicInfo[3]);
            sb.delete(0, sb.length());
            // playTime만큼 늘리기
            for(int j=0;j<playTime/detail.length();j++){
                sb.append(detail);
            }
            for(int j=0;j<playTime%detail.length();j++){
                sb.append(detail.charAt(j));
            }
            String result = sb.toString();

            // 2. 늘린 음 안에서 m을 찾기 (indexOf)
            // 3. 2번의 결과값이 -1이 아니라면, 정답에 넣기

            if(result.indexOf(m)!=-1){
                answer.add(new Music(playTime, i, musicInfo[2]));
            }
        }

        answer.sort(new Comparator<Music>(){
            @Override
            public int compare(Music m1, Music m2){
                int playTimeGap = m2.playTime-m1.playTime;

                if(playTimeGap!=0){
                    return playTimeGap;
                }else{
                    return m1.seq - m2.seq;
                }
            }
        });


        // 3-1. 정답에 넣은 값들을 정렬 (재생 시간 > 먼저 입력된 음악)
        // 3-2. 가장 첫 요소를 리턴
        if(answer.size()==0){
            return "(None)";
        }else{
            return answer.get(0).musicName;
        }

    }
    class Music{
        int playTime;
        int seq;
        String musicName;
        public Music(int playTime, int seq, String musicName){
            this.playTime = playTime;
            this.seq = seq;
            this.musicName = musicName;
        }

        @Override
        public String toString(){
            return this.musicName + " " + this.playTime + " " + this.seq;
        }
    }

    String convert(String str){
        sb.delete(0, sb.length());
        for(int i=0;i<str.length();i++){
            char target = str.charAt(i);
            if(target=='#'){
                sb.deleteCharAt(sb.length()-1);
                sb.append(Character.toLowerCase(str.charAt(i-1)));
            }else sb.append(target);

        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}

package 김솔민.레벨2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * Solution using Map
 * 2023/01/29
 *
 *
 * <Memo>
 *   Map.containsKey(key) : 키 존재 여부 확인, boolean 리턴
 *   Map<S,T> map = new HashMap<>(기존 맵) : 기존 맵 깊은 복사
 *   cf)
 *      set1.retainAll(set2) : 교집합
 *      set1.addAll(set2) : 합집합
 *      set1.removeAll(set2) : 차집합
 * </Memo>
 */
class Solution_03_뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;

        //1. 두 개의 집합을 생성
        Map<String, Integer> set1 = split(str1);
        Map<String, Integer> set2 = split(str2);

        //교집합
        Map<String, Integer> commonSet = new HashMap<>(set1);
        int common = 0;
        for(String key : set2.keySet()){

            //만약 해당 키가 존재하면 최솟값으로 세팅
            if(commonSet.containsKey(key)){
                common+=Math.min(commonSet.get(key), set2.get(key));
            }
        }

        //합집합
        Map<String, Integer> plusSet = new HashMap<>(set1);
        int plus = 0;
        for(String key : set2.keySet()){
            //만약 해당 키가 존재하면 최댓값으로 세팅, 아니면 그냥 추가
            if(plusSet.containsKey(key)){
                plusSet.put(key, Math.max(plusSet.get(key), set2.get(key)));
            }else{
                plusSet.put(key, set2.get(key));
            }
        }

        for(int value : plusSet.values()){
            plus+=value;
        }

        if(plus==0){
            return 65536;
        }
        return (int)Math.floor((float)common*65536/(float)plus);
    }

    //2. str1, str2를 두 개씩 나누면서 각각의 set에 더하되,
    //두개의 문자 모두 영문자가 아닌 경우, set에 포함시키지 않는다.
    public  Map<String, Integer> split(String str){
        Map<String, Integer> map = new HashMap();

        for(int i=0;i<str.length()-1;i++){
            String substr = "";
            if(i==str.length()-2){
                substr = str.substring(i);
            }else{
                substr = str.substring(i, i+2);
            }
            boolean flag = false;
            for(char ch : substr.toCharArray()){
                //영문자가 아닌 경우 판별
                if ((ch -  'a' < 0 || 'z' - ch <0)
                    && (ch -  'A' < 0 || 'Z' - ch <0)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                String target = substr.toUpperCase();
                map.put(target, map.getOrDefault(target, 0)+1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        Solution_03_뉴스_클러스터링 solution03_뉴스_클러스터링 = new Solution_03_뉴스_클러스터링();
        String str1 = "FRANCE";
        String str2 = "french";

        System.out.println(solution03_뉴스_클러스터링.solution(str1, str2));
    }
}

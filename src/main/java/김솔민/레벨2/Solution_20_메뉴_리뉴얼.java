package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * 2023/02/08
 *
 *
 * <Memo>
 *   combination 돌리는 전략
 *      1. Object : 조합 돌리려는 대상 객체
 *      2. depth(초기값:뽑을 수): 현재까지 뽑은 갯수, 조합 시 하나씩 줄여나가기
 *      3. r : 현재 인덱스
 *      4. n : Object의 길이
 *      5. depth == 0이면 무조건 다 뽑았다고 판단하고 로직 실행
 *      6. r이 n을 벗어나는 값으로 바뀌면 리턴
 *      7. 로직실행
 *          7-1. r번째 요소를 뽑지 않았을 때의 재귀함수 실행
 *          7-2. r번째 요소를 뽑았을 때의 재귀함수 실행
 *
 *   Collections.max(min) 함수 사용 시 주의점:
 *      Collection이 비었으면 에러 반환함
 * </Memo>
 */
class Solution_20_메뉴_리뉴얼 {
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        // 0. course 돌기

        for(int c : course){
            // 1. 메뉴 구성 Map 생성
            Map<String, Integer> menus = new HashMap<>();
            // 2. course의 수만큼 각각의 orders에서 조합할 수 있는 경우의 수를 Map에 넣기
            // 2-1. key = 조합, value = 조합수
            for(String order : orders){
                //   void comb(Map<String, Integer> map, String target,
                // String temp, int n, int r, int depth){
                comb(menus, order, "", order.length(), 0, c);
            }

            // 3. value의 최댓값 구하고, 2 이하면 끝
            if(menus.size()==0){
                continue;
            }

            Integer maxValue =  Collections.max(menus.values());

            if(maxValue<2){
                continue;
            }
            // 3-1. Map을 순회하면서 value로 최댓값을 가지는 애들을 전부 다 result에 넣기
            for(String key : menus.keySet()){
                if(menus.get(key)==maxValue){
                    list.add(key);
                }
            }
        }
        // 4. 반복문 종료 후 result를 사전순으로 정렬
        list.sort(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2);
            }
        });

        String[] result = new String[list.size()];
        int count=0;
        for(String s : list){
            result[count++]=s;
        }

        return result;
    }

    // 조합 구현
    void comb(Map<String, Integer> map, String target,
              String temp, int n, int r, int depth){
        if(depth==0){
            char[] charr = temp.toCharArray();
            Arrays.sort(charr);
            temp = String.valueOf(charr);
            map.put(temp, map.getOrDefault(temp, 0)+1);
            return;
        }
        if(r==n){
            return;
        }

        comb(map, target, temp, n, r+1, depth);
        temp+=target.charAt(r);
        comb(map, target, temp, n, r+1, depth-1);

    }

    public static void main(String[] args) {

    }
}

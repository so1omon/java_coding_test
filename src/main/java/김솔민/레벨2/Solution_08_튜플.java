package 김솔민.레벨2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 * Solution using
 * 2023/02/01
 *
 *
 * <Memo>
 *   cf) Map iteration
 *         방법1 : keySet list를 iterate
 *
 *         Iterator<String> keys = map.keySet().iterator();
 *         while( keys.hasNext() ){
 *             String key = keys.next();
 *             System.out.println( String.format("키 : %s, 값 : %s", key, map.get(key)) );
 *         }
 *
 *         방법2 : map.entrySet()으로 전체 item iterate
 *         for( Map.Entry<String, String> elem : map.entrySet() ){
 *             System.out.println( String.format("키 : %s, 값 : %s", elem.getKey(), elem.getValue()) );
 *         }
 *   cf) String[] 정렬 (길이순)
 *      String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
 *
 *      Arrays.sort(arr, new Comparator<String>() {
 *          @Override
 *          public int compare(String s1, String s2) {
 *              return s1.length() - s2.length();
 *          }
 *      });
 *      -> override한 compare method에서, [조건] 오름차순으로 정렬하려면
 *         parameter로 받은 두 개의 인자 중 먼저 받은 인자를 우선순위가 높다고 가정하고, 조건에 따라서 양수를 반환해야 함
 *         예를 들어, 숫자 크기 오름차순으로 정렬하고 싶으면
 *         @Override
 *         public int compare(int num1, int num2){
 *              return num1-num2; -> num1을 크기가 크다고 가정했기 때문에 해당 로직을 통해 양수를 반환
 *         }
 *   cf) Map 정렬
 *         https://codechacha.com/ko/java-sort-map/
 *
 *         Value 값으로 오름차순 정렬
 *         List<String> keySet = new ArrayList<>(map.keySet());
 *         keySet.sort(new Comparator<String>() {
 *             @Override
 *             public int compare(String o1, String o2) {
 *                 return map.get(o1).compareTo(map.get(o2));
 *             }
 *         });
 *
 *         for (String key : keySet) {
 *             System.out.print("Key : " + key);
 *             System.out.println(", Val : " + map.get(key));
 *         }
 *
 *   cf) List 초기화
 *      List<Integer> list = Arrays.asList(1,2,3,232,12,459);
 *      List<Integer> list = List.of(1,2,3,232,12,459); [주의!! 불변객체 생성]
 *
 * </Memo>
 */
class Solution_08_튜플 {
    public int[] solution(String s) {


        // 무조건 다른 효율적인 답안 다시 보기

        // 0. 숫자 저장할 수 있는 map 생성
        Map<Integer, Integer> map = new HashMap<>();
        // 1. 양 끝을 제거
        s = s.substring(2, s.length()-2);
        for(String splitted : s.split("\\},\\{")){
            for (String splittedTwice : splitted.split(",")){
                int target = Integer.parseInt(splittedTwice);
                map.put(target, map.getOrDefault(target, 0)+1);
            }
        }

        int[] answer = new int[map.values().size()];
        for(Integer key : map.keySet()){
            answer[answer.length-map.get(key)] = key;
        }


        return answer;
    }

    public static void main(String[] args) {
        String s ="{{2},{2,1},{2,1,3},{2,1,3,4}}"	;
        Solution_08_튜플 solution08_튜플 = new Solution_08_튜플();

        System.out.println(solution08_튜플.solution(s));

    }
}

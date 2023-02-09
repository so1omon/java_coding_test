package 김솔민;

import java.util.*;

class Test {
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
            for(Map.Entry<String, Integer> entry : menus.entrySet()){
                System.out.println("조합: "+entry.getKey() + " 개수 : "+entry.getValue());
            }

            // 3. value의 최댓값 구하고, 2 이하면 끝
            Integer maxValue =  Collections.max(menus.values());


            if(maxValue<=2){
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
        String a = "123";
        System.out.println(a.substring(3));
        Stack<Integer> stack = new Stack<>();


    }
}

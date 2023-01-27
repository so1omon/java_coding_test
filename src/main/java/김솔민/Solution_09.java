package 김솔민;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72412
 * Solution using split, join, hashMap, binary sesarch
 * 2023/01/04
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_09 {
    public void solution(String[] info, String[] query) {
//        int[] result = new int[query.length];
        List<Integer> result = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

        for(String i: info){
            String[] data = i.split(" ");

            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] exps = {data[2], "-"};
            String[] foods = {data[3], "-"};
            Integer value = Integer.parseInt(data[4]);

            for (String lang:languages){
                for (String job : jobs){
                    for (String exp : exps){
                        for (String food: foods){
                            String[] keyData = {lang, job, exp, food};
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> values = hashMap.getOrDefault(key, new ArrayList<>());
                            values.add(value);
                            hashMap.put(key, values);
                        }
                    }
                }
            }
        }

        for(ArrayList<Integer> values : hashMap.values()){
            values.sort(null);
        }

        int[] answer = new int[query.length];
        int i=0;

        for (String q:query){
            String[] data = q.split(" and ");
            int value = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];

            String key = String.join(" ", data);

            if(hashMap.containsKey(key)){
                ArrayList<Integer> values = hashMap.get(key);

                int left=0, right=values.size();

                while(left<right){
                    int mid = (left + right)/2;
                    if(values.get(mid)<value){
                        left = mid+1;
                    }else{
                        right=mid;
                    }
                }

                answer[i] = values.size()-left;
            }
            i++;
        }

        for(int a : answer){
            System.out.print(a + " ");
        }

    }

    public static void main(String[] args) {
        Solution_09 solution09 = new Solution_09();
        String[] info ={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        solution09.solution(info, query);
    }
}

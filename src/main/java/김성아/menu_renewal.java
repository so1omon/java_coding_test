package 김성아;
import java.util.*;
public class menu_renewal {
    String []answer={};
    Map<String,Integer>map=new HashMap<>();
    List<String>list=new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        //order정렬
        for(int i=0;i<orders.length;i++){
            String order=orders[i];
            char[] arr=order.toCharArray();
            Arrays.sort(arr);
            orders[i]=String.valueOf(arr);
        }
        //코스에 들어있는 수만큼 분할 combination함수 사용
        for(int i=0;i<course.length;i++){
            for(String order:orders){
                combination("",order,course[i]);
            }
            if(!map.isEmpty()){
                List<Integer>arr=new ArrayList<>(map.values());
                int max=Collections.max(arr);
                //가장 큰값 찾기
                if(max>1){
                    for(String key:map.keySet()){
                        if(map.get(key)==max)
                            list.add(key);
                    }
                }
                map.clear();
            }
        }
        //result에 담기
        answer=new String[list.size()];
        Collections.sort(list);
        for(int j=0;j<list.size();j++){
            answer[j]=list.get(j);
        }
        return answer;
    }
    public void combination(String order,String others,int count){
        if(count==0){
            //System.out.println(map.get(order));
            map.put(order,map.getOrDefault(order,0)+1);}
        else{
            for(int i=0;i<others.length();i++){
                //System.out.println(order+others.charAt(i));
                combination(order+others.charAt(i),others.substring(i+1),count-1);
            }
        }
    }
}

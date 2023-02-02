package 김성아;
import java.util.*;
public class compression {
    public int[] solution(String msg) {
        int[] answer;
        List<Integer>list=new ArrayList<>();
        Map<String,Integer>map=new HashMap<>();
        int voca_ind=27;//단어 저장 시작 번호
        for(int i=1;i<27;i++){
            map.put(String.valueOf((char)(64+i)),i);
        }
        int temp=0;//현재입력 인덱스 저장
        int index=0;//msg에서 몇번째 인덱스 참조하고 있는지 저장
        String str="";//현재입력+다음글자 저장

        while(index<msg.length()){
            str+=String.valueOf(msg.charAt(index));
            if(map.get(str)==null){
                map.put(str,voca_ind++);
                list.add(temp);
                str="";
            }
            else{
                temp=map.get(str);
                index++;
            }
        }
        list.add(temp);
        answer=list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

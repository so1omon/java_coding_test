package 김성아;
import java.util.*;
public class open_chatting_room {
    public String[] solution(String[] record) {
        int cnt=0;
        String []str;
        String[]answer=new String[record.length];
        for(int i=0;i<answer.length;i++)
            answer[i]="";
        Map<String,String>map=new HashMap<>();
        for(int i=0;i<record.length;i++){
            str=record[i].split(" ");
            if(str.length==3){
                map.put(str[1],str[2]);
            }
        }
        for(int i=0;i<record.length;i++){
            str=record[i].split(" ");
            if(str[0].equals("Enter")){
                answer[i]+= map.get(str[1]);
                answer[i]+="님이 들어왔습니다.";
            }
            else if(str[0].equals("Leave")){
                answer[i]+=map.get(str[1]);
                answer[i]+="님이 나갔습니다.";
            }
            else
                cnt++;
        }
        String[]arr=new String[answer.length-cnt];
        int index=0;
        for(int i=0;i<answer.length;i++){
            if(answer[i]=="")
                continue;
            else{
                arr[index++]=answer[i];}
        }
        return arr;
    }
}

package 김성아;

import java.util.*;
public class friends_4_block {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int cnt=0;
        List<List<Character>>list=new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--)
                list.get(i).add(board[j].charAt(i));
        }
        while(true){
            for(int i=0;i<n-1;i++){
                int min=Math.min(list.get(i).size(),list.get(i+1).size());
                for(int j=0;j<min-1;j++){
                    char ch_u=Character.toUpperCase(list.get(i).get(j));
                    char ch_l=Character.toLowerCase(ch_u);
                    char ch_u_1=Character.toUpperCase(list.get(i).get(j+1));
                    char ch_u_2=Character.toUpperCase(list.get(i+1).get(j+1));
                    char ch_u_3=Character.toUpperCase(list.get(i+1).get(j));
                    if((ch_u==ch_u_1&&
                            ch_u==ch_u_2)&&ch_u==ch_u_3){
                        list.get(i).set(j,ch_l);
                        list.get(i).set(j+1,ch_l);
                        list.get(i+1).set(j,ch_l);
                        list.get(i+1).set(j+1,ch_l);
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<list.get(i).size();j++){
                    if(list.get(i).get(j)>'Z'){
                        list.get(i).remove(j);
                        cnt++;
                    }
                }
            }
            if(cnt==0)
                break;
            answer+=cnt;
            cnt=0;}
        return answer;
    }
}

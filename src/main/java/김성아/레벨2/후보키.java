package 김성아.레벨2;
import java.util.*;
public class 후보키 {
    List<String>list;
    boolean[]check;
    List<String>list1;
    public int solution(String[][] relation) {
        list=new ArrayList<>();
        list1=new ArrayList<>();
        int answer = 0;
        int column_len=relation[0].length;
        check=new boolean[column_len];
        //개수별로 조합 만들기
        for(int i=column_len;i>0;i--){
            combination(column_len,i,0,0);
        }
        //dup_check함수로 유일성 체크
        for(int i=0;i<list.size();i++){
            //유일성 보장되면
            if(dup_check(list.get(i),relation)){
                //최소성 만족하는지 판단
                int j=0;
                while(j<list1.size()){
                    int cnt=0;
                    for(int k=0;k<list.get(i).length();k++){
                        if(list1.get(j).contains(String.valueOf(list.get(i).charAt(k))))
                            cnt++;
                    }
                    if(cnt==list.get(i).length())
                        list1.remove(j);
                    else
                        j++;
                }
                list1.add(list.get(i));
            }
        }
        for(int i=0;i<list1.size();i++)
            System.out.println(list1.get(i));
        answer=list1.size();
        return answer;
    }
    //조합 계산 후 리스트에 저장
    private void combination(int n,int r,int start,int cnt){
        if(cnt==r){
            String temp="";
            for(int j=0;j<n;j++){
                if(check[j]){
                    temp+=j;
                }
            }
            list.add(temp);
        }
        for(int i=start;i<n;i++){
            check[i]=true;
            combination(n,r,i+1,cnt+1);
            check[i]=false;
        }

    }
    //set에 저장하고 넣은 값과 set 크기 동일한지 비교
    private boolean dup_check(String num,String[][]relation){
        Set<String>set=new HashSet<>();
        int []arr=new int[num.length()];
        String []s_arr=num.split("");
        for(int i=0;i<num.length();i++){
            arr[i]=Integer.parseInt(s_arr[i]);
        }
        for(int i=0;i<relation.length;i++){
            String str="";
            for(int j=0;j<arr.length;j++){
                str+=relation[i][arr[j]];
            }
            set.add(str);
        }
        if(set.size()==relation.length){
            return true;
        }
        else
            return false;
    }
}

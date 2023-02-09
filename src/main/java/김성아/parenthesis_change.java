package 김성아;

public class parenthesis_change {
    public String solution(String p) {
        //재귀함수 사용
        String answer=pth(p);
        return answer;
    }
    public String pth(String str){
        if(str=="")
            return str;
        else{
            String temp="";//생성문자 반환
            int cnt=0;//문자열 나누기 위해 사용
            int index=0;//현재 인덱스
            boolean check=true;//올바른 문자열인지 체크하기 위해
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='('){
                    cnt++;
                }
                else{
                    cnt--;
                    if(cnt<0)
                        check=false;
                }
                index++;
                if(cnt==0){
                    break;
                }
            }
            String u=str.substring(0,index);
            String v;
            if(index<str.length())
                v=str.substring(index);
            else
                v="";
            if(check==true){
                temp+=u;
                temp+=pth(v);
            }
            else{
                temp+='(';
                temp+=pth(v);
                temp+=')';
                u=u.substring(1,u.length()-1);
                for(int j=0;j<u.length();j++){
                    if(u.charAt(j)==')')
                        temp+='(';
                    else
                        temp+=')';
                }
            }
            return temp;
        }
    }
}

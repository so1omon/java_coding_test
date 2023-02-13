package 김성아.레벨2;

public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();
        if(s.length()==1)
            answer=1;
        else{
            for(int i=1;i<=s.length()/2;i++){
                String []str=new String[s.length()/i];
                int s_i=0;
                for(int j=0;j<str.length;j++){
                    str[j]=s.substring(s_i,s_i+i);
                    s_i+=i;
                }
                for(int j=0;j<str.length-1;j++){
                    if(str[j].equals(str[j+1])){
                        str[j]=" ";
                    }
                }
                String temp="";
                int cnt=0;
                for(int j=0;j<str.length;j++){
                    if(str[j]==" ")
                        cnt++;
                    else{
                        if(cnt>0){
                            temp+=String.valueOf(cnt+1);
                            temp+=str[j];
                            cnt=0;
                        }
                        else{
                            temp+=str[j];
                        }
                    }
                }
                int len=temp.length()+(s.length()%i);
                if(answer>len)
                    answer=len;
            }}
        return answer;
    }
}

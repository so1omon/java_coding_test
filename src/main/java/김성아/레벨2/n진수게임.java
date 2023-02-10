package 김성아.레벨2;

public class n진수게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String str="";
        int order=1;
        int my_turn_cnt=0;
        int temp;
        int remainder;
        for(int i=0;i<t*m;i++){
            temp=i;
            while(true){
                remainder=temp%n;
                if(remainder>=10){
                    switch(remainder){
                        case 10:
                            str+="A";
                            break;
                        case 11:
                            str+="B";
                            break;
                        case 12:
                            str+="C";
                            break;
                        case 13:
                            str+="D";
                            break;
                        case 14:
                            str+="E";
                            break;
                        case 15:
                            str+="F";
                            break;
                    }
                }
                else{
                    str+=String.valueOf(remainder);}
                temp=temp/n;
                if(temp==0)
                    break;
            }
            for(int j=str.length()-1;j>=0;j--){
                if(order>m)
                    order=1;
                if(order==p){
                    answer+=String.valueOf(str.charAt(j));
                    my_turn_cnt++;
                    if(my_turn_cnt==t)
                        return answer;
                }
                order++;
            }
            str="";
        }
        return answer;
    }
}

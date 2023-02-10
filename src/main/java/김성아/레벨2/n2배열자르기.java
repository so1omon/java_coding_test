package 김성아.레벨2;

public class n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        long cnt=0;
        int index=0;
        boolean check=false;
        for(int i=1;i<=n;i++){
            if((long)n*i<left){
                cnt+=n;
                continue;
            }
            for(int j=1;j<=i;j++){
                if(cnt==left){
                    check=true;
                    answer[index++]=i;
                    cnt++;
                }
                else if(check==true){
                    answer[index++]=i;
                    cnt++;
                }
                else
                    cnt++;
                if(right<cnt)
                    return answer;
            }
            for(int k=i+1;k<=n;k++){
                if(cnt==left){
                    check=true;
                    answer[index++]=k;
                    cnt++;
                }
                else if(check==true){
                    answer[index++]=k;
                    cnt++;
                }
                else
                    cnt++;
                if(right<cnt)
                    return answer;
            }

        }
        return answer;
    }
}

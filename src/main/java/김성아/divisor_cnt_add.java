package 김성아;

public class divisor_cnt_add {
    public static int solution(int left, int right) {
        int answer = 0;

        for(int i=left;i<=right;i++){
            int div_cnt=0;
            for(int j=2;j<=Math.sqrt(i);j++) {
                if(i%j==0){
                    if(j==Math.sqrt(i))
                        div_cnt++;
                    else
                        div_cnt+=2;
                }
            }
            if(i==1)
                answer-=i;
            else if(div_cnt==0||div_cnt%2==0){
                //System.out.println("pi = " + i);
                answer+=i;}
            else{
                //System.out.println("mi = " + i);
                answer-=i;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int left=24;
        int right=27;
        int result = solution(left, right);
        System.out.println("result = " + result);
    }
}

package 김성아.레벨1;

public class remainder_one {
    static int div_num=0;
    public boolean isPrime(int n){
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                div_num=i;
                return false;}
        }
        return true;
    }
    public int solution(int n) {
        int answer = 0;
        n-=1;
        if(isPrime(n))
            answer=n;
        else{
            answer=div_num;
        }
       return answer;
    }
}

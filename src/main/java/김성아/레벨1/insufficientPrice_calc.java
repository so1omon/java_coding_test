package 김성아.레벨1;

public class insufficientPrice_calc {
    public long solution(int price, int money, int count) {

        long tot_price=0;
        for(int i=1;i<=count;i++){
            tot_price+=(price*i);
        }
        long insufnum=(tot_price-money);
        if(insufnum<=0)
            return 0;
        else
            return insufnum;

    }
}

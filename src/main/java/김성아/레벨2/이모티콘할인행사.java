package 김성아.레벨2;

public class 이모티콘할인행사 {
    static int[] discount={10,20,30,40};
    static int index=0;
    static int emti_plus_cnt_max=0;
    static int emti_price_max=0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer =new int[2];
        int emti_len=emoticons.length;
        int []t_arr=new int[emti_len];
        permutation(0,t_arr,users,emoticons);

        answer[0]=emti_plus_cnt_max;
        answer[1]=emti_price_max;
        return answer;
    }

    private void permutation(int cnt,int []t_arr,int[][]user,int[]emti){
        if(cnt==emti.length){
            int emti_plus_cnt=0;
            int emti_price=0;
            for(int u=0;u<user.length;u++){
                int user_tot=0;
                for(int j=0;j<cnt;j++){
                    if(t_arr[j]>=user[u][0]){
                        user_tot+=(emti[j]*(100-t_arr[j])*0.01);
                    }
                }
                if(user_tot>=user[u][1])
                    emti_plus_cnt++;
                else
                    emti_price+=user_tot;
            }
            if(emti_plus_cnt_max<emti_plus_cnt){
                emti_plus_cnt_max=emti_plus_cnt;
                emti_price_max=emti_price;
            }
            else if(emti_plus_cnt_max==emti_plus_cnt)
                emti_price_max=Math.max(emti_price_max,emti_price);
            return;
        }
        else{
            for(int i=0;i<discount.length;i++){
                t_arr[cnt]=discount[i];
                permutation(cnt+1,t_arr,user,emti);
            }
        }
    }
}

package 김성아.레벨3;

import java.util.*;
public class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int left=1;
        int right=200000000;
        int answer=binary_search(left,right,stones,k);
        return answer;
    }
    private int binary_search(int left,int right,int[]stones,int k)
    {
        int ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(check(stones,mid,k)){
                ans=mid;
                left=mid+1;}
            else
                right=mid-1;
        }
        return ans;
    }
    private boolean check(int[] stones,int mid,int k){
        int cnt=0;
        for(int i=0;i<stones.length;i++){
            if(mid>stones[i]){
                cnt++;
                if(cnt==k)
                    return false;
            }
            else
                cnt=0;
        }
        return true;
    }
}

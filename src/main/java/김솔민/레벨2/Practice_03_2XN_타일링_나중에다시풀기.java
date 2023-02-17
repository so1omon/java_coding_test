package 김솔민.레벨2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12900#
 * Solution using
 * 2023/02/17
 *
 *
 * <Memo>
 * </Memo>
 */
class Practice_03_2XN_타일링_나중에다시풀기 {
    public int solution(int n) {
        int answer = 0;

        long[] num = new long[n];

        for(int i=0;i<n;i++){
            if(i==0){
                num[i]=1;
            }else if(i==1){
                num[i]=2;
            }else{
                num[i]=(num[i-1]+num[i-2])%1000000007;
            }
        }


        return (int)(num[n-1]%1000000007);
    }
}

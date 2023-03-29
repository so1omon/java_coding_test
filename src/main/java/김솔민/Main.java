package 김솔민;
import java.io.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[T+1][2];
        dp[0][0] =0;
        dp[0][1] = 0;
        int first = Integer.parseInt(br.readLine());
        dp[1][0] = first;
        dp[1][1] = 0;
        for(int i=2;i<=T;i++){
            int target = Integer.parseInt(br.readLine());
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + target;
            dp[i][1] = dp[i-1][0] + target;
        }

        long max = 0;
        for(int i=0;i<=T;i++){
            for(int j=0;j<2;j++){
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }
}
package 김성아;
import java.util.*;
public class jump_teleportation {
    public int solution(int n) {
        int ans = 0;
        while(n!=1){
            if(n%2==1){
                n-=1;
                ans++;
            }
            else
                n/=2;
        }
        ans++;
        return ans;
    }
}

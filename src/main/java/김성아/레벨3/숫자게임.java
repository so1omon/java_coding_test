package 김성아.레벨3;
import java.util.*;
public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        List<Integer>list_A=new ArrayList<>();
        List<Integer>list_B=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            list_A.add(A[i]);
        }
        for(int i=0;i<B.length;i++){
            list_B.add(B[i]);
        }
        Collections.sort(list_A);
        Collections.sort(list_B);
        for(int i=0;i<list_A.size();i++){
            for(int j=0;j<list_B.size();j++){
                if(list_B.get(j)>list_A.get(i)){
                    answer++;
                    list_B.remove(j);
                    break;
                }
            }
        }
        return answer;
    }
}

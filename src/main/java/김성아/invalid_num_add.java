package 김성아;

import java.util.*;
public class invalid_num_add {
    public int solution(int[] numbers) {
        int answer = 45;
        for(int n:numbers) {
            answer -= n;
        }
        return answer;
    }
}

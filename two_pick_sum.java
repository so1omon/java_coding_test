package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class two_pick_sum {
    public static int[] solution(int[] numbers) {
        int[] answer;
        HashSet<Integer> save = new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j< numbers.length;j++){
                save.add(numbers[i]+numbers[j]);
            }
        }
        answer=new int[save.size()];
        ArrayList<Integer> temp = new ArrayList<>(save);
        for(int i=0;i<temp.size();i++)
            answer[i]=temp.get(i);
        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        int numbers[]={2,1,3,4,1};
        int[] result = solution(numbers);
        for(int a:result)
            System.out.println("a = " + a);
    }
}



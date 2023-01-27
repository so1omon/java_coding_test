package 김성아;
import java.util.*;
import java.sql.Array;
import java.util.ArrayList;

public class ternary_scale {
    public static int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(n>=3){
            int x=n%3;
            list.add(x);
            n/=3;
        }
        list.add(n);
        Collections.reverse(list);
        for(int i=0;i<list.size();i++){
            answer+= list.get(i) * Math.pow(3, i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n=45;
        int res = solution(n);
        System.out.println("res = " + res);
    }
}


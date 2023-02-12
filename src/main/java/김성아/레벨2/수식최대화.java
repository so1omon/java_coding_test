package 김성아.레벨2;
import java.util.*;
public class 수식최대화 {
    public long solution(String expression) {
        long answer = 0;
        //+-* +*- -*+ -+* *-+ *+-
        String[] operator = {"+-*", "+*-", "-*+", "-+*", "*+-", "*-+"};
        //숫자,수식 배열에 담기
        String num = expression.replaceAll("[^0-9]", " ");
        String n_str[] = num.split(" ");
        List<Long> n_arr1 = new ArrayList<>();
        for (int i = 0; i < n_str.length; i++) {
            n_arr1.add(Long.parseLong(n_str[i]));
        }
        //System.out.println(n_arr.size());
        String str = expression.replaceAll("[0-9]", "");
        List<Character> s_list1 = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            s_list1.add(str.charAt(i));
        }

        long[] findmax = new long[6];
        //연산자 우선순위마다 값계산
        //+-*
        int index = 0;
        for (int i = 0; i < operator.length; i++) {
            List<Long> n_arr = new ArrayList<>();
            n_arr.addAll(n_arr1);
            List<Character> s_list = new ArrayList<>();
            s_list.addAll(s_list1);
            for (int j = 0; j < operator[i].length(); j++) {
                char temp = operator[i].charAt(j);
                index = 0;
                while (index < s_list.size() && temp == '+') {
                    if (s_list.get(index) == temp) {
                        long n1 = n_arr.get(index);
                        long n2 = n_arr.get(index + 1);
                        n_arr.add(index, n1 + n2);
                        s_list.remove(index);
                        n_arr.remove(index + 1);
                        n_arr.remove(index + 1);
                    } else
                        index++;
                }
                index = 0;
                while (index < s_list.size() && temp == '-') {
                    if (s_list.get(index) == temp) {
                        long n1 = n_arr.get(index);
                        long n2 = n_arr.get(index + 1);
                        n_arr.add(index, n1 - n2);
                        s_list.remove(index);
                        n_arr.remove(index + 1);
                        n_arr.remove(index + 1);
                    } else
                        index++;
                }
                index = 0;
                while (index < s_list.size() && temp == '*') {
                    if (s_list.get(index) == temp) {
                        long n1 = n_arr.get(index);
                        long n2 = n_arr.get(index + 1);
                        n_arr.add(index, n1 * n2);
                        s_list.remove(index);
                        n_arr.remove(index + 1);
                        n_arr.remove(index + 1);
                    } else
                        index++;
                }
            }
            findmax[i] = Math.abs(n_arr.get(0));
        }
        //System.out.println(s_list.size());
        for (int i = 0; i < 6; i++) {
            System.out.println(findmax[i]);
            if (answer < findmax[i])
                answer = findmax[i];
        }


        return answer;
    }
}

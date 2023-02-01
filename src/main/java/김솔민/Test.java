package 김솔민;

import java.util.*;

class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,232,12,459);
        System.out.println("list = " + list);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println("list = " + list);
    }
}

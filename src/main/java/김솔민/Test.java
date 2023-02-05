package 김솔민;

import java.util.*;

class Test {
    public static void main(String[] args) {
        List<Integer> temp  = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};

        for(int i=0;i<5;i++){
            System.out.println(temp.get(i));
        }





    }
}

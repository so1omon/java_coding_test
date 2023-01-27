package 김솔민;

import java.util.HashSet;
import java.util.Iterator;

class Test {
    public static void main(String[] args) {
        String testStr = "awefAawefaw-";

        testStr = testStr.replaceAll("[^-_.a-z0-9]","");

        System.out.println(testStr);

    }
}

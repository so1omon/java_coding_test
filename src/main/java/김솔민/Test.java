package 김솔민;

import java.util.*;

class Test {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;

        // 1. skill을 분리해서 배열로 저장
        char[] skill_arr = skill.toCharArray();

        // 2. skill_trees 루프 돌기 (인덱스로)
        for(String skill_tree : skill_trees){
            String regex = "[^" + skill +"]";
            skill_tree = skill_tree.replaceAll(regex, "");
            System.out.println(skill_tree);
        }

        // 2-1. replace로 skill이 아닌 것들을 빼버리기
        // 2-2. skill과 순서가 일치한지 판별


        return answer;
    }
    public static void main(String[] args) {
//        System.out.println(new Test().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
        String a = "waefawef";
        String b=  "ewafawfwef";





    }
}

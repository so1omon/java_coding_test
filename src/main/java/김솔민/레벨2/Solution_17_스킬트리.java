package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49993
 * Solution using replaceAll(regex, arr)
 * 2023/02/07
 *
 *
 * <Memo>
 *   특정 문자들이 아닌 문자를 찾는 정규 표현식 : [^(여기 들어있는 문자들 빼고 찾기)]
 * </Memo>
 */
class Solution_17_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;

        // 1. skill을 분리해서 배열로 저장
        char[] skill_arr = skill.toCharArray();

        // 2. skill_trees 루프 돌기 (인덱스로)
        // 2-1. replace로 skill이 아닌 것들을 빼버리기
        // 2-2. skill과 순서가 일치한지 판별
        for(String skill_tree : skill_trees){
            String regex = "[^" + skill +"]";
            skill_tree = skill_tree.replaceAll(regex, "");

            int skill_arr_cursor=0;
            for(int i=0;i<skill_tree.length();i++){
                char target = skill_tree.charAt(i);

                // 스킬트리 판별 시 맞지 않으면 바로 종료
                if(target!=skill_arr[skill_arr_cursor++]){
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_17_스킬트리().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}

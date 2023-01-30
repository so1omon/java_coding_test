package 김솔민.레벨1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 * Solution using
 * 2023/01/25
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_24_햄버거만들기_fail_시간초과 {
    public int solution(int[] ingredient) {
        int answer = 0;

        String ingredients="";
        String removed = "";
        for(int i : ingredient){
            ingredients+=Integer.toString(i);
        }

        //1.1234 찾은 후, 그거 빼고 나머지 조합
        //1-1. 이를 못찾을때까지 반복
        while(true){
            removed = ingredients.replace("1231", "");
            if(ingredients.equals(removed)){
                break;
            }else{
                ingredients=removed;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_24_햄버거만들기_fail_시간초과 solution24_햄버거만들기 = new Solution_24_햄버거만들기_fail_시간초과();

        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println(solution24_햄버거만들기.solution(ingredient));
    }
}

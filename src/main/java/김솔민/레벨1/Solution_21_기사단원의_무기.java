package 김솔민.레벨1;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * Solution using
 * 2023/01/25
 *
 *
 * <Memo>
 *     약수의 개수 구하기 - 1 2 4 8 16 -> 루트16까지 iterate, 제곱수로 판별 시 +1, 아니고 그냥 약수일 시 +2
 * </Memo>
 */
class Solution_21_기사단원의_무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        // 각 기사는 자신의 기사 번호(number)의 약수 개수에 해당하는 공격력을 가진 무기를 구매하려 합니다
        // 단, 이웃나라와의 협약에 의해 공격력의 제한수치(limit)를 정하고,
        // 제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는 협약기관에서 정한 공격력을 가지는 무기(power)를 구매해야 합니다.
        // 추가 : dp로 약수의 개수 저장해야할듯

        // 1. 1~number까지 loop
        // 2. 번호의 약수의 개수 구하기
        // 3. 약수의 개수가 limit보다 크다면, power를 구매
        // 4. answer에 무기 공격력 더하기
        for(int i=1;i<=number;i++){
            int required = myDiv(i);
            if(required > limit){
                required = power;
            }
            answer+=required;
        }
        return answer;
    }

    int myDiv(int target){
        int result = 0;
        for(int i=1;i*i<=target;i++){
            if(i*i==target){
                result+=1;
            }else if(target%i==0){
                result+=2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution_21_기사단원의_무기 solution21_기사단원의_무기 = new Solution_21_기사단원의_무기();

        int number = 10;
        int limit = 3;
        int power = 2;

        System.out.println(solution21_기사단원의_무기.solution(number, limit, power));
    }
}

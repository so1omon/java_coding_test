package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12979
 * Solution using
 * 2023/02/25
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_01_기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 전략 : N의 크기가 너무 크기 때문에 전파가 닿지 않는 곳을 찾는 알고리즘 배제
        // 그 대신, 초기에 기지국이 설치된 곳을 기준으로
        // 구간을 나눠서 하기 (station<=10000)

        // 특정 구간 내에 있는 아파트들의 수를 interval이라고 하면, 구간 내에 설치해야 할
        // 기지국의 수는 Integer.parseInt(Math.floor(interval/(W*2-1)))

        // 1. 구간 나눠서 구간의 크기 구하기
        // 처음 아파트 idx = 1
        int tempIdx = 0;
        for(int station : stations){
            // 다음 구간 준비
            int interval = station - tempIdx - (w+1);
            // System.out.println("구간크기:"+interval);
            tempIdx = station+w;

            int sum = (int)(Math.ceil((double)interval/(double)(w*2+1)));

            if(sum<0){
                continue;
            }
            answer+=sum;
            // System.out.println(sum+"만큼 더해짐");
        }

        // 마지막 구간
        int interval = n-tempIdx;
        // System.out.println("구간크기:"+interval);

        int sum = (int)(Math.ceil((double)interval/(double)(w*2+1)));
        answer+=sum;
        // System.out.println(sum+"만큼 더해짐");
        return answer;
    }

    public static void main(String[] args) {

    }
}

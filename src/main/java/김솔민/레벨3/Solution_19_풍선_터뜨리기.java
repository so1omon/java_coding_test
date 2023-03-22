package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68646#
 * Solution using
 * 2023/03/22
 *
 *
 * <Memo>
 * </Memo>
 */

class Solution_19_풍선_터뜨리기 {
    public int solution(int[] a) {
        int answer = 2;
        // 현재 나의 인덱스를 기준으로 왼쪽, 오른쪽에서 나보다 작은 값이 두 개가 있으면 안됨
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int tempLeft = a[0];
        int tempRight = a[a.length-1];

        for(int i=1;i<a.length;i++){
            if(tempLeft>a[i]){// 최솟값 갱신
                tempLeft = a[i];
            }
            leftMin[i] = tempLeft;
        }

        for(int i=a.length-2;i>=0;i--){
            if(tempRight>a[i]){ // 최솟값 갱신
                tempRight = a[i];
            }
            rightMin[i] = tempRight;
        }

        if(a.length==1) return 1;

        for(int i=1;i<a.length-1;i++){
            int validate = 0;
            if(a[i]>leftMin[i]){
                validate++;
            }
            if(a[i]>rightMin[i]){
                validate++;
            }
            if(validate!=2){
                answer++;
            }
        }

        return answer;
    }

}

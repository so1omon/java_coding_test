package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/62048
 * Solution using
 * 2023/02/15
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_29_멀쩡한_사각형 {
    public long solution(int w, int h) {
        // 1. 두 수의 최대공약수 구하기
        int gcdwh = gcd(w, h);
        long total = (long)w * (long)h;

        return total - (long)(w+h-gcdwh);
    }


    public int gcd(int w, int h){
        // w를 큰값으로 위치시키기 (swap)
        if(w<h){
            int temp = w;
            w = h;
            h = temp;
        }

        while(h!=0){
            int n = w%h;
            w = h;
            h = n;
        }

        return w;
    }
}

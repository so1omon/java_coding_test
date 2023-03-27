package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150365
 * 2023/03/27
 *
 *
 * <Memo>
 * </Memo>
 */


class Solution_22_미로_탈출_명령어 {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        int[] required = new int[4]; // dlru -> 0123

        int dy = r-x;
        int dx = c-y;
        if(dy>0){
            required[0] += dy;
        }else{
            required[3] -= dy;
        }
        if(dx<0){
            required[1] -= dx;
        }else{
            required[2] += dx;
        }

        int limit = k-(Math.abs(dx)+Math.abs(dy));

        if(limit <0 || limit%2==1 ){
            return "impossible";
        }

        int max_d  = Math.min(n-x, required[0] + limit/2);
        int add_u = max_d - required[0];
        limit-= add_u*2;

        required[0] = max_d;
        required[3]+=add_u;

        required[1]+=limit/2;
        required[2]+=limit/2;


        // 결과값 커서로 돌리기
        while(k!=0){
            if(required[0]>0 && x<n ){
                required[0]--;
                x++;
                answer+="d";
            }else if(required[1]>0 && y>1){
                required[1]--;
                y--;
                answer+="l";
            }else if(required[2]>0 && y<m){
                required[2]--;
                y++;
                answer+="r";
            }else{
                required[3]--;
                x--;
                answer+="u";
            }
            k--;
        }
        return answer;
    }

}

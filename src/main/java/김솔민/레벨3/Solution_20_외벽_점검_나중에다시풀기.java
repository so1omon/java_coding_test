package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60062
 * Solution using
 * 2023/03/23
 *
 *
 * <Memo>
 * </Memo>
 */

class Solution_20_외벽_점검_나중에다시풀기 {
    static int[] static_weak;
    static int[] static_dist;
    static int min = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        static_weak = new int[weak.length*2];
        static_dist = dist;

        for(int i=0;i<static_weak.length;i++){
            if(i>=weak.length){
                static_weak[i] = weak[i-weak.length] + n;
            }else{
                static_weak[i] = weak[i];
            }
        }

        brute(new int[dist.length], new boolean[dist.length], 0, dist.length);

        if(min == Integer.MAX_VALUE){
            return -1;
        }

        return min;
    }

    void brute(int[] arr, boolean[] visited, int depth, int n){

        if(depth==n){


            int len_weak = static_weak.length/2;
            int len_dist = static_dist.length;

            // 시작 지점 순환
            for(int i=0;i<len_weak;i++){
                int weak_value = static_weak[i];
                int weak_ptr = i;

                int dist_ptr = 0;
                int cnt = 0;

                while(cnt<len_weak && dist_ptr < len_dist){
                    weak_value+=arr[dist_ptr++];
                    while(cnt < len_weak && static_weak[weak_ptr]<=weak_value){
                        weak_ptr++;
                        cnt++;
                    }
                    weak_value = static_weak[weak_ptr];
                }

                if(cnt==len_weak && min > dist_ptr){
                    min = dist_ptr;
                }
            }
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = static_dist[i];
                brute(arr, visited, depth+1, n);
                visited[i] = false;
            }
        }

    }

}

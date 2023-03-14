package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60059
 * Solution using
 * 2023/03/14
 *
 *
 * <Memo>
 * </Memo>
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution_10_자물쇠와_열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int M = key.length;
        int N = lock.length;

        // lock에서 자물쇠 홈 부분만 추출해서 크기 계산 -> key보다 크면 false
        int[] col_range = {Integer.MAX_VALUE, 0};
        int[] row_range = {Integer.MAX_VALUE, 0};

        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(lock[i][j]==1){
                    sum++;
                }
            }
        }
        if(sum==N*N) return true;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(lock[i][j]==0){
                    col_range[0] = col_range[0]>i?i:col_range[0];
                    col_range[1] = col_range[1]<i?i:col_range[1];
                    row_range[0] = row_range[0]>j?j:row_range[0];
                    row_range[1] = row_range[1]<j?j:row_range[1];
                }
            }
        }

        if(col_range[1]-col_range[0]>N || row_range[1]-row_range[0]>N ||
            col_range[0] == Integer.MAX_VALUE ||
            row_range[0] == Integer.MAX_VALUE){
            return false;
        }

        int[][] target = new int[col_range[1]-col_range[0]+1][row_range[1]-row_range[0]+1];


        for(int i=0;i<target.length;i++){
            for(int j=0;j<target[0].length;j++){
                target[i][j] = lock[i+col_range[0]][j+row_range[0]];
            }
        }

        // 홈 부분을 90도 회전시킨 4가지 버전을 key에 끼워넣어보면서 맞는지 확인하기
        for(int i=0;i<4;i++){
            int[][] new_target = rotate(target, i);

            // 끼워 넣은 결과가 맞으면 그대로 true반환
            if(insert(key, new_target)){
                return true;
            }
        }


        return answer;
    }

    // degree -> 1, 2, 3
    int[][] rotate(int[][] origin, int degree){
        if(degree==0) return origin;

        int[][] new_arr;

        // 1, 3이면 크기 변환
        if(degree%2 ==1){
            new_arr = new int[origin[0].length][origin.length];
        }else{
            new_arr = new int[origin.length][origin[0].length];
        }

        for(int i=0;i<origin.length;i++){
            for(int j=0;j<origin[0].length;j++){
                switch(degree){
                    case 1:
                        new_arr[j][new_arr[0].length-1-i] = origin[i][j];
                        break;
                    case 2:
                        new_arr[new_arr.length-1-i][new_arr[0].length-1-j] = origin[i][j];
                        break;
                    case 3:
                        new_arr[new_arr.length-1-j][i] = origin[i][j];
                        break;
                }

            }
        }

        return new_arr;
    }

    boolean insert(int[][] key, int[][] lock){

        for(int i=0;i<key.length-lock.length+1;i++){
            for(int j=0;j<key[0].length-lock[0].length+1;j++){

                boolean flag = false;
                for(int k=0;k<lock.length;k++){
                    for(int l=0;l<lock[0].length;l++){
                        if((lock[k][l] == key[k+i][l+j])){
                            flag = true;
                            break;
                        }
                    }
                }
                if(!flag){
                    return true;
                }
            }
        }
        return false;
    }
}

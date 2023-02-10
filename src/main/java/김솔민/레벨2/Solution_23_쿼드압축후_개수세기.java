package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 * Solution using
 * 2023/02/10
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_23_쿼드압축후_개수세기 {
    // 전체 보드 만들기
    public int[][] board;
    public int[] count = new int[2];
    
    public int[] solution(int[][] arr) {
        board = arr;
        
        recursive(0,0,arr.length);
        
        return count;
    }
    
    
    public void recursive(int m, int n, int size){
        // 1. 받아온 범위에 대해 전체 비교
        
        // 1-1. 만약 size가 1이라면 그대로 리턴
        int targetNum = board[m][n];
        
        if(size==1){
            count[targetNum]++;
            return;
        }
        
        boolean flag = false;
        for(int i=m;i<m+size;i++){
            
            for(int j=n;j<n+size;j++){
                if (board[i][j]!=targetNum){
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        // 2. 만약 전체 다 똑같다면 해당 값을 리턴
        if(!flag){
            count[targetNum]++;
            return;
        }else{// 3. 그렇지 않으면 범위 쪼개서 다시 수행
            size/=2;
            recursive(m,n,size);
            recursive(m+size,n,size);
            recursive(m,n+size,size);
            recursive(m+size,n+size,size);
        }
        
        
        
        
    }
}
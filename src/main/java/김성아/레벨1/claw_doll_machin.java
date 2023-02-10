package 김성아.레벨1;

import java.util.Stack;

public class claw_doll_machin {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int x:moves){
            for(int i=0;i<board.length;i++){
                if(board[i][x-1]>0){
                    if(!stack.empty()&&stack.peek()==board[i][x-1]){
                        stack.pop();
                        answer+=2;
                    }
                    else
                        stack.push(board[i][x-1]);
                    board[i][x-1]=0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int [][]board={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int []moves={1,5,3,5,1,2,1,4};
        int result = solution(board, moves);
        System.out.println("result = " + result);
    }
}


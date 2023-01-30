package 김솔민.레벨1;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1018
 * Solution using
 * 2023/01/06
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_12_체스판 {
    public static int getSolution(int startRow, int startCol, String[] board) {
        int try1=0;

        // 1. board[startRow][startCol]이 검은색인 경우 total 구하기
        for(int i=startRow;i<startRow+8;i++){
            for(int j=startCol;j<startCol+8;j++){
                int sumIdx = i+j-startRow-startCol;
                if(sumIdx%2==0 && board[i].charAt(j)=='W'){
                    try1++;
                }else if(sumIdx%2==1 && board[i].charAt(j)=='B'){
                    try1++;
                }
            }
        }
        int try2=64-try1;

        if(try1<try2){
            return try1;
        }else return try2;
        // 2. board[startRow][startCol]이 흰색인 경우 total 구하기
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();

        String[] board = new String[row];
        for (int i = 0; i < row; i++) board[i] = sc.nextLine();

        // 1. 체스판 자르기
        int sol = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                // 2. 현 체스판의 최소 비용 구하기
                int curSol = getSolution(i, j, board);
                // 3. 전체 최적의 값과 비교하여 갱신하기
                if (sol > curSol) sol = curSol;
            }
        }

        System.out.println(sol);
        sc.close();
    }
}

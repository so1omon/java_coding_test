package 김솔민.레벨2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * 2023/02/05
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_16_프렌즈_4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        // 0단계 : char[][] boardArr 생성, 상하 90도 반전시키기 (나중에 List 편하게 쓰려고)
        char[][] boardArr = new char[m][n];
        for(int i=0;i<m;i++){
            boardArr[m-i-1] = board[i].toCharArray();
        }

        // 반복 시작
        while(true){
            // 1단계 : 2*2 탐색 -> 찾은 index 정보 저장
            int[][] targetIdx = new int[m][n];

            int origin = answer;
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if (boardArr[i][j]=='X'){
                        continue;
                    }

                    if(boardArr[i][j]==boardArr[i][j+1]&&
                        boardArr[i][j]==boardArr[i+1][j]&&
                        boardArr[i][j]==boardArr[i+1][j+1]){
                        for(int k=i;k<=i+1;k++){
                            for(int l=j;l<=j+1;l++){
                                if(targetIdx[k][l]!=1){
                                    targetIdx[k][l]=1;
                                    answer++;
                                }
                            }
                        }
                    }
                }
            }

            // 2단계 : 저장한 index 정보에 포함된 인덱스를 전부 'X'로 치환
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(targetIdx[i][j]==1){
                        boardArr[i][j]='X';
                    }
                }
            }
            // 3단계 : 세로로 board Arr을 탐색해서
            // 'X'인 부분을 제거하고 다시 char로 넣기, answer++
            // answer에 변화가 없으면 break

            for(int i=0;i<n;i++){
                List<Character> temp = new ArrayList<>();
                for(int j=0;j<m;j++){
                    if(boardArr[j][i]!='X'){
                        temp.add(boardArr[j][i]);
                    }
                }
                // 잘려나간 만큼 채워주기
                int addCount = temp.size();
                for(int k=0;k<m-addCount;k++){
                    temp.add('X');
                }
                //다시 boardArr에 넣어주기
                for(int j=0;j<m;j++){
                    boardArr[j][i]= temp.get(j);
                }
            }

            if(origin==answer){
                break;
            }
        }

        // 반복 끝
        return answer;
    }

    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(new Solution_16_프렌즈_4블록().solution(4, 5, board));
    }
}

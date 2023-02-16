package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/87377
 * Solution using
 * 2023/02/16
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_31_교점에_별만들기 {
    public String[] solution(int[][] line) {
        Set<int[]> coordSet = new HashSet<>();

        // 1. 각 직선을 돌면서 마주치는 정수 격자에 대한 값을 전체 좌표평면에 저장
        // (수정) 1. (n-1)!번 돌아가면서 교점 구하기
        for(int i=0;i<line.length-1;i++){
            long A = (long)line[i][0];
            long B = (long)line[i][1];
            long E = (long)line[i][2];
            for(int j=i+1;j<line.length;j++){
                long C = (long)line[j][0];
                long D = (long)line[j][1];
                long F = (long)line[j][2];

                long ratio = A*D - B*C;
                if(ratio!=0){
                    if((B*F-E*D)%ratio==0 && (E*C-A*F)%ratio==0){
                        coordSet.add(
                            new int[]{
                                (int)((B*F-E*D)/ratio),
                                (int)((E*C-A*F)/ratio)
                            });
                    }
                }
            }
        }

        // Null 처리
        Integer[] xRange= new Integer[2]; // x in [0] ~[1]
        Integer[] yRange= new Integer[2]; // y in [0] ~[1]

        // 좌표 범위 구하기
        for(int[] idx : coordSet){
            if(xRange[0]==null || xRange[0]>idx[0]){
                xRange[0] = idx[0];
            }
            if(xRange[1]==null || xRange[1]<idx[0]){
                xRange[1] = idx[0];
            }

            if(yRange[0]==null || yRange[0]>idx[1]){
                yRange[0] = idx[1];
            }
            if(yRange[1]==null || yRange[1]<idx[1]){
                yRange[1] = idx[1];
            }
        }

        // 0~1까지이면 2개 좌표
        char[][] answer =
            new char[yRange[1]-yRange[0]+1][xRange[1]-xRange[0]+1];

        for(int i=0;i<answer.length;i++){
            for(int j=0;j<answer[0].length;j++){
                answer[i][j]='.';
            }
        }

        // 실제 좌표계 중심: (0,0)
        // 변환된 좌표계 중심 : (0,0)-(x최소, y최소)
        for(int[] idx : coordSet){
            answer[yRange[1]-idx[1]][idx[0]-xRange[0]] = '*';
        }

        String[] answerStr = new String[answer.length];

        for(int i=0;i<answerStr.length;i++){
            answerStr[i] = String.valueOf(answer[i]);
        }

        return answerStr;
    }
}

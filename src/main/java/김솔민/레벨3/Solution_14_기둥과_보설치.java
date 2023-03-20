package 김솔민.레벨3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60061
 * Solution using
 * 2023/03/20
 *
 *
 * <Memo>
 * </Memo>
 */
import java.util.*;

class Solution_14_기둥과_보설치 {
    boolean[][][] nodes;
    public int[][] solution(int n, int[][] build_frame) {

        nodes = new boolean[n+1][n+1][4];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                nodes[i][j] = new boolean[]{false, false, false, false};
            }
        }

        for(int[] frame : build_frame){
            if(frame[3]==1){//설치
                if(preInstallValidate(frame[2], frame[0], frame[1], n)){
                    if(frame[2]==0){ // 기둥 설치
                        nodes[frame[0]][frame[1]][1] = true;
                        nodes[frame[0]][frame[1]+1][0] = true;
                    }else{ // 보 설치
                        nodes[frame[0]][frame[1]][3] = true;
                        nodes[frame[0]+1][frame[1]][2] = true;
                    }
                }
            }else{ // 삭제
                if(postDeleteValidate(frame[2], frame[0], frame[1], n)){
                    if(frame[2]==0){ // 기둥 삭제
                        nodes[frame[0]][frame[1]][1] = false;
                        nodes[frame[0]][frame[1]+1][0] = false;
                    }else{ // 보 삭제
                        nodes[frame[0]][frame[1]][3] = false;
                        nodes[frame[0]+1][frame[1]][2] = false;
                    }
                }
            }
        }

        List<int[]> answerList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(nodes[i][j][1]){// 윗기둥
                    answerList.add(new int[]{i, j, 0});
                }
                // 오른보
                if(nodes[i][j][3]){
                    answerList.add(new int[]{i, j, 1});
                }
            }
        }

        int[][] answer = new int[answerList.size()][3];
        for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    boolean preInstallValidate(int type, int x, int y, int n){
        boolean[] target = nodes[x][y];
        if(type==0){ // 기둥
            return (y==0)||target[0]||target[2]||target[3];
        }else{ // 보
            boolean cond = false;
            boolean[] rightTarget = nodes[x+1][y];
            return (target[0]||rightTarget[0]) || (target[2]&&rightTarget[3]);
        }
    }

    boolean postDeleteValidate(int type, int x, int y, int n){
        boolean[] target = nodes[x][y];
        boolean cond = true;
        if(type==0){ // 기둥 삭제
            boolean[] upTarget = nodes[x][y+1];

            // 위쪽에 기둥이 있고 보가 하나라도 있으면 OK
            if(upTarget[1]){
                cond&=(upTarget[2]||upTarget[3]);
            }

            // 왼쪽에 보가 있다면 왼쪽 지점에 아래 기둥이 있거나, 왼쪽 지점에 왼쪽 보가 있고 오른쪽 보가 있으면 OK
            if(upTarget[2]){
                boolean[] leftUpTarget = nodes[x-1][y+1];
                cond&=(leftUpTarget[0] || (leftUpTarget[2] && upTarget[3]));
            }
            // 오른쪽 지점에 보가 있다면 오른쪽 지점에 아래 기둥이 있거나,
            // 왼쪽 보가 있고 오른쪽 지점에 오른쪽 보가 있으면 OK
            if(upTarget[3]){
                boolean[] rightUpTarget = nodes[x+1][y+1];
                cond&=(rightUpTarget[0] || (rightUpTarget[3] && upTarget[2]));
            }

        }else{ // 보 삭제
            // 내 지점에 위 기둥이 있으면 아래 기둥이 있거나 왼쪽 보가 있으면 ok
            boolean[] rightTarget = nodes[x+1][y];
            if(target[1]){
                cond&=(target[0] || target[2]);
            }
            // 오른쪽 지점에 위 기둥이 있으면 오른쪽 지점에 아래 기둥이 있거나 오른쪽 지점에 오른쪽 보가 있으면 ok
            // 오른쪽 지점에 오른쪽 보가 있으면 오른쪽 지점에 아래 기둥이 있거나
            // 오른오른쪽 지점에 아래 기둥이 있으면 ok

            if(rightTarget[1]){
                cond&=(rightTarget[0] || rightTarget[3]);
            }

            if(rightTarget[3]){
                boolean[] nextTarget = nodes[x+2][y];
                cond&=(rightTarget[0] || nextTarget[0]);
            }

            // 내 지점에 왼쪽 보가 있으면 왼쪽 지점에 아래 기둥이 있거나 내 지점에 아래 기둥이 있으면 ok
            if(target[2]){
                boolean[] leftTarget = nodes[x-1][y];
                cond&= (leftTarget[0] || target[0]);
            }
        }

        return cond;
    }

}

package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86052
 * Solution using
 * 2023/02/22
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_34_빛의_경로_사이클_실패_다시풀기 {
    public int[] solution(String[] grid) {

        List<Integer> answerList = new ArrayList<>();

        int row = 0;
        int col = 0;

        // 0. 격자 초기화
        Light[][] lightGrid = new Light[grid.length][];

        for(int i=0;i<grid.length;i++){
            lightGrid[i] = new Light[grid[0].length()];
            for(int j=0;j<grid[0].length();j++){
                switch(grid[i].charAt(j)){
                    case 'S':
                        lightGrid[i][j] = new Light(0);
                        break;
                    case 'L':
                        lightGrid[i][j] = new Light(1);
                        break;
                    case 'R':
                        lightGrid[i][j] = new Light(2);
                        break;
                    default:
                        break;
                }
            }
        }


        // 1. 맨 처음 인덱스부터 시작해서 회로타기
        // 1-1. 쏠 수 있는 지점을 찾지 못할 때까지 (row, col = -1, -1)
        while(row!=-1 && col!=-1){
            int[] tempIdx = new int[]{row, col};

            // 최초 temp에 대해 availablePath를 찾고, direction에 따라서 계속 반복
            int[] nextDirection = lightGrid[row][col].availablePath();


            int circuitCount = 0;
            while(true){
                circuitCount++;
                // 1. 진행방향에 따라서 다음 노드로 옮기기 (tempIdx 업데이트 + 해당 진행방향 막기)
                lightGrid[tempIdx[0]][tempIdx[1]].addLight(nextDirection[2]);
                tempIdx[0] = (tempIdx[0] + nextDirection[0] + lightGrid.length)%(lightGrid.length);
                tempIdx[1] = (tempIdx[1] + nextDirection[1] + lightGrid[0].length)%(lightGrid[0].length);

                switch(lightGrid[tempIdx[0]][tempIdx[1]].direction){
                    case 0: //S
                        nextDirection = moveIdx(nextDirection[2]);
                        break;
                    case 1: //L
                        nextDirection = moveIdx((nextDirection[2]+1)%4);
                        break;
                    case 2: //R
                        nextDirection = moveIdx((nextDirection[2]+3)%4);
                        break;
                    default:
                        break;
                }
                // 2. 다음 노드에서 막혀있으면 반복문 종료
                 if(lightGrid[tempIdx[0]][tempIdx[1]].inout[nextDirection[2]]){
                    break;
                }
            }

            answerList.add(circuitCount);
            // row, col update
            int[] updatedIdx = findAvailableLight(row, col, lightGrid);
            row = updatedIdx[0];
            col = updatedIdx[1];
        }

        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        int count = 0;
        for (int i : answerList){
            answer[count++] = i;
        }

        return answer;
    }

    class Light{
        int direction; // S=0, L=1, R=2
        boolean[] inout = new boolean[4]; // 상좌하우에서 나가는 방향
        int count=0; // inout 찬 개수

        public Light(int direction){
            this.direction = direction;
        }

        // from = 상좌하우, direct = 안밖
        boolean addLight(int from){
            if(inout[from]){
                return false;
            }else{
                inout[from]= true;
                count++;
                return true;
            }
        }

        boolean isAvailable(){
            if(count==4){
                return false;
            }
            return true;
        }

        int[] availablePath(){
            for(int i=0;i<4;i++){
                if(!inout[i]){
                    return moveIdx(i);
                }
            }
            return new int[]{-1,-1,-1};
        }
    }

    int[] findAvailableLight(int row, int col, Light[][] circuit){
        for(int i=row;i<circuit.length;i++){
            for(int j=col;j<circuit[0].length;j++){
                Light temp = circuit[i][j];

                if(temp.isAvailable()){
                    return new int[]{i,j};
                }

            }
        }
        return new int[]{-1,-1};
    }

    // from : 상좌하우
    int[] moveIdx(int direction){
        int[] direct;
        switch(direction){
            case 0: //상
                direct= new int[]{-1,0,0};
                break;
            case 2: //하
                direct= new int[]{1,0,2};
                break;
            case 1: //좌
                direct= new int[]{0,-1,1};
                break;
            case 3: //우
                direct= new int[]{0,1,3};
                break;
            default:
                direct= new int[]{-1, -1, -1};
                break;
        }
        return direct;
    }

    public static void main(String[] args) {
        String[] grid = {"LRL"};
        System.out.println(new Solution_34_빛의_경로_사이클_실패_다시풀기().solution(grid));
    }
}

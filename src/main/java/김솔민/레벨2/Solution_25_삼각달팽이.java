package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68645
 * Solution using
 * 2023/02/11
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_25_삼각달팽이 {
    public int[] solution(int n) {


        // 1. int[][] 가변형 길이 배열 생성
        int[][] triangle = new int[n][];

        // 1-1. 1행 -> 1개, ... , n행 -> n개 배열
        for(int i=1;i<=n;i++){
            triangle[i-1] = new int[i];
        }


        // 2. 현재 인덱스 커서 저장
        int[] cursor = {0,0};

        // 3. 3개의 방향값을 저장 (down, right, leftUp)
        // 3-1. 3개의 방향값을 번갈아가면서 숫자 넣기, 1+2+ ... + n까지
        // 3-2. 단순하게 방향만 저장하는게 나을듯
        // char[] directions = {'d', 'r', 'l'};

        char initDirection = 'd';
        System.out.println(((n)*(n+1))/2);
        for(int i=1;i<=((n)*(n+1))/2;i++){
            triangle[cursor[0]][cursor[1]] = i;

            if(i==((n)*(n+1))/2){
                break;
            }

            switch(initDirection){
                case 'd':
                    // d->r
                    if(cursor[0]==n-1 || triangle[cursor[0]+1][cursor[1]]!=0){
                        initDirection = 'r';
                        cursor[1]++;
                    }else{
                        cursor[0]++;
                    }
                    break;
                case 'r':
                    // r->l
                    if(cursor[1]==n-1 || triangle[cursor[0]][cursor[1]+1]!=0){
                        initDirection = 'l';
                        cursor[0]--;
                        cursor[1]--;
                    }else{
                        cursor[1]++;
                    }
                    break;
                case 'l':
                    // l->d
                    if(triangle[cursor[0]-1][cursor[1]-1]!=0){
                        initDirection = 'd';
                        cursor[0]++;
                    }else{
                        cursor[0]--;
                        cursor[1]--;
                    }
                    break;
                default:
                    break;
            }
        }
        List<Integer> answerList = new ArrayList<>();
        for(int[] tri : triangle){
            for(int t : tri){
                answerList.add(t);
            }
        }

        int count = 0;
        int[] answer = new int[answerList.size()];
        for(int i : answerList){
            answer[count++] = i;
        }

        // 4. answer에 넣기
        return answer;
    }

    public static void main(String[] args) {

    }
}

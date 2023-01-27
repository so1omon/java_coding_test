package 김솔민;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 * Solution using
 * 2023/01/06
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_10_MyAnswer_Success {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        int[] curLeft=new int[]{3,0};
        int[] curRight=new int[]{3,2};

        for(int number : numbers){
            // 1. 왼손은 1,4,7 | 오른손은 3,6,9 선점
            int[] temp = toIndex(number);
            switch(number){
                case 1,4,7:
                    curLeft = temp;
                    answer+="L";
                    break;
                case 3,6,9:
                    curRight = temp;
                    answer+="R";
                    break;
                default:
                    int rangeLeft =range(curLeft, temp);
                    int rangeRight =range(curRight, temp);

                    if(rangeLeft < rangeRight){// 왼손이 더 가까울 때
                        curLeft = temp;
                        answer+="L";
                        //range 비교
                    }else if(rangeLeft>rangeRight){
                        curRight=temp;
                        answer+="R";
                    }else{
                        if(hand.equals("left")){
                            curLeft = temp;
                            answer+="L";
                        }else{
                            curRight=temp;
                            answer+="R";
                        }
                    }
            }
            // 2. 터치 할 떄마다 왼손과 오른손 위치 저장

            // 3. 2,5,8,0 누를 때는 왼손과 오른손 중 더 가까운 곳으로 터치, 단 거리가 같을 경우 hand로 판별
        }


        // 4. 최종 답안 return

        return answer;
    }

    public int[] toIndex(int num){
        int[] result;
        if(num==0){
            result = new int[]{3, 1};
        }else{
            result = new int[]{(num - 1) / 3, (num - 1) % 3};
        }
        return result;
    }

    public int range(int[] original, int[] target){
        return Math.abs(original[0]-target[0]) + Math.abs(original[1]-target[1]);
    }

    public static void main(String[] args) {

        Solution_10_MyAnswer_Success solution10 = new Solution_10_MyAnswer_Success();

        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        System.out.println(solution10.solution(numbers,hand));
    }
}

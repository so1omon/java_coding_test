package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150368
 * Solution using
 * 2023/02/20
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_32_이모티콘_할인행사 {
    // [0] : 이모티콘 서비스 가입자 수, [1] : 이모티콘 판매액
    int[] answer = new int[2];
    int[][] publicUser;
    public int[] solution(int[][] users, int[] emoticons) {
        publicUser = users;
        int[] dcRate = new int[emoticons.length];
        recursive(emoticons, 0, emoticons.length, dcRate);

        return answer;
    }
    // 1. 이모티콘 할인 풀을 돌리기 (4^이모티콘 종류 수만큼(최대 4^7))
    // 2. 할인 풀대로 유저들을 계산
    // 3. 다 계산 후에 maxEmoPlus, maxSales를 대소비교하면서 업데이트
    void recursive(int[] emoticons, int depth, int n, int[] dcRate){
        if(depth==n){
            int[] result = new int[2];
            for(int[] user : publicUser){

                //user[0] : 할인율, user[1] : 금액
                int maxPrice = 0;

                //emoticon loop
                for(int i=0;i<n;i++){
                    if(dcRate[i]>=user[0]){
                        maxPrice+=(emoticons[i]*(100-dcRate[i]))/100;
                        if(maxPrice>=user[1]){
                            maxPrice = -1;
                            result[0]++;
                            break;
                        }
                    }
                }
                if(maxPrice!=-1){
                    result[1]+=maxPrice;
                }
            }

            // 최종 판별
            if(answer[0]<result[0]){
                answer[0] = result[0];
                answer[1] = result[1];
            }else if(answer[0]==result[0] && answer[1]<result[1]){
                answer[1] = result[1];
            }

            return;
        }
        for(int i=10;i<=40;i+=10){
            dcRate[depth] = i;
            recursive(emoticons, depth+1, n, dcRate);
        }
    }

    public static void main(String[] args) {

    }
}

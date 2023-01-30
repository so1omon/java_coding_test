package 김솔민.레벨2;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 * Solution using
 * 2023/01/29
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_01_행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];


        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2[0].length;j++){
                for(int k=0;k<arr2.length;k++){
                    answer[i][j]+=arr1[i][k]*arr2[k][j];
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution_01_행렬의곱셈 solution1_행렬의곱셈 = new Solution_01_행렬의곱셈();

        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3,3},{3,3}};

        System.out.println(solution1_행렬의곱셈.solution(arr1, arr2));
    }
}

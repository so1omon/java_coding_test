package 김성아.레벨2;

public class 삼각달팽이 {
    public int[] solution(int n) {
        int []answer=new int[n*(n+1)/2];
        int [][]arr=new int[n][n];
        int x=-1;
        int y=0;
        int index=1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i%3==0)
                    x++;
                else if(i%3==1)
                    y++;
                else{
                    x--;
                    y--;
                }
                arr[x][y]=index++;
            }
        }
        index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[index++]=arr[i][j];
            }
        }
        return answer;
    }
}

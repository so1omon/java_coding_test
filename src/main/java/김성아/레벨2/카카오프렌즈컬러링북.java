package 김성아.레벨2;

public class 카카오프렌즈컬러링북 {
    static int []dx={0,0,-1,1};
    static int []dy={-1,1,0,0};
    static int cnt=0;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea=0;
        int maxSizeOfOneArea=0;
        boolean[][]check=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0&&!check[i][j]){
                    numberOfArea++;
                    dfs(i,j,picture,check);}
                if(maxSizeOfOneArea<cnt){
                    maxSizeOfOneArea=cnt;
                }
                cnt=0;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public void dfs(int x,int y,int[][]arr,boolean[][]check){
        if(check[x][y])
            return;
        check[x][y]=true;
        cnt++;
        for(int i=0;i<4;i++){
            int add_dx=x+dx[i];
            int add_dy=y+dy[i];
            if(add_dx<0 || add_dx>=arr.length || add_dy<0 || add_dy>=arr[0].length)
                continue;
            if(arr[x][y]==arr[add_dx][add_dy]&&check[add_dx][add_dy]==false)
                dfs(add_dx,add_dy,arr,check);
        }
    }


}

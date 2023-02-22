package 김성아.레벨2;

import java.util.*;
public class 빛의경로사이클 {
    static boolean[][][]check;
    static int []dir_row={-1,0,1,0};
    static int []dir_col={0,-1,0,1};
    static int row,col;
    static String[][]node;
    public int[] solution(String[] grid) {
        int []answer;
        List<Integer>ans=new ArrayList<>();
        row=grid.length;
        col=grid[0].length();
        node=new String[row][];
        for(int i=0;i<row;i++){
            node[i]=grid[i].split("");
        }
        check=new boolean[row][col][4];//경로
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<4;k++){
                    if(!check[i][j][k]){
                        int c=cycle(i,j,k,node);
                        ans.add(c);
                    }
                }
            }
        }
        Collections.sort(ans);
        answer=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            answer[i]=ans.get(i);
        return answer;
    }
    public int cycle(int row_i,int col_i,int direction,String [][]node){
        int cnt=0;
        while(!check[row_i][col_i][direction]){
            check[row_i][col_i][direction]=true;
            cnt++;
            if (node[row_i][col_i].equals("L"))
                direction = direction == 0 ? 3 : direction - 1;
            else if (node[row_i][col_i].equals("R"))
                direction = direction == 3 ? 0 : direction + 1;
            row_i=(dir_row[direction]+row_i+row)%row;
            col_i=(dir_col[direction]+col_i+col)%col;
        }
        return cnt;
    }
}

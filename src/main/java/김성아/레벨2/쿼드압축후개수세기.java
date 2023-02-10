package 김성아.레벨2;

public class 쿼드압축후개수세기 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++)
                answer[arr[i][j]]++;
        }
        if(answer[0]==arr.length*arr.length){
            answer[0]=1;
            return answer;
        }
        else if(answer[1]==arr.length*arr.length){
            answer[1]=1;
            return answer;
        }
        else{
            answer=compression(arr,arr.length,answer,0,0);
            return answer;}
    }
    public int[] compression(int[][]arr,int length,int result[],int x,int y){
        int len=length/2;
        int count=0;
        //종료조건
        if(len==1||length==1)
            return result;
            //실행조건
        else{
            int i_1=arr[x+0][y+0];
            int i_2=arr[x+len][y+0];
            int i_3=arr[x+0][y+len];
            int i_4=arr[x+len][y+len];
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    if(arr[x+i][y+j]==i_1)
                        count++;
                }
            }
            if(count==len*len)
                result[i_1]-=(count-1);
            else{
                compression(arr,len,result,x,y);
            }
            count=0;
            for(int i=len;i<length;i++){
                for(int j=0;j<len;j++){
                    if(arr[x+i][y+j]==i_2)
                        count++;
                }
            }
            if(count==len*len)
                result[i_2]-=(count-1);
            else
                compression(arr,len,result,x+len,y);
            count=0;
            for(int i=0;i<len;i++){
                for(int j=len;j<length;j++){
                    if(arr[x+i][y+j]==i_3)
                        count++;
                }
            }
            if(count==len*len)
                result[i_3]-=(count-1);
            else
                compression(arr,len,result,x,y+len);
            count=0;
            for(int i=len;i<length;i++){
                for(int j=len;j<length;j++){
                    if(arr[x+i][y+j]==i_4)
                        count++;
                }
            }
            if(count==len*len)
                result[i_4]-=(count-1);
            else
                compression(arr,len,result,x+len,y+len);
            return result;
        }
    }
}

package 김성아.레벨2;

public class 단체사진찍기 {
    public static int count;
    public int solution(int n, String[] data) {
        count=0;
        String[][]s_arr=new String[n][];
        for(int i=0;i<n;i++){
            String str=data[i].replaceAll("[^A-Z=><0-9]","");
            s_arr[i]=str.split("");
        }
        String []arr={"A","C","F","J","M","N","R","T"};

        perm(arr,0,8,8,s_arr);
        int answer=count;
        return answer;
    }
    public void perm(String[]arr,int depth,int n,int r,String[][]s_arr){
        if(depth==n){
            int cnt=0;
            for(int i=0;i<s_arr.length;i++){
                int temp1=-1;
                int temp2=-1;
                for(int j=0;j<n;j++){
                    if(s_arr[i][0].equals(arr[j]))
                        temp1=j;
                    if(s_arr[i][1].equals(arr[j]))
                        temp2=j;
                }
                if(s_arr[i][2].equals("=")&&(Math.abs(temp2-temp1)-1)==Integer.parseInt(s_arr[i][3])){
                    cnt++;
                }
                if(s_arr[i][2].equals(">")&&(Math.abs(temp2-temp1)-1)>Integer.parseInt(s_arr[i][3]))
                    cnt++;
                if(s_arr[i][2].equals("<")&&(Math.abs(temp2-temp1)-1)<Integer.parseInt(s_arr[i][3]))
                    cnt++;
                if(cnt!=i+1)
                    break;

            }
            if(cnt==s_arr.length)
                count++;
        }
        else{
            for(int i=depth;i<n;i++){
                swap(arr,i,depth);
                perm(arr,depth+1,n,r,s_arr);
                swap(arr,i,depth);
            }

        }
    }
    public String[] swap(String[]arr,int i,int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}

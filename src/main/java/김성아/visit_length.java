package 김성아;

public class visit_length {
    public int solution(String dirs) {
        int answer = 0;
        char [][]arr1=new char[12][11];
        char [][]arr2=new char[11][12];
        int x=5,y=5;
        for(int i=0;i<dirs.length();i++){
            if(dirs.charAt(i)=='L'){
                if(x-1>=0){
                    if(arr2[x][y+1]=='\u0000'){
                        arr2[x][y+1]='L';
                        answer++;
                    }
                    x-=1;}
            }
            else if(dirs.charAt(i)=='R'){
                if(x+1<=10){
                    if(arr2[x+1][y+1]=='\u0000'){
                        arr2[x+1][y+1]='R';
                        answer++;
                    }
                    x+=1;
                }

            }
            else if(dirs.charAt(i)=='U'){
                if(y+1<=10){
                    if(arr1[x+1][y+1]=='\u0000'){
                        arr1[x+1][y+1]='U';
                        answer++;
                    }

                    y+=1;}
            }
            else {
                if(y-1>=0){
                    if(arr1[x+1][y]=='\u0000'){
                        arr1[x+1][y]='D';
                        answer++;
                    }

                    y-=1;}
            }
        }

        return answer;
    }
}

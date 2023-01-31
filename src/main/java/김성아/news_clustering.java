package 김성아;

import java.util.*;
public class news_clustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        Map<String,Integer>map=new HashMap<>();
        int count=0;
        for(int i=0;i<str1.length()-1;i++){
            String temp="";
            if(96<str1.charAt(i)&&str1.charAt(i)<123)
                temp+=str1.charAt(i);
            else
                continue;
            if(96<str1.charAt(i+1)&&str1.charAt(i+1)<123)
                temp+=str1.charAt(i+1);
            else
                continue;
            System.out.println(temp);
            if(map.get(temp)!=null)
                map.replace(temp,map.get(temp)+1);
            else
                map.put(temp,1);
            count++;
        }
        int x=0;int y=0;
        for(int i=0;i<str2.length()-1;i++){
            String temp="";
            if(96<str2.charAt(i)&&str2.charAt(i)<123)
                temp+=str2.charAt(i);
            else
                continue;
            if(96<str2.charAt(i+1)&&str2.charAt(i+1)<123)
                temp+=str2.charAt(i+1);
            else
                continue;
            System.out.println(temp);
            if(map.get(temp)!=null&&map.get(temp)!=0){
                map.replace(temp,map.get(temp)-1);
                x++;
                count--;
            }
            else
                y++;}
        y+=count+x;
        if(x==0&&y==0)
            return 65536;
        double similarity=(double)x/y*65536;
        return (int)similarity;
    }
}

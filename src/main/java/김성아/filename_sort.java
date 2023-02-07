package 김성아;
import java.util.*;
public class filename_sort {
    public String[] solution(String[] files) {
        Arrays.sort(files,new Comparator<String>(){
            @Override
            public int compare(String str1,String str2){
                String []file1=detach(str1);
                String []file2=detach(str2);
                int headValue=file1[0].compareTo(file2[0]);
                if(headValue==0){
                    int num1=Integer.parseInt(file1[1]);
                    int num2=Integer.parseInt(file2[1]);
                    return num1-num2;
                }
                else return headValue;
            }
            private String[] detach(String str){
                String head="";
                String number="";
                String tail="";
                int i=0;
                for(;i<str.length();i++){
                    if('0'<=str.charAt(i)&&str.charAt(i)<='9'){
                        head+=str.substring(0,i);
                        break;
                    }
                }
                int start=i;
                for(;i<str.length();i++){
                    if(!('0'<=str.charAt(i)&&str.charAt(i)<='9')){
                        number+=str.substring(start,i);
                        break;
                    }
                }
                if(number=="")
                    number+=str.substring(start);
                else{
                    tail+=str.substring(i);
                }
                String[] file={head.toLowerCase(),number,tail};
                return file;
            }
        });
        return files;
    }
}

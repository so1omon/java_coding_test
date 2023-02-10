package 김성아.레벨2;

public class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer =new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long l_num=numbers[i];
            if(l_num%2==0){
                answer[i]=l_num+1;
            }
            else{
                String num=Long.toBinaryString(l_num);
                int j;
                String str1="";
                String str2="";
                for(j=num.length()-1;j>=0;j--){
                    if(num.charAt(j)=='0'){
                        str2=num.substring(j+1);
                        str2=str2.replace('1','0');
                        num='1'+str2;
                        //System.out.println(num);
                        break;
                    }
                }
                if(j==-1){
                    num=num.replace('1','0');
                    num='1'+num;}
                //System.out.println(num);
                long num1=Long.valueOf(num,2);
                answer[i]=((l_num+num1)-(num1/2));
            }
        }
        return answer;
    }
}

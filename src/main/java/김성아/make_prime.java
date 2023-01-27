package 김성아;
import java.util.*;
public class make_prime {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];//폐기해야할 날만 값 저장
        int count=0;
        //오늘 날짜 정수로 변환해서 today_arr에 넣기
        today=today.replace(".","");
        int []today_int=new int[3];//오늘 날짜 년,월,일 순으로 저장
        today_int[0]=Integer.parseInt(today.substring(0,4));
        today_int[1]=Integer.parseInt(today.substring(4,6));
        today_int[2]=Integer.parseInt(today.substring(6,8));
        //알파벳 수만큼 배열 만들어서 index가 A=0~Z=25로 할당
        int alph[]=new int[26];
        for(String str:terms){
            String term_arr[]=str.split(" ");
            int pos=(int)term_arr[0].charAt(0)-65;
            alph[pos]=Integer.parseInt(term_arr[1]);//각 알파벳에 할당된 인덱스에 개월수 저장
        }
        for(int i=0;i< privacies.length;i++){
            String str=privacies[i];
            str=str.replace(".","");
            int pri_int[]=new int[3];//privacies 날짜 년,월,일 순으로 저장
            pri_int[0]=Integer.parseInt(str.substring(0,4));//년도 저장
            pri_int[1]=Integer.parseInt(str.substring(4,6));//월 저장
            String split_ns=str.substring(6,10);//privacies에서 마지막에 숫자와 알파벳 분리용
            String div_arr[]=split_ns.split(" ");
            pri_int[2]=Integer.parseInt(div_arr[0].substring(0,2));
            int period= (alph[(int)div_arr[1].charAt(0)-65])*28;//저장 가능한 기간(단위:일)
            int temp=today_int[0]-pri_int[0];//오늘 년도-약관동의 년도
            temp=today_int[1]+(temp*12);//위에서 뺀값을 오늘 월에 저장
            temp-=pri_int[1];//약관 동의 월 빼기
            temp=today_int[2]+(temp*28);//위의값 오늘 일에 더함
            int result = temp - pri_int[2];//오늘 날짜에서 약관 동의날짜 사이의 기간(단위:일) 저장
            if(result>=period){//저장 가능한 기간보다 크면 폐기해야 하므로 저장
                answer[i]=i+1;//첫번째 값을 1로 지정했으므로 1더해서 저장
                count++;
            }
        }
        int arr[]=new int[count];
        int p=0;
        for(int k:answer){
            if(k>0)
                arr[p++]=k;
        }
        return arr;
    }


}

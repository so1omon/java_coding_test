package 김성아;

public class new_id_rec {
    public static String solution(String new_id) {
        String answer="";
        answer = new_id.toLowerCase();
        answer=answer.replaceAll("[^0-9a-z._-]","");;
        answer=answer.replaceAll("[.]{2,}",".");
        System.out.println("answer = " + answer);
        if(answer.length()>0&&answer.charAt(0)=='.'){
            answer = answer.substring(1);
            System.out.println("answer = " + answer);//확인차
        }
        if(answer.length()>0&&answer.charAt(answer.length()-1)=='.'){
            answer=answer.substring(0,answer.length()-1);
            System.out.println("answer = " + answer);//확인차
        }
        if(answer.length()==0){
            answer="a";
        }
        if(answer.length()>15){
            answer=answer.substring(0,15);
            if(answer.charAt(answer.length()-1)=='.'){
                answer=answer.substring(0,answer.length()-1);
                System.out.println("answer = " + answer);//확인차
            }
        }

        if(answer.length()<3){
            while(answer.length()<3)
                answer+=(answer.charAt(answer.length()-1));}
        return answer;
    }

    public static void main(String[] args) {
        String new_id="...!@BaT#*..y.abcdefgh.ijklm";
        String result = solution(new_id);
        System.out.println("result = " + result);
    }
}

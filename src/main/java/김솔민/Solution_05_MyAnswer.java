package 김솔민;

public class Solution_05_MyAnswer {
    public String solution(String new_id){
        new_id = new_id.toLowerCase()
                .replaceAll("[^a-z0-9-_.]","")
                .replaceAll("\\.+",".")
                .replaceAll("^[.]|[.]$","");


        new_id.length();
        System.out.println(new_id);
        return "";
    }

    public static void main(String[] args) {
        Solution_05_MyAnswer sol = new Solution_05_MyAnswer();

        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}

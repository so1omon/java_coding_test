package 김솔민;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/72410
 *  Solution using regex plus replaceAll()
 *  2022/12/30
 *
 *  <Memo>
 *  replace(targetString, replacement) : targetString과 일치하는 문자열을 replacement로 모두 교체하여 리턴
 *      실제 문자열에는 영향을 미치지 않음
 *  replaceAll(regex, replacement) : regex 정규 표현식과 일치하는 문자열을 replacement로 모두 교체하여 리턴
 *      replace와 동일하게 실제 문자열에는 영향을 미치지 않음
 *      substring() 메소드도 마찬가지로 실제 문자열에 영향을 미치지 않음
 *
 *  alphabet 판별 : Character.isAlphabetic()
 *  숫자 판별 : Character.isDigit()
 *
 *  인덱스에 접근할 때는 항상 문자열의 길이 condition(비어 있는지 등)을 따지기
 *  </Memo>
 */
class Solution_05_1 {
    public String solution(String new_id) {
        //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]","")
                .replaceAll("\\.+", ".")
                .replaceAll("^[.]|[.]$", "");

        //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.isEmpty()){
            new_id+="a";
        }

        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15)
                    .replaceAll("[.]$","");

        }

        //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(new_id.length()<=2){
            new_id+=new_id.charAt(new_id.length()-1);
        }

        return new_id;
    }

    public static void main(String[] args) {

        Solution_05_1 sol = new Solution_05_1();
        System.out.print(sol.solution(	"abcdefghijklmn.p"));
    }
}

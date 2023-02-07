package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * 2023/02/07
 *
 *
 * <Memo>
 *   Comparator return값에 따른 차이
 *      양수: 우선순위에 따라 오름차순
 *      음수: 우선순위에 따라 내림차순
 *      0: 건드리지 않음
 * </Memo>
 */

class Solution_17_3차_파일명_정렬_실패_stable정렬_적용후성공 {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        // 0. File 저장하는 리스트 생성
        List<File> fileList = new ArrayList<>();

        // 1. files를 돌기
        for(String file : files){
            // 2. file명을 돌면서 숫자가 나오는 인덱스들의 범위를 찾아서, substring
            int startIdx=0;
            int endIdx=0;

            for(int i=0;i<file.length();i++){
                char target = file.charAt(i);
                if (target>= '0' && target<='9'){
                    // 맨 처음으로 들어온 숫자면 startIdx, endIdx 둘다 초기화시키기
                    if(startIdx==0){
                        startIdx=i;
                        endIdx = i;
                    }
                    // 연속된 최대 5개의 숫자까지만 Number
                    else{
                        if(endIdx-startIdx==4){
                            break;
                        }
                        endIdx++;
                    }
                }else{ // 끊어진 Number 감지
                    if(endIdx!=0){
                        break;
                    }
                }
            }
            // 2-1. HEAD, NUMBER, TAIL로 구분
            // 3. List<File>에 저장
            String HEAD = file.substring(0,startIdx);
            String NUMBER = file.substring(startIdx, endIdx+1 );
            String TAIL=file.substring(endIdx+1);

            fileList.add(new File(HEAD, NUMBER, TAIL));
        }

        fileList.sort(new Comparator<File>(){
            @Override
            public int compare(File f1, File f2){
                // 정렬 순서 1. HEAD
                int firstComp = (f1.HEAD).compareToIgnoreCase(f2.HEAD);

                if(firstComp!=0){
                    return firstComp;
                }

                int f1ToNum = Integer.parseInt(f1.NUMBER);
                int f2ToNum = Integer.parseInt(f2.NUMBER);
                if(f1ToNum>f2ToNum){
                    return 1;
                }else if(f1ToNum<f2ToNum){
                    return -1;
                }

                return 1;
            }
        });

        // 4. 위 array를 정렬한 후, answer에 담아서 리턴
        int idx=0;
        for(File file : fileList){
            System.out.println(file);
            answer[idx++]=file.toString();
        }


        return answer;
    }

    class File{
        public String HEAD;
        public String NUMBER;
        public String TAIL;

        public File(String HEAD,String NUMBER,String TAIL){
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
            this.TAIL = TAIL;
        }

        @Override
        public String toString(){
            return HEAD+NUMBER+TAIL;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_17_3차_파일명_정렬_실패_stable정렬_적용후성공().solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
    }
}

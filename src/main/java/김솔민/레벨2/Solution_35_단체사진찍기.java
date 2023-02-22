package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * 2023/02/22
 *
 *
 * <Memo>
 * </Memo>
 */
class Solution_35_단체사진찍기 {
    int answer;
    Map<String, List<Integer>> map = new HashMap<>();

    public int solution(int n, String[] data) {
        answer= 0;
        // 1. 각각의 프렌즈들에 대한 간격 정보를 담고 있는 Map<String, List<Integer>> 생성
        // 1-1. List 초기값은 0,1,2,3,4,5,6 (2명 사이의 사람들 수이므로)


        // 2. 각각의 data를 파싱해서 Map 조건 추가
        // 2-1. Map 안의 List가 비게 된다면 즉시 solution 종료 (return 0)
        // 2-2. Couple 프렌즈 정보를 정렬해서 String으로 담기
        for(String d : data){
            char[] splitted = d.toCharArray();
            String couple = "";
            if(splitted[0]>splitted[2]){
                couple += splitted[0];
                couple += splitted[2];
            }else{
                couple += splitted[2];
                couple += splitted[0];
            }

            List<Integer> possible =
                map.getOrDefault(couple, new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6)));

            int targetNum = splitted[4]-'0';
            switch(splitted[3]){
                case '=':
                    possible.removeIf(friend->(
                        friend!=targetNum
                    ));
                    break;
                case '>':
                    possible.removeIf(friend->(
                        friend<=targetNum
                    ));
                    break;
                case '<':
                    possible.removeIf(friend->(
                        friend>=targetNum
                    ));
                    break;
                default:
                    break;
            }
            if(possible.size()==0){
                return 0;
            }else{
                map.put(couple, possible);
            }
        }

        // 3. 전체 경우의 수에서 Map 안의 조건들을 하나씩 선택하면서 경우의 수 뺴기

        String[] keyArr = map.keySet().toArray(new String[map.size()]);
        Couple[] coupleList = new Couple[map.size()];
        dfs(keyArr, keyArr.length, 0, coupleList);

        return answer;
    }


    void dfs(String[] keyArr, int n, int depth, Couple[] coupleList){
        if(depth==n){
            allCase(coupleList, 0, coupleList.length, "        ".toCharArray());
            return;
        }
        List<Integer> targetList = map.get(keyArr[depth]);

        for(int i=0;i<targetList.size();i++){
            coupleList[depth] = new Couple(keyArr[depth], targetList.get(i));
            dfs(keyArr, n, depth+1, coupleList);
        }
    }

    // depth : 탐색 수
    // n : coupleList 크기
    void allCase(Couple[] coupleList, int depth, int n, char[] slot){

        // 탈출조건
        if(depth==n){
            int total = 1;
            int empties = findEmptyAreas(slot);
            while(empties>1){
                total*=empties--;
            }
            answer+=total;
            return;
        }

        Couple targetCouple = coupleList[depth];
        int target;
        int foundIdx = indexOfArr(slot, targetCouple.friends[0]);
        target = 1;
        if(foundIdx==-1){
            foundIdx = indexOfArr(slot, targetCouple.friends[1]);
            target = 0;
        }
        // 만약 slot에서 찾으면 그 자리에서 두 가지 경우 실행
        // 그렇지 않으면 empty slot에 대해 모두 실행
        if(foundIdx==-1){ // empty slot들에 대해 실행
            for(int i=0;i<8;i++){
                if(slot[i]==' '){
                    slot[i] = targetCouple.friends[0];
                    int leftIdx = i + targetCouple.distance+1;
                    int rightIdx = i - targetCouple.distance-1;
                    if(leftIdx <8 && slot[leftIdx]==' '){
                        slot[leftIdx] = targetCouple.friends[1];
                        allCase(coupleList, depth+1, n, slot);
                        slot[leftIdx] = ' ';
                    }
                    if(rightIdx >=0 && slot[rightIdx]==' '){
                        slot[rightIdx] = targetCouple.friends[1];
                        allCase(coupleList, depth+1, n, slot);
                        slot[rightIdx] = ' ';
                    }
                    slot[i] = ' ';
                }
            }
        }else{ // 찾았을때
            int leftIdx = foundIdx + targetCouple.distance+1;
            int rightIdx = foundIdx - targetCouple.distance-1;

            if(leftIdx <8 && slot[leftIdx]==' '){
                slot[leftIdx] = targetCouple.friends[target];
                allCase(coupleList, depth+1, n, slot);
                slot[leftIdx] = ' ';
            }
            if(rightIdx >=0 && slot[rightIdx]==' '){
                slot[rightIdx] = targetCouple.friends[target];
                allCase(coupleList, depth+1, n, slot);
                slot[rightIdx] = ' ';
            }
        }

    }

    class Couple{
        char[] friends = new char[2];
        int distance;

        Couple(String c, int d){
            this.distance = d;
            this.friends = c.toCharArray();
        }
    }

    int indexOfArr(char[] arr, char c){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == c){
                return i;
            }
        }
        return -1;
    }

    int findEmptyAreas(char[] arr){
        int empties = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == ' '){
                empties++;
            }
        }
        return empties;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"A~C=0", "C~F=0","F~J=0"};
        System.out.println(new Solution_35_단체사진찍기().solution(n, data));
    }
}

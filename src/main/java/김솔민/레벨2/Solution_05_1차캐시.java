package 김솔민.레벨2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/17680
 * Solution using Queue and LinkedList
 * 2023/01/30
 *
 *
 * <Memo>
 *   - Queue Method -
 *      q.offer(something) : queue의 맨 뒤에 삽입, 꽉 차면 false 반환
 *      q.add(something) : queue의 맨 뒤에 삽입, 꽉 차면 IllegalStateException throws
 *      q.poll() : queue의 맨 앞의 값 반환, 비어 있으면 null
 *      q.remove([Object]) :
 *          Object가 존재하면, queue에서 객체를 찾아 삭제
 *          Object가 존재하지 않으면, queue의 맨 앞의 값 반환
 *          비어 있으면 NoSuchElementException throws
 *
 * </Memo>
 */
class Solution_05_1차캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // 1. cacheQueue 생성
        Queue<String> cache = new LinkedList<>();

        // 2. cities를 순회하기
        for(String city : cities){
            // 2-1. city가 cacheQueue안에 존재하면 answer 1증가
            String upperized = city.toUpperCase();

            // <주의>cache hit인 경우 해당 cache를 맨뒤로 넣어줘야함
            if(cache.contains(upperized)){
                cache.remove(upperized);
                cache.offer(upperized);
                answer++;
            }else{// 3. city가 cacheQueue안에 존재하지 않는 상황이면?
                cache.offer(upperized);
                answer+=5;
                // 3-1. cacheQueue가 꽉찼으면 맨앞에 있는거 삭제하고,
                //      지금들어온거 넣고, answer 5증가
                if(cache.size()>cacheSize)
                    cache.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution_05_1차캐시 solution051차캐시 = new Solution_05_1차캐시();
        int cacheSize = 3;

        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution051차캐시.solution(cacheSize,cities));
    }
}

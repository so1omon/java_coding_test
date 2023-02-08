package 김솔민.레벨2;
import java.util.*;
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * Solution using
 * 2023/02/08
 *
 *
 * <Memo>
 *   Array deepcopy
 *      int[] arr = {1,2,3,4,5};
 *      int[] copyArr = Arrays.copyOf(arr, arr.length);
 * </Memo>
 */
class Solution_19_방문_길이 {
    public int solution(String dirs) {
        int answer = 0;

        // 0. "x1y1x2y2" 이력을 나타내는 String을 담는 List 생성, 현재 좌표 잡기
        List<String> visited = new ArrayList<>();

        int[] cord = {0, 0};

        for (char dir : dirs.toCharArray()) {
            // 1. dirs를 돌면서, 어떠한 방향이 주어지면 그쪽 방향으로 갔다는 이력을 남기고,
            //    도착지 좌표에서는 그 반대 방향의 이력을 남긴다.
            // 1-1. 현재 좌표가 dir에 의해 좌표계에 벗어나는 행동이 감지되면 그 즉시 continue
            // 1-2. 만약 이미 이력이 존재할 경우, 이력을 남기지 않는다.
            // 1-3. 이력이 존재하지 않을 경우, answer++
            int[] originCord = Arrays.copyOf(cord, cord.length);

            switch (dir) {
                case 'L':
                    cord[0]--;
                    break;
                case 'R':
                    cord[0]++;
                    break;
                case 'U':
                    cord[1]++;
                    break;
                case 'D':
                    cord[1]--;
                    break;
                default:
                    break;
            }
            // 좌표계 벗어남, 원래 좌표로 복귀
            if (cord[0] < -5 || cord[0] > 5 || cord[1] < -5 || cord[1] > 5) {
                cord[0] = originCord[0];
                cord[1] = originCord[1];
                continue;
            }
            String visit1 = Arrays.toString(originCord) + Arrays.toString(cord);
            if (visited.contains(visit1)) {
                continue;
            } else {
                answer++;
                String visit2 = Arrays.toString(cord) + Arrays.toString(originCord);
                visited.add(visit1);
                visited.add(visit2);
            }
        }

        return answer;
    }
    public static void main(String[] args) {

    }
}

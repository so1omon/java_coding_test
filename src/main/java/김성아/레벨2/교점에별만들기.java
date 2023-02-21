package 김성아.레벨2;
import java.util.*;

public class 교점에별만들기 {
    static int startX = Integer.MAX_VALUE;
    static int endX = Integer.MIN_VALUE;
    static int startY = Integer.MAX_VALUE;
    static int endY = Integer.MIN_VALUE;

    public String[] solution(int[][] line) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<line.length-1; i++) {
            for(int j=i+1; j<line.length; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                long div = (a * d) - (b * c);
                if(div == 0) continue;
                long numerator1 = (b * f) - (e * d);
                long numerator2 = (e * c) - (a * f);
                if(numerator1 % div != 0 || numerator2 % div != 0) continue;

                int x  = (int) (numerator1 / div);
                int y = (int) (numerator2 / div);

                List<Integer> temp = Arrays.asList((int) x, (int) y);
                if(!list.contains(temp)) list.add(temp);

                startX = Math.min(startX, (int) x);
                endX = Math.max(endX, (int) x);
                startY = Math.min(startY, (int) y);
                endY = Math.max(endY, (int) y);
            }
        }

        List<String> board = new ArrayList<>();
        for(int i=startY; i<=endY; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=startX; j<=endX; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }

        for(List<Integer> intersection : list) {
            StringBuilder sb = new StringBuilder(board.get(Math.abs(intersection.get(1) - endY)));
            sb.setCharAt(Math.abs(intersection.get(0) - startX), '*');
            board.set(Math.abs(intersection.get(1) - endY), sb.toString());
        }

        String[] answer = new String[board.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = board.get(i);
        }

        return answer;
    }
}

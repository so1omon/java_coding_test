package 김성아.레벨1;

public class inner_mul {
    public int solution(int[] a, int[] b) {
        int answer =0;
        for(int i=0;i<a.length;i++)
            answer+=(a[i]*b[i]);
        return answer;
    }
}

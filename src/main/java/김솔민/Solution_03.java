package 김솔민;

import java.util.HashSet;
import java.util.Iterator;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * Solution using Recursive
 */
class Solution_03 {

    HashSet<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;

        //1. 소수 찾는 메소드 따로 만들기

        //2. numbers를 한 숫자씩 쪼개서 만들 수 있는 모든 숫자 배열 만들기 (HashSet + Recursive)
        recursive("", numbers);
        //3. 숫자 배열을 순회하면서 소수인 숫자들을 발견할 때마다 answer++

        //Iterator를 사용하면 다양한 자료구조에서 loop를 돌 수 있음
        Iterator<Integer> iter = numberSet.iterator();

        while(iter.hasNext()){

            if(isPrime(iter.next())){
                answer++;
            }
        }



        return answer;
    }

    public void recursive(String comb, String others){
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));

        for(int i=0;i<others.length();i++){
            recursive(comb+others.charAt(i),others.substring(0,i)+others.substring(i+1));
        }
    }
    public boolean isPrime(int num){
        if(num == 0 || num ==1){
            return false;
        }

        int limit = (int)Math.sqrt(num);

        for(int i=2;i<=limit;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String numbers = "17";
        Solution_03 sol = new Solution_03();
        System.out.print(sol.solution(numbers));
    }
}

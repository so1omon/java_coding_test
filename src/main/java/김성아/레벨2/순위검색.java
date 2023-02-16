package 김성아.레벨2;
import java.util.*;
public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<24;i++)
            list.add(new ArrayList<>());
        for(int i=0;i<info.length;i++){
            int index=0;
            String[] str=info[i].split(" ");
            switch(str[0]){
                case "cpp":
                    break;
                case "java":
                    index+=8;
                    break;
                case "python":
                    index+=16;
                    break;
            }
            switch(str[1]){
                case "backend":
                    break;
                case "frontend":
                    index+=4;
                    break;
            }
            switch(str[2]){
                case "junior":
                    break;
                case "senior":
                    index+=2;
                    break;
            }
            switch(str[3]){
                case "chicken":
                    break;
                case "pizza":
                    index+=1;
                    break;
            }
            list.get(index).add(Integer.valueOf(str[4]));
        }
        for(int i=0;i<list.size();i++){
            Collections.sort(list.get(i));
        }
        for(int i=0;i<query.length;i++){
            query[i]=query[i].replace("and","");
            query[i]=query[i].replaceAll("\\s+"," ");
            String []str=query[i].split(" ");
            List<Integer>f_e=new ArrayList<>();
            switch(str[0]){
                case "cpp":
                    f_e.add(0);
                    break;
                case "java":
                    f_e.add(8);
                    break;
                case "python":
                    f_e.add(16);
                    break;
                default:
                    f_e.add(0);
                    f_e.add(8);
                    f_e.add(16);
            }
            int f_e_size=f_e.size();
            switch(str[1]){
                case "backend":
                    break;
                case "frontend":
                    for(int j=0;j<f_e_size;j++)
                        f_e.set(j,f_e.get(j)+4);
                    break;
                default:
                    for(int j=0;j<f_e_size;j++){
                        f_e.add(f_e.get(j)+4);
                    }
            }
            f_e_size=f_e.size();
            switch(str[2]){
                case "junior":
                    break;
                case "senior":
                    for(int j=0;j<f_e_size;j++)
                        f_e.set(j,f_e.get(j)+2);
                    break;
                default:
                    for(int j=0;j<f_e_size;j++){
                        f_e.add(f_e.get(j)+2);
                    }
            }
            f_e_size=f_e.size();
            switch(str[3]){
                case "chicken":
                    break;
                case "pizza":
                    for(int j=0;j<f_e_size;j++)
                        f_e.set(j,f_e.get(j)+1);
                    break;
                default:
                    for(int j=0;j<f_e_size;j++){
                        f_e.add(f_e.get(j)+1);
                    }
            }
            for(int k=0;k<f_e.size();k++){
                int t=f_e.get(k);
                answer[i]+=sorting(Integer.parseInt(str[4]),list.get(t));
                /*for(int j=0;j<list.get(t).size();j++){
                    if(list.get(t).get(j)>=Integer.parseInt(str[4]))
                        answer[i]++;
                }*/
            }
        }

        return answer;
    }
    public int sorting(int score,List<Integer>arr){
        int f = 0, e = arr.size() - 1;
        while (f <= e) {
            int mid = (f + e) / 2;
            if (arr.get(mid) < score)
                f = mid + 1;
            else
                e = mid - 1;
        }
        return arr.size() - f;
    }

}

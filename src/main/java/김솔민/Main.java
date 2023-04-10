package 김솔민;
import java.io.*;
import java.util.*;
import java.io.*;

import java.util.*;

public class Main {

    public int solution(String word, String[] pages) {
        int answer = 0;
        double maxValue = 0.0;
        Map<String, Html> map = new HashMap<>();
        Matcher url_matcher, word_matcher, home_url_matcher;
        Pattern home_url_pattern = Pattern.compile("<meta property=\"og:url\" content=\"(\\S*)\"");
        Pattern url_pattern = Pattern.compile("<a href=\"https://(\\S*)\"");
        Pattern word_pattern = Pattern.compile("\\b(?i)"+word+"\\b");


        for(int i=0;i<pages.length;i++){
            String page = pages[i];
            url_matcher = url_pattern.matcher(page);
            String home_url = "";
            home_url_matcher = home_url_pattern.matcher(pages[i]);

            List<String> ext_urls = new ArrayList<>();
            while(url_matcher.find()) {
                ext_urls.add(url_matcher.group().split("\"")[1]);
            }

            if(home_url_matcher.find()){
                home_url = home_url_matcher.group().split("=")[2].replaceAll("\"", "");
            }

            Html html = new Html(page, word, i, home_url, ext_urls);
            map.put(html.link, html);
        }

        for(String key : map.keySet()){
            Html html = map.get(key);

            for(String outerLink : html.outerLinks){
                if(map.containsKey(outerLink)){
                    map.get(outerLink).linked.add(html.link);
                }
            }
        }
        List<String> newKeys = new ArrayList<>(map.keySet());
        newKeys.sort((a,b)->{
            return map.get(a).idx - map.get(b).idx;
        });

        for(String key : newKeys){
            Html html = map.get(key);

            double temp = 0.0;
            for(String linkedLink : html.linked){
                temp += map.get(linkedLink).linkValue;
            }

            temp += (double)html.value;


            if(maxValue<temp){
                maxValue = temp;
                answer = html.idx;
            }
        }


        return answer;
    }
    class Html{
        String link;
        double value;
        double linkValue;
        int idx;
        List<String> outerLinks = new ArrayList<>();
        List<String> linked = new ArrayList<>();

        Html(String html, String comp, int idx, String home_url, List<String> ol){
            String body = html.split("<body>")[1].split("</body>")[0].replaceAll("[0-9]", " ");
            this.idx = idx;
            this.value = (int)countMatch(body, comp);
            this.link = home_url;
            this.outerLinks = ol;
            this.linkValue = value/outerLinks.size();
        }

    }

    int countMatch(String origin, String comp){
        int cnt = 0;
        origin = origin.toLowerCase();
        comp = comp.toLowerCase();

        String newOrigin = origin.replaceAll("[^a-zA-z]", " ");
        String[] split = newOrigin.split(" ");

        for(String s : split){
            if(s.equals(comp)){
                cnt++;
            }
        }
        return cnt;
    }

}
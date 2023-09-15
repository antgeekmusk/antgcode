package com.antg.spider;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import lombok.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
* @author:Antg
* @create: 2023/9/13
* @Description: because learn english,need some words,so get words from web,only use learn
*/
public class WordsSpider {
    public static void main(String[] args) throws Exception{
        List<Word> res = new ArrayList<>();
        String filePath="~/cet6_words.txt";
        String url="http://danci.gjcha.com/cet6_list/";
        Document doc = Jsoup.connect(url).get();
        Elements words = doc.select("#main_container > div > div.col-md-9 > div > div > div > div.word_list > a");

        // 爬取100个就暂停1-10秒
        int index=0;
        for (Element e : words) {
            Word word = Word.builder().word(e.text()).build();
            getWordDetail(word);
            appendToFile(word.toString(),filePath);
            index++;
            if(index%100==0){
                int stopRandom=new Random().nextInt(10)+1;
                System.out.println("stop : "+stopRandom+" second ");
                Thread.sleep(stopRandom*1000);
                System.out.println("get data size : "+index);
            }
        }
    }

    public static void getWordDetail(Word word){
        try {
            String url = "http://danci.gjcha.com/" + word.getWord().replace("-", "____").replace(".","____") + ".html";
            Document document = Jsoup.connect(url).get();
            String explain = document.select("#main_container > div > div.col-md-9 > div > div > div.danci_info > p:nth-child(4)").text();
            String pronounce = document.select("#main_container > div > div.col-md-9 > div > div > div.danci_info > div.yinbiao > p:nth-child(3) > span:nth-child(3)").text();
            word.setExplain(explain);
            word.setPronounce(pronounce);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void appendToFile(String word,String filePath){
        FileUtil.appendString(word,filePath, CharsetUtil.CHARSET_UTF_8);
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    static class Word{
        String word;// 单词
        String explain;// 含义
        String pronounce;// 发音

        @Override
        public String toString() {
            return word + " | "
                    +pronounce + " | "
                    +explain + "\n"
                    ;
        }
    }
}

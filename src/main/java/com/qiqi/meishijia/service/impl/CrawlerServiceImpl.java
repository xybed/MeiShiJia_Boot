package com.qiqi.meishijia.service.impl;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.qiqi.meishijia.mapper.FootballPlayerMapper;
import com.qiqi.meishijia.mapper.PCategoryCustomMapper;
import com.qiqi.meishijia.model.FootballPlayer;
import com.qiqi.meishijia.model.PCategory;
import com.qiqi.meishijia.service.CommonService;
import com.qiqi.meishijia.service.CrawlerService;
import lib.utils.FileUtil;
import lib.utils.NumberUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrawlerServiceImpl implements CrawlerService {

    @Resource
    private CommonService commonService;
    @Resource
    private FootballPlayerMapper footballPlayerMapper;
    @Resource
    private PCategoryCustomMapper pCategoryCustomMapper;

    @Override
    public void getPlayerData() {
        Document document = getDocumentByHtml(getHtml("http://soccer.stats.qq.com/team.htm?t1=953&from=xijia"));

        Element layout = document.select("div.team-main").first();
        Element fr = layout.select("div.p-sidebar").first();
        Element playerMember = fr.select("div.mod-struct").get(1);
        Element bd = playerMember.select("div.bd").first();
        Elements divs = bd.select("div.mod-format");
        for(Element div : divs){
            Elements lis = div.select("ul.player-list").first().select("li");
            for(Element li : lis){
                String urlDetail = li.select("a").first().attr("href");
                getPlayerDetail(urlDetail);
            }
        }
    }

    private Document getDocument(String url){
        Document document = null;
        try {
            document = Jsoup.connect(url)
                    .timeout(10000)
                    .get();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return document;
    }

    private Document getDocumentByHtml(String html){
        return Jsoup.parse(html);
    }

    private String getHtml(String url){
        String html = "";
        try {
            WebClient webClient = new WebClient(BrowserVersion.CHROME);
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            //模拟浏览器打开一个目标网址
            HtmlPage rootPage = webClient.getPage(url);
            Thread.sleep(3000);//主要是这个线程的等待 因为js加载也是需要时间的
            html = rootPage.asXml();
        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
        }
        return html;
    }

    private void getPlayerDetail(String url){
        Document document = getDocumentByHtml(getHtml(url));

        FootballPlayer player = new FootballPlayer();
        player.setTeamId(10);

        Element mod1 = document.select("div.info-panel").first()
                .select("div[node-type=basicInfo]").first()
                .select("div.mod1").first();
        Element img = mod1.select("img").first();
        String downloadUrl = img.attr("src");
        System.out.println("球员头像链接："+downloadUrl);
        //下载图片
        String wayPath = commonService.getApplicationPath() + "\\images\\player\\";
        FileUtil.mkdir(wayPath);
        //从url中获取图片名称
        URI wayUri = URI.create(downloadUrl);
        String wayUriPath = wayUri.getPath();
        wayUriPath = wayUriPath.substring(wayUriPath.lastIndexOf("/")+1, wayUriPath.length());
        System.out.println("储存路径："+wayPath+wayUriPath);
        //下载图片
        FileUtil.downloadImage(downloadUrl, wayPath + wayUriPath);
        player.setAvatar("images/player/"+wayUriPath);
        System.out.println("球员头像："+player.getAvatar());

        Element en = mod1.select("div.fl").first()
                .select("div.mt15").first()
                .select("p.en").first();
        player.setEngName(en.text());
        System.out.println("球员英文名："+player.getEngName());

        Element span = mod1.select("div.fl").first()
                .select("ul.team-number").first()
                .select("li:not([^style])").first()
                .select("span").first();
        System.out.println(span.text());
        player.setNumber(NumberUtil.parseInt(span.text().substring(0, span.text().length()-1), 0));
        System.out.println("球员号码："+player.getNumber());

        Elements lis = document.select("div.info-panel").first()
                .select("div[node-type=basicInfo]").first()
                .select("div.mod2").first()
                .select("div.bd").first()
                .select("ul").first()
                .select("li");
        for(int i=0;i<lis.size();i++){
            Element li = lis.get(i);
            switch (i){
                case 0:
                    String name = li.text().substring(3);
                    player.setName(name);
                    System.out.println("球员中文名："+player.getName());
                    break;
                case 1:
                    double height = NumberUtil.parseDouble(li.text().substring(3, li.text().lastIndexOf("cm")), 0);
                    player.setHeight(new BigDecimal(height));
                    System.out.println("球员身高："+player.getHeight());
                    break;
                case 2:
                    double weight = NumberUtil.parseDouble(li.text().substring(3, li.text().lastIndexOf("kg")), 0);
                    player.setWeight(new BigDecimal(weight));
                    System.out.println("球员体重："+player.getWeight());
                    break;
                case 3:
                    String nationality = li.text().substring(3);
                    player.setNationality(nationality);
                    System.out.println("球员国籍："+player.getNationality());
                    break;
                case 4:
                    String birthday = li.text().substring(3);
                    player.setBirthday(birthday);
                    System.out.println("球员生日："+player.getBirthday());
                    break;
                case 5:
                    String playPosition = li.text().substring(3);
                    player.setPlayPosition(playPosition);
                    System.out.println("球员位置："+player.getPlayPosition());
                    break;
            }
        }

        footballPlayerMapper.insertSelective(player);
    }
}

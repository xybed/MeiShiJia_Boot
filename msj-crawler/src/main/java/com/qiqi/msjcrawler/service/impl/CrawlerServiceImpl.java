package com.qiqi.msjcrawler.service.impl;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.qiqi.commonconfig.common.Constants;
import com.qiqi.commonlib.utils.ClassPathUtil;
import com.qiqi.commonlib.utils.FileUtil;
import com.qiqi.commonlib.utils.NumberUtil;
import com.qiqi.msjcrawler.service.CrawlerService;
import com.qiqi.msjmapper.entity.FootballPlayer;
import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.entity.ProductCategory;
import com.qiqi.msjmapper.entity.ProductImage;
import com.qiqi.msjmapper.enums.ProductStatus;
import com.qiqi.msjmapper.mapper.FootballPlayerMapper;
import com.qiqi.msjmapper.mapper.ProductCategoryMapper;
import com.qiqi.msjmapper.mapper.ProductCustomMapper;
import com.qiqi.msjmapper.mapper.ProductImageCustomMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CrawlerServiceImpl implements CrawlerService {

    @Resource
    private FootballPlayerMapper footballPlayerMapper;
    @Resource
    private ProductCustomMapper productCustomMapper;
    @Resource
    private ProductCategoryMapper productCategoryMapper;
    @Resource
    private ProductImageCustomMapper productImageCustomMapper;

    private int categoryId;

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

    @Override
    public void getProductData(String html, int categoryId) {
        this.categoryId = categoryId;
        Document document = getDocumentFromLocal(html);
        if(document == null)
            return;

        Element ul = document.select("ul").first();
        Elements lis = ul.select("li.gl-item");
        for(Element li : lis){
            Element item = li.select("div.j-sku-item").first();
            //价格
            Element pPrice = item.select("div.p-price").first();
            Element i = pPrice.select("strong.J_price").first()
                    .select("i").first();
            //链接
            Element pImg = item.select("div.p-img").first();
            Element a = pImg.select("a").first();
            String href = a.attr("href");
            if(!href.startsWith("//item.jd.com")){
                Element pCommit = item.select("div.p-commit").first();
                Element aCommit = pCommit.select("a").first();
                href = aCommit.attr("href");
                href = href.substring(0, href.indexOf("#"));
            }
            //备注
            Element pName = item.select("div.p-name").first();
            Element promoWords = pName.select("i").first();

            if("暂无报价".equals(i.text())){
                getProductDetail("https:"+href, "0", promoWords.text());
            }else {
                getProductDetail("https:"+href, i.text(), promoWords.text());
            }
        }
    }

    @Transactional
    @Override
    public void getProductDetail(String url, String price, String remark){
        String pathSuffix = "jsqq/jsqq/";
        String dirSuffix = "jsqq\\jsqq";
        //判断数据库中是否爬过此数据
        Product product = productCustomMapper.queryByUrl(url);
        if(product != null){
            //插入新一条商品和分类数据
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductId(product.getId());
            productCategory.setCategoryId(categoryId);
            productCategoryMapper.insertSelective(productCategory);
            return;
        }

        Document document = getDocumentByHtml(getHtml(url));

        String brand;
        String productName;
        try{
            Element crumbWrap = document.select("div.crumb-wrap").first();
            Element w = crumbWrap.select("div.w").first();
            Element crumb = w.select("div.crumb").first();
            //品牌
            Element item = crumb.select("div.item").get(6);
            Element a = item.select("a").first();
            brand = a.text();
            //商品名称
            Element ellipsis = crumb.select("div.ellipsis").first();
            productName = ellipsis.text();
        }catch (NullPointerException e){
            System.out.println(url);
            brand = "无品牌";
            productName = "无商品名称";
        }

        Element productIntro = document.select("div.product-intro").first();
        Element itemInfoWrap = productIntro.select("div.itemInfo-wrap").first();
        //商品描述
        Element skuName = itemInfoWrap.select("div.sku-name").first();

        Element previewWrap = productIntro.select("div.preview-wrap").first();
        Element specList = previewWrap.select("div.spec-list").first();
        Element ul = specList.select("ul").first();
        //商品图片
        String dir = ClassPathUtil.getApplicationPath() + "\\images\\product\\" + dirSuffix;
        FileUtil.mkdir(dir);
        List<String> imageList = new ArrayList<>();
        Elements lis = ul.select("li");
        for(Element li : lis){
            Element img = li.select("img").first();
            String src = img.attr("src");
            if(src.contains("/s54x54_jfs/")){
                src = src.replace("/s54x54_jfs/", "/s450x450_jfs/");
            }else if(src.contains("/s50x64_jfs/")){
                src = src.replace("/s50x64_jfs/", "/s450x450_jfs/");
                src = src.replace("!cc_50x64.jpg", "");
            }else if(src.contains("/s75x75_jfs/")){
                src = src.replace("/s75x75_jfs/", "/s450x450_jfs/");
            }else{
                src = src.replace("/jfs/", "/s450x450_jfs/");
            }
            src = "https:"+src;
            String path = Constants.IMAGE_BUCKET_PRODUCT + pathSuffix + src.substring(src.lastIndexOf("/")+1, src.length());
            //下载图片
            FileUtil.downloadImage(src, ClassPathUtil.getApplicationPath() + "\\" + path);
            imageList.add(path);
        }

        //插入商品
        product = new Product();
        product.setUrl(url);
        product.setBackUserId(1);
        product.setName(productName);
        product.setDescription(skuName.text());
        if(imageList.size() > 0){
            product.setImage(imageList.get(0));
        }
        product.setPrice(new BigDecimal(price));
        product.setOriginalPrice(new BigDecimal(price));
        product.setDiscountPrice(new BigDecimal(price));
        product.setStock(new Random().nextInt(1000));
        product.setBrand(brand);
        product.setStatus(ProductStatus.SHELF.getCode());
        product.setGmtCreate(new Date());
        product.setRemark(remark);
        productCustomMapper.insertSelective(product);

        //插入商品和分类
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductId(product.getId());
        productCategory.setCategoryId(categoryId);
        productCategoryMapper.insertSelective(productCategory);

        //插入商品和图片
        List<ProductImage> productImageList = new ArrayList<>();
        for(String image : imageList){
            ProductImage productImage = new ProductImage();
            productImage.setProductId(product.getId());
            productImage.setImage(image);
            productImageList.add(productImage);
        }
        if(productImageList.size() > 0)
            productImageCustomMapper.batchInsert(productImageList);
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
            webClient.setJavaScriptTimeout(2000);
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setCssEnabled(false);
            webClient.setAjaxController(new NicelyResynchronizingAjaxController());
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            //模拟浏览器打开一个目标网址
            HtmlPage rootPage = webClient.getPage(url);
            Thread.sleep(2000);//主要是这个线程的等待 因为js加载也是需要时间的
            html = rootPage.asXml();
        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
        }
        return html;
    }

    private Document getDocumentFromLocal(String html){
        File file = new File(ClassPathUtil.getApplicationPath() + html);
        Document document;
        try {
            document = Jsoup.parse(file, "utf-8");
            return document;
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return null;
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
        String wayPath = ClassPathUtil.getApplicationPath() + "\\images\\player\\";
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

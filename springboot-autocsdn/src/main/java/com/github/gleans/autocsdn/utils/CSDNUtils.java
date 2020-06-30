package com.github.gleans.autocsdn.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CSDNUtils {
    //    发送http请求的工具类
    private RestTemplate restTemplate = new RestTemplate();
    private List<String> myAllArticleURL;
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();


    /**
     * 只有调用了getAllArticleUrl才会有
     *
     * @return
     */
    public List<String> getMyAllArticleURL() {
        if (myAllArticleURL == null) {
            getAllArticleUrl("https://blog.csdn.net/Fine_Cui");
        }
        return myAllArticleURL;
    }

    /**
     * 获取博主所有的分类专栏访问地址
     * 例如：https://blog.csdn.net/qq_41813208/
     *
     * @param url
     */
    public List<String> getAllBlogCategoryURL_By_URL(String url) {
        ResponseEntity<String> htmlString = restTemplate.getForEntity(url, String.class);
        String html = htmlString.toString();//将获取的网页转换成字符串
        //获取html元素
        Document doc = Jsoup.parse(html);
        // 获取id=asideCategory的标签,这个标签下存放的是包含分类专栏的标签，缩小范围
        Element asideCategory = doc.getElementById("asideCategory");
        //  获取id=asideCategory的标签下的ul标签
        Elements ultag = asideCategory.getElementsByTag("ul");
        // 获取id=asideCategory的标签下的ul标签的a标签===>这个标签的href存放的就是分类专栏地址
        Elements a = ultag.get(0).getElementsByTag("a");
        List<String> categoryURL = new ArrayList<>();
        //遍历a标签，获取a标签中的href属性值
        for (int i = 0; i < a.size(); i++) {
            String href = a.get(i).attr("href");//获取href属性
            if (!href.isEmpty()) {
                categoryURL.add(i, href);//存入数组中
            }
        }
        System.out.println("总共有" + categoryURL.size() + "个专栏");
        return categoryURL;
    }

    /**
     * 根据分类专栏的地址获取分类专栏下的所有文章
     *
     * @param url
     * @return
     */
    public List<String> getAllArticle_By_CategoryURL(String url) {
        ResponseEntity<String> htmlString = restTemplate.getForEntity(url, String.class);
        String html = htmlString.toString();//将获取的网页转换成字符串
        // 获取html元素
        Document doc = Jsoup.parse(html);
        //1、 获取类名为column_article_list的html标签，这个标签内存放的就是文章的列表
        Elements column_article_list = doc.getElementsByAttributeValue("class", "column_article_list");
        // 获取包含专栏文章的的li元素
        Elements li_s = column_article_list.get(0).getElementsByTag("li");
        List<String> allArticle = new ArrayList<>();//用来存单个专栏下所有文章的链接
        //li标签有很多个，遍历li标签
        for (int i = 0; i < li_s.size(); i++) {
            //获取li中的a标签
            Elements a = li_s.get(i).getElementsByTag("a");
            //获取a标签的href属性
            String href = a.attr("href");
            //如果href元素为空则不存入数组中
            if (!href.isEmpty()) {//不为空则存入数组，有些专栏可能没有文章，所以这里要判断一下
                allArticle.add(href);
            }
        }
        //将存有单个专栏的所有文章链接数组返回
        return allArticle;
    }


    /**
     * 返回所有文章url列表
     * 会存到myAllArticleURL的成员变量上
     *
     * @param url
     * @return
     */
    public List<String> getAllArticleUrl(String url) {
        //调用方法获取所有分类专栏，存入allBlogCategoryURL数组中
        List<String> allBlogCategoryURL = getAllBlogCategoryURL_By_URL(url);
        // allArticleUrl用来存所有文章的链接
        List<String> allArticleUrl = new ArrayList<>();

        //遍历所有专栏
        for (int i = 0; i < allBlogCategoryURL.size(); i++) {
            //调用方法获取分类专栏下的所有文章链接
            List<String> categoryAllArticle = getAllArticle_By_CategoryURL(allBlogCategoryURL.get(i));
            //将分类专栏下的文章加入allArticleUrl数组中
            allArticleUrl.addAll(categoryAllArticle);
        }
        this.myAllArticleURL = allArticleUrl;
        return allArticleUrl;
    }

    /**
     * 访问文章详情，模拟用户点击文章
     *
     * @param url
     */
    public void accessCSDNArticle(String url) {
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
                if (forEntity.getStatusCode() == HttpStatus.OK) {
                    System.out.println(url + "访问成功");
                } else {
                    System.out.println(url + "访问失败");
                }
            }
        });


    }

    /**
     * 前面一次性获取来所有博客链接，并保存了下来。这样就不需要再次发送获取所有文章的请求
     *
     * @param url       传入博主自己的url主页，例如：https://blog.csdn.net/qq_41813208/
     * @param sleepTime 休眠时间，单位秒
     */
    public void autoRefresh(String url, long sleepTime) {
        getAllArticleUrl(url);//获取所有文章链接，文章链接会存在成员变量myAllArticleURL中
        while (true) {
            for (int i = 0; i < myAllArticleURL.size(); i++) {
                if (myAllArticleURL.get(i) != null) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                        accessCSDNArticle(myAllArticleURL.get(i));//访问文章
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                TimeUnit.SECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

package store.zabbix.bran.ekko.utils;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpCustom {

    private final static int CONNECT_TIMEOUT = 3000;
    private final static int SOCKET_TIMEOUT = 3000;

    /**
     * 获取网页信息
     *
     * @param url
     * @param ip
     * @param port
     */
    public static String getIpStore(String url, String ip, Integer port) {

        String resBody = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();

        RequestConfig.Builder configBuilder = RequestConfig
                .custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT);
        if (ip != null && port != null) {
            HttpHost proxy = new HttpHost(ip, port);
            configBuilder.setProxy(proxy);
        }
        RequestConfig config = configBuilder.build();

        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(config);

        httpGet.setHeader("Pragma", "no-cache");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Host", "www.xicidaili.com");
        httpGet.setHeader("Cache-Control", "no-cache");
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch");
        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");

        try {
            //客户端执行httpGet方法，返回响应
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            //得到服务响应状态码
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                resBody = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
            }

            httpResponse.close();
            httpClient.close();
        } catch (IOException e) {
            resBody = null;
        }

        return resBody;
    }

}

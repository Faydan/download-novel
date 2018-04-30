package com.faydan.downloadnovel.utils;

import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentUtils {

    private static final Logger log = LoggerFactory.getLogger(DocumentUtils.class);

    public static Document getDocument(String url) {
        Connection con= Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0; BIDUBrowser 2.x)") // 设置 User-Agent
                .timeout(30000) // 设置连接超时时间
                .ignoreHttpErrors(true)
                .followRedirects(true);
        Document document = null;
        try {
            Connection.Response resp = con.execute();

            if (resp.statusCode() == 200){
                document = con.get();
            }
        } catch (Exception e) {
            log.error("获取document对象失败-> {}", e);
        }

        return document;
    }
}

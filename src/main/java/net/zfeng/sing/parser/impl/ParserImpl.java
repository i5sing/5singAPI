package net.zfeng.sing.parser.impl;

import net.zfeng.sing.parser.IParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by zhaofeng on 16/2/4.
 */
public class ParserImpl implements IParser {
    protected static String SingIdRE = "^/m/detail/\\w+-([0-9]+)-\\d+.html$";
    protected static String UserIdRE = "^/m/space/([0-9]+).html$";

    /**
     * 加载并解析指定url的html
     *
     * @param url
     * @return
     * @throws IOException
     */
    protected Document parserHTML(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    /**
     * 删除html中的其他字符
     *
     * @param str
     * @return
     */
    protected String deleteExtraChar(String str) {
        return str.replaceAll("&nbsp;", "").replaceAll(",", "").replaceAll("<br>", "").replaceAll(" ", "");
    }
}
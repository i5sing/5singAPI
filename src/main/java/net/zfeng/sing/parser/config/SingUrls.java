package net.zfeng.sing.parser.config;

/**
 * Created by zhaofeng on 16/2/5.
 */

public class SingUrls {
    public static String SONG_LIST_URL = "http://5sing.kugou.com/m/list/{type}-{category}-{page}.html";

    private static String generateUrl(String url, SingType type, SingCategory category, int page) {
        String mType = "yc";
        String mCategory = "tj";
        switch (type) {
            case YUANCHUANG:
                mType = "yc";
                break;
            case FANCHANG:
                mType = "fc";
                break;
            case BANZOU:
                mType = "bz";
        }

        switch (category) {
            case TUIJIAN:
                mCategory = "tj";
                break;
            case HOUXUAN:
                mCategory = "hx";
                break;
            case ZIJIAN:
                mCategory = "zj";
                break;
            case ZUIXIN:
                mCategory = "zx";
                break;
            case HOT:
                mCategory = "hot";
                break;
        }
        return url.replace("{type}", mType).replace("{category}", mCategory).replace("{page}", page + "");
    }

    public static String getURL(SingUrl singUrl, SingType type, SingCategory category, int page) {
        String url = "";
        switch (singUrl) {
            case SONG_LIST:
                url = generateUrl(SONG_LIST_URL, type, category, page);
                System.out.println(url);
                break;
        }

        return url;
    }
}

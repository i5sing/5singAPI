package net.zfeng.sing.utils;

import net.zfeng.sing.parser.config.SingCategory;
import net.zfeng.sing.parser.config.SingType;
import net.zfeng.sing.parser.config.SingUrl;

/**
 * Created by zhaofeng on 16/2/5.
 */
public class SingUrls {

    /**
     * 获取5sing url
     *
     * @param singUrl
     * @param type
     * @param category
     * @param page
     * @param songId
     * @return
     */
    public static String getURL(SingUrl singUrl, SingType type, SingCategory category, int page, String songId) {
        String url = singUrl.getText();
        url = url.replace("{type}", type.getText())
                .replace("{page}", page + "");

        if (category != null) {
            url = url.replace("{category}", category.getText());
        }

        if (songId != null) {
            url = url.replace("{songId}", songId);
        }

        return url;
    }
}

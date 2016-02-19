package net.zfeng.sing.parser.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaofeng on 16/2/5.
 */
public enum SingUrl {
    SONG_LIST("http://5sing.kugou.com/m/list/{type}-{category}-{page}.html"),
    SONG_DETAIL("http://5sing.kugou.com/m/detail/{type}-{songId}-{page}.html"),
    MUSICIAN_HOT("http://5sing.kugou.com/m/list/musician-hot-{page}.html"),
    AUTHOR_SONG_LIST("http://5sing.kugou.com/m/space/mysongs/{authorId}-{type}-{page}.html"),
    AUTHOR_FUNS("http://5sing.kugou.com/m/space/fans/{authorId}-{page}.html");

    private String text;

    SingUrl(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, SingUrl> stringToEnum = new HashMap<String, SingUrl>();

    static {
        // Initialize map from constant name to enum constant
        for (SingUrl url : values()) {
            stringToEnum.put(url.toString(), url);
        }
    }

    // Returns Blah for string, or null if string is invalid
    public static SingUrl fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    @Override
    public String toString() {
        return text;
    }
}

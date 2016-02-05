package net.zfeng.sing.parser.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaofeng on 16/2/5.
 */
public enum SingCategory {
    TUIJIAN("tj"),
    HOUXUAN("hx"),
    ZIJIAN("zj"),
    ZUIXIN("zx"),
    HOT("hot");

    private String text;

    SingCategory(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, SingCategory> stringToEnum = new HashMap<String, SingCategory>();

    static {
        // Initialize map from constant name to enum constant
        for (SingCategory category : values()) {
            stringToEnum.put(category.toString(), category);
        }
    }

    // Returns Blah for string, or null if string is invalid
    public static SingCategory fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    @Override
    public String toString() {
        return text;
    }
}

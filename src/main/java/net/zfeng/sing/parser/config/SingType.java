package net.zfeng.sing.parser.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaofeng on 16/2/5.
 */
public enum SingType {
    YUANCHUANG("yc"),
    FANCHANG("fc"),
    BANZOU("bz");

    private String text;

    SingType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    // Implementing a fromString method on an enum type
    private static final Map<String, SingType> stringToEnum = new HashMap<String, SingType>();

    static {
        // Initialize map from constant name to enum constant
        for (SingType type : values()) {
            stringToEnum.put(type.toString(), type);
        }
    }

    // Returns Blah for string, or null if string is invalid
    public static SingType fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    @Override
    public String toString() {
        return text;
    }
}

package net.zfeng.sing.utils;

import net.zfeng.sing.parser.config.SingCategory;
import net.zfeng.sing.parser.config.SingType;

/**
 * Created by zhaofeng on 16/2/5.
 */
public class Conversion {
    public static SingType convertSingType(String type) {
        SingType mType = SingType.YUANCHUANG;

        if (type.equals("yc")) {
            mType = SingType.YUANCHUANG;
        } else if (type.equals("fc")) {
            mType = SingType.FANCHANG;
        } else if (type.equals("bz")) {
            mType = SingType.BANZOU;
        }

        return mType;
    }

    public static SingCategory convertSingCategory(String category) {
        SingCategory mCategory = SingCategory.TUIJIAN;

        if (category.equals("tj")) {
            mCategory = SingCategory.TUIJIAN;
        } else if (category.equals("hx")) {
            mCategory = SingCategory.HOUXUAN;
        } else if (category.equals("zj")) {
            mCategory = SingCategory.ZIJIAN;
        } else if (category.equals("hot")) {
            mCategory = SingCategory.HOT;
        }

        return mCategory;
    }
}

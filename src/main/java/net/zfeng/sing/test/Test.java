package net.zfeng.sing.test;

import com.alibaba.fastjson.JSON;
import net.zfeng.sing.model.Song;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.parser.IParser;
import net.zfeng.sing.parser.config.SingCategory;
import net.zfeng.sing.parser.config.SingType;
import net.zfeng.sing.parser.impl.ParserImpl;

import java.util.List;

/**
 * Created by zhaofeng on 16/2/4.
 */
public class Test {
    public static void main(String[] args) {
        IParser parser = new ParserImpl();
        SongList list = parser.getSongs(SingType.FANCHANG, SingCategory.HOUXUAN, 1);

        System.out.println(JSON.toJSON(list));
    }
}

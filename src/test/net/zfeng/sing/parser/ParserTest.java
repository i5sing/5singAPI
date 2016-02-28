package net.zfeng.sing.parser;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.parser.IParser;
import net.zfeng.sing.parser.impl.ParserImpl;

/**
 * Created by zhaofeng on 16/2/28.
 */
public class ParserTest extends TestCase {
    private IParser parser = new ParserImpl();

    public void testSearchSongs() {
        try {
            Object obj = parser.searchSongs("yc", "可心", 1);
            System.out.println(JSON.toJSON(obj));
        } catch (SingDataException e) {
            e.printStackTrace();
        }
    }

    public void testSearchUsers() {
        try {
            Object obj = parser.searchUsers("可心", 1);
            System.out.println(JSON.toJSON(obj));
        } catch (SingDataException e) {
            e.printStackTrace();
        }
    }
}

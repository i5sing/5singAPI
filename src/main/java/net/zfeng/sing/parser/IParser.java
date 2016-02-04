package net.zfeng.sing.parser;

import net.zfeng.sing.model.SongList;
import net.zfeng.sing.parser.config.SingCategory;
import net.zfeng.sing.parser.config.SingType;

/**
 * Created by zhaofeng on 16/2/4.
 */
public interface IParser {
    SongList getSongs(SingType type, SingCategory category, int page);
}

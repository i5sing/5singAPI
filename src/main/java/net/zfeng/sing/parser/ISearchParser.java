package net.zfeng.sing.parser;

import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.MusicianList;
import net.zfeng.sing.model.SongList;

/**
 * Created by zhaofeng on 4/22/16.
 */
public interface ISearchParser extends IParser {

    SongList searchSongs(String type, String key, int page) throws SingDataException;

    MusicianList searchUsers(String key, int page) throws SingDataException;
}

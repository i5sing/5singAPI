package net.zfeng.sing.parser;

import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Musician;
import net.zfeng.sing.model.MusicianList;

/**
 * Created by zhaofeng on 4/22/16.
 */
public interface IMusicianParser extends IParser {
    MusicianList getMusicians(int page) throws SingDataException;

    MusicianList getFuns(String userId, int page) throws SingDataException;

    Musician getUserInfo(String userId) throws SingDataException;
}

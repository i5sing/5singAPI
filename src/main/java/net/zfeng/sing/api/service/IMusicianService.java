package net.zfeng.sing.api.service;

import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Musician;
import net.zfeng.sing.model.MusicianList;

/**
 * Created by zhaofeng on 16/2/8.
 */
public interface IMusicianService {

    MusicianList getMusicians(int page) throws SingDataException;

    MusicianList getFuns(String userId, int page) throws SingDataException;

    Musician getInfo(String userId) throws SingDataException;
}

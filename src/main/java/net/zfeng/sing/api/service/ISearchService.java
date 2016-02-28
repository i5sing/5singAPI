package net.zfeng.sing.api.service;

import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.SongList;

/**
 * Created by zhaofeng on 16/2/28.
 */
public interface ISearchService {
    Object search(String type, String key, int page) throws SingDataException;
}

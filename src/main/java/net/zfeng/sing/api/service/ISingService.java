package net.zfeng.sing.api.service;

import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Song;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.parser.config.SingCategory;
import net.zfeng.sing.parser.config.SingType;
import org.springframework.stereotype.Service;

/**
 * Created by zhaofeng on 16/2/5.
 */
public interface ISingService {

    SongList getSongs(SingType type, SingCategory category, int page) throws SingDataException;

    Song getSong(SingType type, String songId, int page) throws SingDataException;
}

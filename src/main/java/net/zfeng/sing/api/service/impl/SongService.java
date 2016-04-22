package net.zfeng.sing.api.service.impl;

import net.zfeng.sing.api.service.ISongService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Song;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.parser.ISongParser;
import net.zfeng.sing.parser.config.SingCategory;
import net.zfeng.sing.parser.config.SingType;
import net.zfeng.sing.parser.impl.SongParserImpl;
import org.springframework.stereotype.Service;

/**
 * Created by zhaofeng on 16/2/5.
 */
@Service("songService")
public class SongService implements ISongService {
    private ISongParser parser;

    public SongService() {
        parser = new SongParserImpl();
    }

    public SongList getSongs(SingType type, SingCategory category, int page) throws SingDataException {
        return parser.getSongs(type, category, page);
    }

    public Song getSong(SingType type, String songId, int page) throws SingDataException {
        return parser.getSong(type, page, songId);
    }

    public SongList getPersonalSongs(String userId, SingType type, int page) throws SingDataException {
        return parser.getPersonalSongs(userId, type, page);
    }
}

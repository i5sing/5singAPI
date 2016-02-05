package net.zfeng.sing.api.service.impl;

import net.zfeng.sing.api.service.ISingService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Song;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.parser.IParser;
import net.zfeng.sing.parser.config.SingCategory;
import net.zfeng.sing.parser.config.SingType;
import net.zfeng.sing.parser.impl.ParserImpl;
import org.springframework.stereotype.Service;

/**
 * Created by zhaofeng on 16/2/5.
 */
@Service("singService")
public class SingService implements ISingService {
    private IParser parser;

    public SingService() {
        parser = new ParserImpl();
    }

    public SongList getSongs(SingType type, SingCategory category, int page) throws SingDataException {
        return parser.getSongs(type, category, page);
    }

    public Song getSong(SingType type, String songId, int page) throws SingDataException {
        return parser.getSong(type, page, songId);
    }
}

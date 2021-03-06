package net.zfeng.sing.api.service.impl;

import net.zfeng.sing.api.service.IMusicianService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Musician;
import net.zfeng.sing.model.MusicianList;
import net.zfeng.sing.parser.IMusicianParser;
import net.zfeng.sing.parser.impl.MusicianParserImpl;
import org.springframework.stereotype.Service;

/**
 * Created by zhaofeng on 16/2/8.
 */
@Service("musicianService")
public class MusicianService implements IMusicianService {
    private IMusicianParser parser;

    public MusicianService() {
        parser = new MusicianParserImpl();
    }

    public MusicianList getMusicians(int page) throws SingDataException {
        return parser.getMusicians(page);
    }

    public MusicianList getFuns(String userId, int page) throws SingDataException {
        return parser.getFuns(userId, page);
    }

    public Musician getInfo(String userId) throws SingDataException {
        return parser.getUserInfo(userId);
    }
}

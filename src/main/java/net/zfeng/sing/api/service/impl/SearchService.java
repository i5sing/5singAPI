package net.zfeng.sing.api.service.impl;

import net.zfeng.sing.api.service.ISearchService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.parser.IParser;
import net.zfeng.sing.parser.impl.ParserImpl;
import org.springframework.stereotype.Service;

/**
 * Created by zhaofeng on 16/2/28.
 */
@Service("searchService")
public class SearchService implements ISearchService {
    private IParser parser;

    public SearchService() {
        parser = new ParserImpl();
    }

    public Object search(String type, String key, int page) throws SingDataException {
        if (type.equals("user")) {
            return parser.searchUsers(key, page);
        }
        return parser.searchSongs(type, key, page);
    }
}

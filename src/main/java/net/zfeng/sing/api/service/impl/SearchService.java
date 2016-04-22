package net.zfeng.sing.api.service.impl;

import net.zfeng.sing.api.service.ISearchService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.parser.ISearchParser;
import net.zfeng.sing.parser.impl.SearchParserImpl;
import org.springframework.stereotype.Service;

/**
 * Created by zhaofeng on 16/2/28.
 */
@Service("searchService")
public class SearchService implements ISearchService {
    private ISearchParser parser;

    public SearchService() {
        parser = new SearchParserImpl();
    }

    public Object search(String type, String key, int page) throws SingDataException {
        if (type.equals("user")) {
            return parser.searchUsers(key, page);
        }
        return parser.searchSongs(type, key, page);
    }
}

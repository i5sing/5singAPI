package net.zfeng.sing.parser.impl;

import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Musician;
import net.zfeng.sing.model.MusicianList;
import net.zfeng.sing.model.Song;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.parser.ISearchParser;
import net.zfeng.sing.parser.config.SingUrl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaofeng on 4/22/16.
 */
public class SearchParserImpl extends ParserImpl implements ISearchParser{
    /**
     * 搜索
     *
     * @param type
     * @param key
     * @param page
     * @return
     * @throws SingDataException
     */
    public SongList searchSongs(String type, String key, int page) throws SingDataException {
        List<Song> songs = new ArrayList<Song>();
        SongList songList = new SongList();
        String url = "";
        try {
            url = SingUrl.SEARCH.getText().replace("{type}", type).replace("{key}", URLEncoder.encode(key, "UTF-8")).replace("{page}", page + "");
        } catch (UnsupportedEncodingException e) {
            throw new SingDataException("encode error \n" + e.getMessage());
        }
        Pattern pattern = Pattern.compile(SingIdRE);

        try {
            Document doc = parserHTML(url);
            Element songListEl = doc.getElementsByClass("list_items").get(0);
            Elements songEls = songListEl.getElementsByTag("li");
            int i = -1;

            while (i++ < songEls.size() - 1) {
                Element songEl = songEls.get(i);
                String href = songEl.getElementsByTag("a").get(0).attr("href");
                String name = songEl.getElementsByTag("h4").get(0).ownText();
                String author = songEl.getElementsByTag("strong").get(0).text();
                Matcher matcher = pattern.matcher(href);

                Song song = new Song();
                song.setName(name);
                song.setAuthor(author);

                if (matcher.find() && matcher.group().length() > 1) {
                    song.setId(matcher.group(1));
                }

                songs.add(song);
            }
        } catch (IOException e) {
            throw new SingDataException("从五婶获取数据失败\n" + e.getMessage());
        }

        songList.setPage(page);
        songList.setList(songs);
        return songList;
    }

    public MusicianList searchUsers(String key, int page) throws SingDataException {
        MusicianList musicianList = new MusicianList();
        List<Musician> musicians = new ArrayList<Musician>();
        String url = "";
        try {
            url = SingUrl.SEARCH.getText().replace("{type}", "user").replace("{key}", URLEncoder.encode(key, "UTF-8")).replace("{page}", page + "");
        } catch (UnsupportedEncodingException e) {
            throw new SingDataException("encode error \n" + e.getMessage());
        }
        Pattern userIdPattern = Pattern.compile(UserIdRE);

        try {
            Document doc = parserHTML(url);
            Element userListEl = doc.getElementsByClass("m_fans").get(0);
            Elements userEls = userListEl.getElementsByTag("li");
            int i = -1;

            while (i++ < userEls.size() - 1) {
                Element user = userEls.get(i);
                String href = user.getElementsByTag("a").get(0).attr("href");
                String name = user.getElementsByTag("h6").get(0).text();
                String introduction = user.getElementsByTag("p").get(0).text();
                Matcher userIdMatcher = userIdPattern.matcher(href);

                Musician musician = new Musician();

                musician.setName(name);
                musician.setIntroduction(introduction);

                if (userIdMatcher.find() && userIdMatcher.group().length() > 1) {
                    musician.setId(userIdMatcher.group(1));
                }

                musicians.add(musician);
            }
        } catch (IOException e) {
            throw new SingDataException("从五婶获取数据失败\n" + e.getMessage());
        }

        musicianList.setPage(page);
        musicianList.setList(musicians);
        return musicianList;
    }
}

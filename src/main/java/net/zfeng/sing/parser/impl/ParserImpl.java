package net.zfeng.sing.parser.impl;

import net.zfeng.sing.model.Song;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.parser.IParser;
import net.zfeng.sing.parser.config.SingCategory;
import net.zfeng.sing.parser.config.SingType;
import net.zfeng.sing.parser.config.SingUrls;
import net.zfeng.sing.parser.config.SingUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaofeng on 16/2/4.
 */
public class ParserImpl implements IParser {
    private static String SingIdRE = "^/m/space/([0-9]+).html$";

    /**
     * 加载并解析指定url的html
     *
     * @param url
     * @return
     * @throws IOException
     */
    private Document parserHTML(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    /**
     * 删除html中的其他字符
     *
     * @param str
     * @return
     */
    public String deleteExtraChar(String str) {
        return str.replace("&nbsp;", "").replace(",", "").trim().replace(" ", "");
    }

    /**
     * 获取5sing歌曲列表
     *
     * @param page
     * @param type
     * @param category
     * @return
     */
    public SongList getSongs(SingType type, SingCategory category, int page) {
        List<Song> songs = new ArrayList<Song>();
        SongList songList = new SongList();
        Pattern pattern = Pattern.compile(SingIdRE);
        try {
            Document doc = parserHTML(SingUrls.getURL(SingUrl.SONG_LIST, type, category, page));
            Elements songListEl = doc.getElementById("yc_list_tj").getElementsByTag("li");
            int i = 0;
            while (i++ < songListEl.size() - 1) {
                Element songEl = songListEl.get(i);
                Element nameEl = songEl.getElementsByTag("h4").get(0);
                Element authorEl = nameEl.getElementsByTag("strong").size() > 0 ? nameEl.getElementsByTag("strong").get(0) : null;
                Elements otherEls = songEl.getElementsByTag("span");
                String hrefVal = songEl.getElementsByAttribute("href").attr("href");

                Matcher matcher = pattern.matcher(hrefVal);

                Song song = new Song();

                if (authorEl != null) {
                    song.setAuthor(authorEl.text());

                    //删除歌曲名字中的作者信息
                    authorEl.remove();
                }

                if (matcher.find() && matcher.group().length() > 1) {
                    song.setId(matcher.group(1));
                }

                song.setName(nameEl.text());

                if (otherEls.size() > 1) {
                    int clickNumber = Integer.parseInt(deleteExtraChar(otherEls.get(0).text()).split(":")[1]);
                    int likeNumber = Integer.parseInt(deleteExtraChar(otherEls.get(1).text()).split(":")[1]);
                    song.setClickNumber(clickNumber);
                    song.setLikeNumber(likeNumber);
                }

                songs.add(song);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        songList.setList(songs);
        songList.setPage(page);
        return songList;
    }
}

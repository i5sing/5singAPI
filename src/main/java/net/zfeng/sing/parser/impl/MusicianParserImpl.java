package net.zfeng.sing.parser.impl;

import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Musician;
import net.zfeng.sing.model.MusicianList;
import net.zfeng.sing.parser.IMusicianParser;
import net.zfeng.sing.parser.config.SingUrl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaofeng on 4/22/16.
 */
public class MusicianParserImpl extends ParserImpl implements IMusicianParser{
    /**
     * 获取热门歌手列表
     *
     * @param page
     * @return
     */
    public MusicianList getMusicians(int page) throws SingDataException {
        MusicianList musicianList = new MusicianList();
        List<Musician> musicians = new ArrayList<Musician>();
        Pattern userIdPattern = Pattern.compile(UserIdRE);

        try {
            Document doc = parserHTML(SingUrl.MUSICIAN_HOT.getText().replace("{page}", page + ""));
            Elements imgEls = doc.getElementById("photolist").getElementsByTag("a");
            int i = -1;
            while (i++ < imgEls.size() - 1) {
                Element imgEl = imgEls.get(i);
                Matcher userIdMatcher = userIdPattern.matcher(imgEl.attr("href"));

                Musician musician = new Musician();

                if (userIdMatcher.find() && userIdMatcher.group().length() > 1) {
                    musician.setId(userIdMatcher.group(1));
                }

                musician.setName(imgEl.getElementsByTag("span").get(0).text());
                musician.setImgAddress(imgEl.getElementsByTag("img").get(0).attr("src"));
                musicians.add(musician);
            }
        } catch (IOException e) {
            throw new SingDataException("从五婶获取数据失败\n" + e.getMessage());
        }

        musicianList.setList(musicians);
        musicianList.setPage(page);
        return musicianList;
    }

    /**
     * 获取个人粉丝
     *
     * @param userId
     * @param page
     * @return
     * @throws SingDataException
     */
    public MusicianList getFuns(String userId, int page) throws SingDataException {
        MusicianList musicianList = new MusicianList();
        List<Musician> musicians = new ArrayList<Musician>();
        String url = SingUrl.AUTHOR_FUNS.getText().replace("{authorId}", userId).replace("{page}", page + "");
        Pattern userIdPattern = Pattern.compile(UserIdRE);

        try {
            Document doc = parserHTML(url);
            Elements funEls = doc.getElementsByClass("m_fans").get(0).getElementsByTag("li");
            int i = -1;
            while (i++ < funEls.size() - 1) {
                Element funEl = funEls.get(i);
                Musician musician = new Musician();

                String img = funEl.getElementsByTag("img").get(0).attr("src");
                String name = funEl.getElementsByTag("h6").get(0).ownText();
                String introduction = funEl.getElementsByTag("p").get(0).text();
                String hrefVal = funEl.getElementsByTag("a").get(0).attr("href");
                Matcher userIdMatcher = userIdPattern.matcher(hrefVal);

                if (userIdMatcher.find() && userIdMatcher.group().length() > 1) {
                    musician.setId(userIdMatcher.group(1));
                }
                musician.setImgAddress(img);
                musician.setName(name);
                musician.setIntroduction(introduction);

                musicians.add(musician);
            }

            musicianList.setList(musicians);
        } catch (IOException e) {
            throw new SingDataException("从五婶获取数据失败\n" + e.getMessage());
        }
        return musicianList;
    }

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     * @throws SingDataException
     */
    public Musician getUserInfo(String userId) throws SingDataException {
        Musician musician = new Musician();
        String url = SingUrl.AUTHOR_INFO.getText().replace("{authorId}", userId);

        try {
            Document doc = parserHTML(url);
            Element element = doc.getElementsByClass("my_5sing").get(0);
            Element imgEl = element.getElementsByTag("img").get(0);
            Element introductionEl = element.getElementsByTag("ul").get(0).getElementsByTag("li").get(0);
            String name = doc.getElementsByTag("title").get(0).text().split("的")[0];

            musician.setName(name);
            musician.setId(userId);
            musician.setImgAddress(imgEl.attr("src"));
            musician.setIntroduction(introductionEl.text());
        } catch (IOException e) {
            throw new SingDataException("从五婶获取数据失败\n" + e.getMessage());
        }
        return musician;
    }
}

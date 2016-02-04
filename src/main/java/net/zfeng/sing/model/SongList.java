package net.zfeng.sing.model;

import java.util.List;

/**
 * Created by zhaofeng on 16/2/5.
 */
public class SongList {
    private int page;
    private List<Song> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Song> getList() {
        return list;
    }

    public void setList(List<Song> list) {
        this.list = list;
    }
}

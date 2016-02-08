package net.zfeng.sing.model;

import java.util.List;

/**
 * Created by zhaofeng on 16/2/8.
 */
public class MusicianList {
    private int page;
    private List<Musician> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Musician> getList() {
        return list;
    }

    public void setList(List<Musician> list) {
        this.list = list;
    }
}

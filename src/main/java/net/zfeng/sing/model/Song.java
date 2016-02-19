package net.zfeng.sing.model;

/**
 * Created by zhaofeng on 16/2/4.
 */
public class Song {
    private String id;
    private String name;
    private String author;
    private String authorImg;
    private String style;
    private int clickNumber;
    private int likeNumber;
    private int downNumber;
    private String lrcs;
    private String introduction;
    private String address;
    private String uploadTime;

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getAuthorImg() {
        return authorImg;
    }

    public void setAuthorImg(String authorImg) {
        this.authorImg = authorImg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getClickNumber() {
        return clickNumber;
    }

    public void setClickNumber(int clickNumber) {
        this.clickNumber = clickNumber;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getDownNumber() {
        return downNumber;
    }

    public void setDownNumber(int downNumber) {
        this.downNumber = downNumber;
    }

    public String getLrcs() {
        return lrcs;
    }

    public void setLrcs(String lrcs) {
        this.lrcs = lrcs;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}

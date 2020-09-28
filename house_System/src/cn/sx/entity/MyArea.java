package cn.sx.entity;

/**
 * @program: house_System
 * Author sx
 * @desc 区域信息实体类
 * @create: 2020-08-14 23:32
 **/
public class MyArea {
    private Integer aid;
    private String aname;

    //上一页的当前页
    private Integer up;
    //下一页的当前页
    private Integer next;
    //有多少行数据
    private Integer allcount;
    //总共有多少页
    private Integer allPages;
    //当前页数
    protected Integer current;
    //页面默认显示10条记录
    protected int mypages;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getUp() {
        return up;
    }

    public void setUp(Integer up) {
        this.up = up;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getAllcount() {
        return allcount;
    }

    public void setAllcount(Integer allcount) {
        this.allcount = allcount;
    }

    public Integer getAllPages() {
        return allPages;
    }

    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public int getMypages() {
        return mypages;
    }

    public void setMypages(int mypages) {
        this.mypages = mypages;
    }

    @Override
    public String toString() {
        return "MyArea{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", up=" + up +
                ", next=" + next +
                ", allcount=" + allcount +
                ", allPages=" + allPages +
                ", current=" + current +
                ", mypages=" + mypages +
                '}';
    }
}

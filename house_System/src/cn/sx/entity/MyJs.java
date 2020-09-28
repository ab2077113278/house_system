package cn.sx.entity;

/**
 * @program: house_System
 * Author sx
 * @desc 岗位实体类
 * @create: 2020-08-14 23:03
 **/
public class MyJs {
    private Integer jid;
    private String jname;

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

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
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
        return "MyJs{" +
                "jid=" + jid +
                ", jname='" + jname + '\'' +
                ", up=" + up +
                ", next=" + next +
                ", allcount=" + allcount +
                ", allPages=" + allPages +
                ", current=" + current +
                ", mypages=" + mypages +
                '}';
    }
}

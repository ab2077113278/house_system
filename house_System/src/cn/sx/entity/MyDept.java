package cn.sx.entity;

/**
 * @program: house_System
 * Author HLY
 * @desc 部门信息实体类
 * @create: 2020-08-08 13:34
 **/
public class MyDept {
    private Long pid;
    private String pname;
    private Long pflag;
    private String premark;

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Long getPflag() {
        return pflag;
    }

    public void setPflag(Long pflag) {
        this.pflag = pflag;
    }

    public String getPremark() {
        return premark;
    }

    public void setPremark(String premark) {
        this.premark = premark;
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

    @Override
    public String toString() {
        return "MyDept{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pflag=" + pflag +
                ", premark='" + premark + '\'' +
                '}';
    }
}

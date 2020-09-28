package cn.sx.entity;

/**
 * @program: house_System
 * Author sx
 * @desc 员工信息实体类
 * @create: 2020-08-14 23:29
 **/
public class MyEmp {
    private Integer eid;
    private Integer pid;
    private Integer jid;
    private String pname;
    private String jname;
    private String ename;
    private String epsw;
    private String erealname;
    private String etel;
    private String eaddress;
    private String eflag;
    private String eremark;

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

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpsw() {
        return epsw;
    }

    public void setEpsw(String epsw) {
        this.epsw = epsw;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    public String getEtel() {
        return etel;
    }

    public void setEtel(String etel) {
        this.etel = etel;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String getEflag() {
        return eflag;
    }

    public void setEflag(String eflag) {
        this.eflag = eflag;
    }

    public String getEremark() {
        return eremark;
    }

    public void setEremark(String eremark) {
        this.eremark = eremark;
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
        return "MyEmp{" +
                "eid=" + eid +
                ", pid=" + pid +
                ", jid=" + jid +
                ", pname=" + pname +
                ", jname=" + jname +
                ", ename='" + ename + '\'' +
                ", epsw='" + epsw + '\'' +
                ", erealname='" + erealname + '\'' +
                ", etel='" + etel + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", eflag='" + eflag + '\'' +
                ", eremark='" + eremark + '\'' +
                ", up=" + up +
                ", next=" + next +
                ", allcount=" + allcount +
                ", allPages=" + allPages +
                ", current=" + current +
                ", mypages=" + mypages +
                '}';
    }
}

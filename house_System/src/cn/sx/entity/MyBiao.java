package cn.sx.entity;

import cn.sx.base.BaseDto;

/**
 * @program: house_System
 * Author sx
 * @desc 操表记录实体类
 * @create: 2020-08-25 11:51
 **/
public class MyBiao extends BaseDto {
    private Long bid;
    private Long hid;
    private String haddress;
    private String hfh;
    private Long dkd;
    private Long skd;
    private Long mkd;
    private String mtime;
    private Integer eid;
    private String erealname;

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHfh() {
        return hfh;
    }

    public void setHfh(String hfh) {
        this.hfh = hfh;
    }

    public Long getDkd() {
        return dkd;
    }

    public void setDkd(Long dkd) {
        this.dkd = dkd;
    }

    public Long getSkd() {
        return skd;
    }

    public void setSkd(Long skd) {
        this.skd = skd;
    }

    public Long getMkd() {
        return mkd;
    }

    public void setMkd(Long mkd) {
        this.mkd = mkd;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "MyBiao{" +
                "bid=" + bid +
                ", hid=" + hid +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", dkd=" + dkd +
                ", skd=" + skd +
                ", mkd=" + mkd +
                ", mtime='" + mtime + '\'' +
                ", eid=" + eid +
                ", erealname='" + erealname + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }
}

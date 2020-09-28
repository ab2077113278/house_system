package cn.sx.entity;

import cn.sx.base.BaseDto;

/**
 * @program: house_System
 * Author sx
 * @desc  报损信息实体类
 * @create: 2020-08-25 13:43
 **/
public class MyBs extends BaseDto {
    private Long bid;
    private Long hid;
    private String mtime;
    private Long eid;
    private String haddress;
    private String hfh;
    private String bremark;
    private String erealname;

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
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

    public String getBremark() {
        return bremark;
    }

    public void setBremark(String bremark) {
        this.bremark = bremark;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    @Override
    public String toString() {
        return "MyBs{" +
                "bid=" + bid +
                ", hid=" + hid +
                ", mtime='" + mtime + '\'' +
                ", eid=" + eid +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", bremark='" + bremark + '\'' +
                ", erealname='" + erealname + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }
}

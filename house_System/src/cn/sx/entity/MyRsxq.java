package cn.sx.entity;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 出租房分类查询
 *@Time: 2020/8/27  8:46
 */

import cn.sx.base.BaseDto;

public class MyRsxq extends BaseDto {
    private Long hid;
    private String sname;
    private String aname;
    private String haddress;
    private String hfh;
    private String hhx;
    private String hmj;
    private String hcx;
    private String hmoney;
    private String hflag;

    @Override
    public String toString() {
        return "MyRSCQ{" +
                "hid=" + hid +
                ", sname='" + sname + '\'' +
                ", aname='" + aname + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", hhx='" + hhx + '\'' +
                ", hmj='" + hmj + '\'' +
                ", hcx='" + hcx + '\'' +
                ", hmoney='" + hmoney + '\'' +
                ", hflag='" + hflag + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
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

    public String getHhx() {
        return hhx;
    }

    public void setHhx(String hhx) {
        this.hhx = hhx;
    }

    public String getHmj() {
        return hmj;
    }

    public void setHmj(String hmj) {
        this.hmj = hmj;
    }

    public String getHcx() {
        return hcx;
    }

    public void setHcx(String hcx) {
        this.hcx = hcx;
    }

    public String getHmoney() {
        return hmoney;
    }

    public void setHmoney(String hmoney) {
        this.hmoney = hmoney;
    }

    public String getHflag() {
        return hflag;
    }

    public void setHflag(String hflag) {
        this.hflag = hflag;
    }
}

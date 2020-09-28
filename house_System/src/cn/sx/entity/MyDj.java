package cn.sx.entity;

import cn.sx.base.BaseDto;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-22 10:21
 **/
public class MyDj extends BaseDto {
    private Long mid;
    private String mdate;
    private Long eid;
    private Long cid;
    private Long hid;
    private String mimg;
    private Float myj;
    private Float myzj;
    private Long mflag;
    private String mbegintime;
    private String hfh;
    private String cname;
    private String ename;
    private String haddress;
    private String ctel;
    private String erealname;

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getHfh() {
        return hfh;
    }

    public void setHfh(String hfh) {
        this.hfh = hfh;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public Float getMyj() {
        return myj;
    }

    public void setMyj(Float myj) {
        this.myj = myj;
    }

    public Float getMyzj() {
        return myzj;
    }

    public void setMyzj(Float myzj) {
        this.myzj = myzj;
    }

    public Long getMflag() {
        return mflag;
    }

    public void setMflag(Long mflag) {
        this.mflag = mflag;
    }

    public String getMbegintime() {
        return mbegintime;
    }

    public void setMbegintime(String mbegintime) {
        this.mbegintime = mbegintime;
    }

    @Override
    public String toString() {
        return "MyDj{" +
                "mid=" + mid +
                ", mdate='" + mdate + '\'' +
                ", eid=" + eid +
                ", cid=" + cid +
                ", hid=" + hid +
                ", mimg='" + mimg + '\'' +
                ", myj=" + myj +
                ", myzj=" + myzj +
                ", mflag=" + mflag +
                ", mbegintime='" + mbegintime + '\'' +
                ", hfh='" + hfh + '\'' +
                ", cname='" + cname + '\'' +
                ", ename='" + ename + '\'' +
                ", haddress='" + haddress + '\'' +
                ", ctel='" + ctel + '\'' +
                ", erealname='" + erealname + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }
}

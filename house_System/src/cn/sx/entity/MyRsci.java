package cn.sx.entity;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 出租房费用查询
 *@Time: 2020/8/27  9:17
 */

import cn.sx.base.BaseDto;

public class MyRsci extends BaseDto {
    private Long mid;
    private String haddress;
    private String hfh;
    private String cname;
    private String ctel;
    private String erealname;
    private String mdate;
    private String myj;
    private String myzj;
    private String hflag;

    @Override
    public String toString() {
        return "MyRsci{" +
                "mid=" + mid +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", cname='" + cname + '\'' +
                ", ctel='" + ctel + '\'' +
                ", erealname='" + erealname + '\'' +
                ", mdate='" + mdate + '\'' +
                ", myj='" + myj + '\'' +
                ", myzj='" + myzj + '\'' +
                ", hflag='" + hflag + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

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

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getMyj() {
        return myj;
    }

    public void setMyj(String myj) {
        this.myj = myj;
    }

    public String getMyzj() {
        return myzj;
    }

    public void setMyzj(String myzj) {
        this.myzj = myzj;
    }

    public String getHflag() {
        return hflag;
    }

    public void setHflag(String hflag) {
        this.hflag = hflag;
    }
}

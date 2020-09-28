package cn.sx.entity;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 到期收租实体类
 *@Time: 2020/8/27  15:53
 */

import cn.sx.base.BaseDto;

public class MyDaoQiShouZu extends BaseDto {
    private Long mid;
    private String haddress;
    private Long hid;
    private String cname;
    private String ctel;
    private String mdate;
    private String mbegintime;

    @Override
    public String toString() {
        return "MyDaoQiShouZu{" +
                "mid=" + mid +
                ", haddress='" + haddress + '\'' +
                ", hid=" + hid +
                ", cname='" + cname + '\'' +
                ", ctel='" + ctel + '\'' +
                ", mdate='" + mdate + '\'' +
                ", mbegintime='" + mbegintime + '\'' +
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

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
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

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public String getMbegintime() {
        return mbegintime;
    }

    public void setMbegintime(String mbegintime) {
        this.mbegintime = mbegintime;
    }
}

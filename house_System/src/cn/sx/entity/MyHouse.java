package cn.sx.entity;

import cn.sx.base.BaseDto;

/**
 * @program: house_System
 * Author sx
 * @desc 出租房信息实体类
 * @create: 2020-08-20 14:52
 **/
public class MyHouse extends BaseDto {
    private Long hid; //出租房编号
    private Long sid; //出租类别编号
    private Long aid; //区域编号
    private String sname; //出租类别名称
    private String aname; //区域名称
    private String haddress;  //房子地址
    private String hfh; //房号
    private String hhx; //房子户型
    private String hmj; //面积
    private String hcx; //朝向
    private Float hmoney; //原定最低租金
    private Float hwf; //网费
    private Float hdx; //电费单价
    private Float hsf; //水费单价
    private Float hmq; //煤气单价
    private Float dkd; //电刻度
    private Float skd; //水刻度
    private Float mkd; //煤刻度
    private String hjp; //房子简拼
    private String hremark; //备注说明
    private String himg; //房子图片
    private Long hflag; //1代表正在出租 0代表没有出租

    public Long getHid() {
        return hid;
    }

    public void setHid(Long hid) {
        this.hid = hid;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
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

    public Float getHmoney() {
        return hmoney;
    }

    public void setHmoney(Float hmoney) {
        this.hmoney = hmoney;
    }

    public Float getHwf() {
        return hwf;
    }

    public void setHwf(Float hwf) {
        this.hwf = hwf;
    }

    public Float getHdx() {
        return hdx;
    }

    public void setHdx(Float hdx) {
        this.hdx = hdx;
    }

    public Float getHsf() {
        return hsf;
    }

    public void setHsf(Float hsf) {
        this.hsf = hsf;
    }

    public Float getHmq() {
        return hmq;
    }

    public void setHmq(Float hmq) {
        this.hmq = hmq;
    }

    public Float getDkd() {
        return dkd;
    }

    public void setDkd(Float dkd) {
        this.dkd = dkd;
    }

    public Float getSkd() {
        return skd;
    }

    public void setSkd(Float skd) {
        this.skd = skd;
    }

    public Float getMkd() {
        return mkd;
    }

    public void setMkd(Float mkd) {
        this.mkd = mkd;
    }

    public String getHjp() {
        return hjp;
    }

    public void setHjp(String hjp) {
        this.hjp = hjp;
    }

    public String getHremark() {
        return hremark;
    }

    public void setHremark(String hremark) {
        this.hremark = hremark;
    }

    public String getHimg() {
        return himg;
    }

    public void setHimg(String himg) {
        this.himg = himg;
    }

    public Long getHflag() {
        return hflag;
    }

    public void setHflag(Long hflag) {
        this.hflag = hflag;
    }

    public MyHouse() {
    }

    public MyHouse(Long hid, Long sid, Long aid, String sname, String aname, String haddress, String hfh, String hhx, String hmj, String hcx, Float hmoney, Float hwf, Float hdx, Float hsf, Float hmq, Float dkd, Float skd, Float mkd, String hjp, String hremark, String himg, Long hflag) {
        this.hid = hid;
        this.sid = sid;
        this.aid = aid;
        this.sname = sname;
        this.aname = aname;
        this.haddress = haddress;
        this.hfh = hfh;
        this.hhx = hhx;
        this.hmj = hmj;
        this.hcx = hcx;
        this.hmoney = hmoney;
        this.hwf = hwf;
        this.hdx = hdx;
        this.hsf = hsf;
        this.hmq = hmq;
        this.dkd = dkd;
        this.skd = skd;
        this.mkd = mkd;
        this.hjp = hjp;
        this.hremark = hremark;
        this.himg = himg;
        this.hflag = hflag;
    }

    @Override
    public String toString() {
        return "MyHouse{" +
                "hid=" + hid +
                ", sid=" + sid +
                ", aid=" + aid +
                ", sname='" + sname + '\'' +
                ", aname='" + aname + '\'' +
                ", haddress='" + haddress + '\'' +
                ", hfh='" + hfh + '\'' +
                ", hhx='" + hhx + '\'' +
                ", hmj='" + hmj + '\'' +
                ", hcx='" + hcx + '\'' +
                ", hmoney=" + hmoney +
                ", hwf=" + hwf +
                ", hdx=" + hdx +
                ", hsf=" + hsf +
                ", hmq=" + hmq +
                ", dkd=" + dkd +
                ", skd=" + skd +
                ", mkd=" + mkd +
                ", hjp='" + hjp + '\'' +
                ", hremark='" + hremark + '\'' +
                ", himg='" + himg + '\'' +
                ", hflag=" + hflag +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }
}

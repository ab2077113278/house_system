package cn.sx.entity;

import cn.sx.base.BaseDto;

/**
 * @program: house_System
 * Author sx
 * @desc 客户信息实体类
 * @create: 2020-08-21 16:07
 **/
public class MyCus extends BaseDto {
    private Long cid; //编号
    private String cname;//客户姓名
    private String csex;//性别
    private String ctel;//客户电话
    private String ctel1;//备用电话
    private String ccard;//身份证号

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public String getCtel() {
        return ctel;
    }

    public void setCtel(String ctel) {
        this.ctel = ctel;
    }

    public String getCtel1() {
        return ctel1;
    }

    public void setCtel1(String ctel1) {
        this.ctel1 = ctel1;
    }

    public String getCcard() {
        return ccard;
    }

    public void setCcard(String ccard) {
        this.ccard = ccard;
    }

    @Override
    public String toString() {
        return "MyCus{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", csex='" + csex + '\'' +
                ", ctel='" + ctel + '\'' +
                ", ctel1='" + ctel1 + '\'' +
                ", ccard='" + ccard + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }


}

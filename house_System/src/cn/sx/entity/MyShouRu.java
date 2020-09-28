package cn.sx.entity;

import cn.sx.base.BaseDto;

/**
 * @program: house_System
 * Author sx
 * @desc 收入信息实体类
 * @create: 2020-08-25 14:20
 **/
public class MyShouRu extends BaseDto {
    private Long sid;
    private Long eid;
    private Float smoney;
    private String stm;
    private String stime;
    private String sremark;
    private String erealname;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Float getSmoney() {
        return smoney;
    }

    public void setSmoney(Float smoney) {
        this.smoney = smoney;
    }

    public String getStm() {
        return stm;
    }

    public void setStm(String stm) {
        this.stm = stm;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public String getErealname() {
        return erealname;
    }

    public void setErealname(String erealname) {
        this.erealname = erealname;
    }

    @Override
    public String toString() {
        return "MyShouRu{" +
                "sid=" + sid +
                ", eid=" + eid +
                ", smoney=" + smoney +
                ", stm='" + stm + '\'' +
                ", stime='" + stime + '\'' +
                ", sremark='" + sremark + '\'' +
                ", erealname='" + erealname + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }
}

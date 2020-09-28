package cn.sx.entity;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 支出信息实体类
 *@Time: 2020/8/26  19:13
 */

import cn.sx.base.BaseDto;

public class MyZhiChu extends BaseDto {
    private Long zid	;//	编号
    private Long  eid	;//	经办人编号（员工编号）
    private Float zmoney	;//		支出金额
    private String Ztm	;//	来源条目
    private String  ztime	;//	时间
    private String  zremark	;//	备注说明

    @Override
    public String toString() {
        return "MyZhiChu{" +
                "zid=" + zid +
                ", eid=" + eid +
                ", zmoney=" + zmoney +
                ", Ztm='" + Ztm + '\'' +
                ", ztime='" + ztime + '\'' +
                ", zremark='" + zremark + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }

    public Long getZid() {
        return zid;
    }

    public void setZid(Long zid) {
        this.zid = zid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Float getZmoney() {
        return zmoney;
    }

    public void setZmoney(Float zmoney) {
        this.zmoney = zmoney;
    }

    public String getZtm() {
        return Ztm;
    }

    public void setZtm(String ztm) {
        Ztm = ztm;
    }

    public String getZtime() {
        return ztime;
    }

    public void setZtime(String ztime) {
        this.ztime = ztime;
    }

    public String getZremark() {
        return zremark;
    }

    public void setZremark(String zremark) {
        this.zremark = zremark;
    }
}

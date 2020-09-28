package cn.sx.entity;

/*
 *@program:house_System
 *@author: ShiXian
 *@desc: 租房政策实体类
 *@Time: 2020/8/28  15:16
 */

import cn.sx.base.BaseDto;

public class MyZc extends BaseDto {
    private Long cid;//	编号
    private String ctitle	;//	来源条目
    private String  ctime	;//	时间
    private String cremark;//		备注说明

    @Override
    public String toString() {
        return "MyZc{" +
                "cid=" + cid +
                ", ctitle='" + ctitle + '\'' +
                ", ctime='" + ctime + '\'' +
                ", cremark='" + cremark + '\'' +
                ", current=" + current +
                ", up=" + up +
                ", next=" + next +
                ", allpages=" + allpages +
                ", allcount=" + allcount +
                '}';
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCremark() {
        return cremark;
    }

    public void setCremark(String cremark) {
        this.cremark = cremark;
    }
}

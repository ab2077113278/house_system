package cn.sx.base;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-19 10:51
 **/
public abstract class BaseDto {
    protected int  current;
    protected int up;
    protected int next;
    protected int allpages;
    protected int allcount;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getAllpages() {
        return allpages;
    }

    public void setAllpages(int allpages) {
        this.allpages = allpages;
    }

    public int getAllcount() {
        return allcount;
    }

    public void setAllcount(int allcount) {
        this.allcount = allcount;
    }



}

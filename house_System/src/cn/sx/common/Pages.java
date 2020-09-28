package cn.sx.common;

/**
 * @program: house_System
 * Author sx
 * @desc
 * @create: 2020-08-13 16:38
 **/
public class Pages {

    /**
     * 获取总页数
     * @param allcount
     * @param mypages 一页显示的数量
     * @return
     */
    public int getAllPages(int allcount, int mypages){
        int allPage = 0;
        int remainder = 0;
        remainder = allcount%mypages;
        if(remainder == 0){
            allPage = allcount/mypages;
        }else {
            allPage = allcount/mypages+1;
        }
        return allPage;
    }

    /**
     * 上一页
     * @param current
     * @return
     */
    public int getUp(int current){
        int up = 0;
        int y = current-1;

        if(y <= 0){
            up = 1;
        }else {
            up = current-1;
        }
        return up;
    }

    public int getNext(int current , int allPages){
        int next = 0;
        int k = current+1;
        if(k >= allPages){
            next = allPages;
        }else {
            next = current+1;
        }
        return next;
    }


}

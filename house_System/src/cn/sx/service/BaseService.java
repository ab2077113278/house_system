package cn.sx.service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    public  int calculationQuantity(Object... args);

    public List<T> getSelectAll(Map<String,Object> pageMap, Object... objects );
}

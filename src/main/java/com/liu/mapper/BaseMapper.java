package com.liu.mapper;

import java.util.List;

/**
 * Created by liuneng on 2016/12/28.
 */
public interface BaseMapper<T, P> {
    T getById(P id);

    int update(T dto);

    int delete(T dto);

    List<T> select(T dto);

    T insert(T dto);
}

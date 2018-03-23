package com.sps.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseReadService <T, K extends Serializable>{

    int countByExample(T example);

    List<K> selectByExample(T example);

    K selectByPrimaryKey(Integer id);
}

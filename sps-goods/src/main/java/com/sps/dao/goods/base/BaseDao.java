package com.sps.dao.goods.base;


import java.io.Serializable;
import java.util.List;

public interface BaseDao<T,KEY extends Serializable> {

    /**
     * 新增数据
     * @param parameter
     * @return 影响行数
     */
    int insert(Object parameter);

    /**
     * 删除数据
     * @param parameter
     * @return 影响行数
     */
    int delete(Object parameter);

    /**
     * 更新数据
     * @param parameter
     * @return 影响行数
     */
    int update(Object parameter);

    /**
     * 自定义更新
     * @param statement   sql语句
     * @param parameter   传入的参数
     * @return 影响行数
     */
    int updateByValue(String statement, Object parameter);

    /**
     * 查询单条数据
     * @param statement
     * @param <T> 返回对象
     * @return
     */
    <T> T selectOne(String statement);

    /**
     * 查询单条数据
     * @param statement
     * @param parameter
     * @param <T> 返回对象
     * @return
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 查询多条数据
     * @param parameter
     * @param <T> 返回对象列表
     * @return
     */
    <T> List<T> selectList(Object parameter);
    /**
     * 查询多条数据
     * @param statement
     * @param parameter
     * @param <T> 返回对象列表
     * @return
     */
    <T> List<T> selectList(String statement, Object parameter);
}

package com.sps.service.base;

import com.sps.common.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDB<T extends Serializable>{

    /**
     * 根据id获取对象
     * @author 
     * @date 
     */
    public abstract T get(@Param("id") Serializable id) throws Exception;


    /**
     * 获取对象
     * @author 
     * @date 
     */
    public abstract T find(@Param("entity") T obj) throws Exception;


    /**
     * 根据实体对象获取列表
     * @param t 可为空，为空为无条件查询
     * @author 
     * @date 
     */
    public abstract List<T> query(@Param("entity") T obj) throws Exception;


    /**
     * 根据实体对象获取列表
     * @param t 可为空，为空为无条件查询
     * @param page 分页对象，可为空查询全部
     * @author 
     * @date 
     */
    public abstract List<T> queryByPage(@Param("entity") T obj, @Param("page") Page<T> page) throws Exception;


    /**
     * 统计记录数
     * @author 
     * @date 
     */
    public abstract int count() throws Exception;


    /**
     * 根据实体统计记录数
     * @author 
     * @date 
     */
    public abstract int countByEntity(@Param("entity") T obj) throws Exception;


    /**
     * 保存
     * int > 0为保存成功
     * @author 
     * @date 
     */
    public abstract int save(@Param("entity") T obj) throws Exception;


    /**
     * 根据实体更新
     * int > 0为更新成功
     * @author 
     * @date 
     */
    public abstract int update(@Param("entity") T obj) throws Exception;


    /**
     * 更新
     * @param arg1 更新条件集合eg:   key:"id", value="1"
     * @param arg2 需要更新的值eg:   key:"name", value="张三"
     * int > 0为更新成功
     * @author 
     * @date 
     */
    public abstract int updateByCond(@Param("conds") Map<String, Object> arg1, @Param("vals") Map<String, Object> arg2) throws Exception;


    /**
     * 删除
     * @param id id
     * int > 0为删除成功
     * @author 
     * @date 
     */
    public abstract int delete(@Param("id") Serializable id) throws Exception;


     /**
     * 删除
     * @param obj 实体
     * int > 0为删除成功
     * @author 
     * @date 
     */
    public abstract int deleteByEntity(@Param("entity") T obj) throws Exception;


    /**
     * 删除
     * @param map 删除条件集合eg:   key:"id", value="1"
     * int > 0为删除成功
     * @author 
     * @date 
     */
    public abstract int deleteByCond(@Param("map") Map<String, Object> map) throws Exception;

}

package com.sps.service.app.help;

import com.sps.entity.app.Help;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018-03-06.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public interface HelpService {
    /**
     * 获取所有的标题
     * @return List
     */
    List<Help>  queryAllTittle();

    /**
     * 根据id，查询内容信息
     * @param helpId
     * @return
     */
   Help  queryContent(Integer helpId);
}

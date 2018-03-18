package com.sps.dao.helpAndFeedBack;


import com.sps.entity.helpAndFeedback.Help;

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
public interface HelpDao {
    //查询所有的标题
    List<Help> selectAllTittle();
    //查询标题下的内容
    Help selectContent(Integer helpId);
    //保存标题的方法
    int insertHelp(Help help);
}

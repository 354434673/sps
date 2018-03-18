package com.sps.dao.helpAndFeedBack;


import com.sps.entity.helpAndFeedback.FeedBack;

/**
 * Created by Administrator on 2018-03-07.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲
 * @createDate ${date}$ ${timme}$
 */
public interface FeedBackDao {
//    保存反馈内容的方法
    int insertFeedBack(FeedBack feedBack);
//    查询反馈内容的方法

}

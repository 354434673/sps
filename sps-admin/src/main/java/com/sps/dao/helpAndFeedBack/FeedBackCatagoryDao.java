package com.sps.dao.helpAndFeedBack;


import com.sps.entity.helpAndFeedback.FeedbackCategory;

import java.util.List;

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
public interface FeedBackCatagoryDao {
    /**
     * 保存反馈类型的方法
     * @param cate
     * @return
     */
    int insertFeedBackCatagory(FeedbackCategory cate);

    /**
     * 查询所有反馈类型
     * @return
     */
    List<FeedbackCategory> selectList();
}

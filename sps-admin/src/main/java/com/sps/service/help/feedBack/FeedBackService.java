package com.sps.service.help.feedBack;



import com.sps.entity.helpAndFeedback.FeedBack;
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
public interface FeedBackService {

//    查询反馈类型
    List<FeedbackCategory> queryAllCtagory();

//    保存反馈内容
    Boolean   saveContent(FeedBack feedBack);
}

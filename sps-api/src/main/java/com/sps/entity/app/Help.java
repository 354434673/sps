package com.sps.entity.app;

import java.io.Serializable;

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
public class Help implements Serializable {

//主键id
    private  Integer id;
//    主题
   private String  title;
//    内容
    private String  content;
//    创建日期
    private  String createDate;
//    标志
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}

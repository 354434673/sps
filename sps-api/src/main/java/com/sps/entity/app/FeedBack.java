package com.sps.entity.app;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-03-06.
 *
 * @projectName ${project_name}.
 * @Package ${package_name}.
 * @ClassName ${type_name}.
 * @Description description  the function of the class
 * @Author 刘彩玲 反馈信息
 * @createDate ${date}$ ${timme}$
 */
public class FeedBack implements Serializable {

    private Integer id;
    private Integer categoeyId;
    private String content;
    private String  createtime;
    private String creater;
    private  String systype;

    public Integer getCategoeyId() {
        return categoeyId;
    }

    public void setCategoeyId(Integer categoeyId) {
        this.categoeyId = categoeyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getSystype() {
        return systype;
    }

    public void setSystype(String systype) {
        this.systype = systype;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

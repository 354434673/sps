package com.sps.exception;
/**
 * 自定义异常
 * @ClassName:  ImgException   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author YangNingSheng
 * @date 2018年4月2日 下午5:40:03
 */
public class ImgException extends Exception {
    public ImgException(){
        super();
    }
    public ImgException(String msg){
        super(msg);
    }
}

package com.sps.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;


public class BaseOperate {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    protected String getReqContent(HttpServletRequest request) throws Exception{
        byte[] buffer = new byte[64*1024];
        InputStream in = request.getInputStream();
        int length = in.read(buffer);
        String encode = request.getCharacterEncoding();
        byte[] data;
        try {
            data = new byte[length];
            System.arraycopy(buffer, 0, data, 0, length);
        }catch (Exception e){
            return null;
        }
        return new String(data, encode);
    }

}

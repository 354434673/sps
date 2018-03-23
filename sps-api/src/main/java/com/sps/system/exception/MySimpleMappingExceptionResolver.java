package com.sps.system.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;

public class  MySimpleMappingExceptionResolver extends org.springframework.web.servlet.handler.SimpleMappingExceptionResolver{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected String findMatchingViewName(Properties exceptionMappings, Exception ex) {
        try {
            logger.error("运行发生异常↓↓↓↓↓", ex);
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.findMatchingViewName(exceptionMappings, ex);
    }
}

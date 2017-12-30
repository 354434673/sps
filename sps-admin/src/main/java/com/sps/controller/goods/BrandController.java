package com.sps.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.sps.service.TestDubbo;

@Controller
@RequestMapping(value = "/test")
public class BrandController {
    /*@Reference
    private TestDubbo testDubbo;
    @RequestMapping("/pro")
    public void testMyDubbo(){
        testDubbo.testMyDubb();
    }*/
}

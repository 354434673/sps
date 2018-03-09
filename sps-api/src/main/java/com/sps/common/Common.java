package com.sps.common;


import java.util.Map;

/**
 * 验证等工具类
 * Created by samchen on 2016/7/1.
 */
public class Common {

    /**
     * 验证参数
     * @param map 接口接收的参数
     * @param args 所需要验证的参数名
     * @return
     */
    public static ReturnInfo validate(Map<String,Object> map,String...args){
        ReturnInfo ri = new ReturnInfo();
        StringBuffer sb = new StringBuffer("");
        boolean bl = true ;
        for(String s : args){
            if(map.get(s) == null || map.get(s).equals("")){
                sb.append(s);
                sb.append(",");
                bl = false ;
            }
        }
        if (bl) {
            ri.setCode(Message.API_SUCCESS_CODE);
            ri.setMsg(Message.API_SUCCESS_MSG);
            ri.setResult(map);
        } else {
            ri.setCode(Message.FAILURE_CODE);
            ri.setMsg(Message.ERROR_MSG);
            ri.setResult(sb.toString());
        }
        return ri;
    }

    /**
     * 封装分页
     */
    public static Map<String,Object> pageFormat(Map<String,Object> map){
        int rows = 20 ;     // 默认每页条数

        String pageStr = String.valueOf(map.get("page")) ;
        int page = Integer.parseInt(pageStr);
        if(map.get("rows") != null){
            rows = Integer.parseInt(String.valueOf(map.get("rows")));
        }
        int startIndex = (page - 1) * rows < 0 ? 0 : (page - 1) * rows;
        map.put("startIndex", startIndex);
        map.put("page",page);
        map.put("rows",rows);
        return map;
    }
}

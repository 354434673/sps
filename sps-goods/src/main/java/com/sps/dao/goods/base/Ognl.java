package com.sps.dao.goods.base;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * mybatis sql语句ognl语法支持
 */
public class Ognl {

    /**
     * test for Map,Collection,String,Array isEmpty
     * @param o
     * @return
     */
    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if(o == null) return true;

        if(o instanceof String) {
            if(((String)o).length() == 0){
                return true;
            }
        } else if(o instanceof Collection) {
            if(((Collection)o).isEmpty()){
                return true;
            }
        } else if(o.getClass().isArray()) {
            if(Array.getLength(o) == 0){
                return true;
            }
        } else if(o instanceof Map) {
            if(((Map)o).isEmpty()){
                return true;
            }
        }else {
            return false;
        }

        return false;
    }

    /**
     * test for Map,Collection,String,Array isNotEmpty
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     * test for long
     *
     * @param o
     * @return
     */
    public static boolean isNotZero(long o) {
        return o == 0L ? false : true;
    }

    /**
     * test for int
     *
     * @param o
     * @return
     */
    public static boolean isNotZero(int o) {
        return o == 0 ? false : true;
    }

    /**
     * test for byte
     *
     * @param o
     * @return
     */
    public static boolean isNotZero(byte o) {
        return o == 0x0 ? false : true;
    }
}


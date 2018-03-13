package com.sps.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据自定义属性设置返回参数个数
 * @author Zhang Yongwei
 *
 */
public class EntityUtils {
	/**
	 * 根据字段设置值
	 * @param <E>
	 * @param entity 实体类
	 * @param property 参数名
	 * @return Obj
	 */
	public static <E> Object getTer(E entity,String property){
		if(null== entity || isEmpty(property)){
			return "";
		}
		Object entityTemp = entity ;
		for (String propertyArr : property.trim().split("\\.")) {
			entityTemp = invokeReturn(entityTemp, "get"+propertyArr) ;
			if(null==entityTemp){
				entityTemp= "";
			}
		}
		return entityTemp;
	}


	/**
	 * 根据定义的属性，返回对应的值，去除多余字段
	 * @param entityList    实体列表
	 * @param showPropertyArray    传入的自定义字段    String[] pro = new String[]{"id","email","nickname"};
	 * @param <E>
     * @return  返回map类型List
     */
	public static <E> Object reloadListPropertyValue(List<E> entityList,String[] showPropertyArray){
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		for (Object one : entityList) {
			Map<String, Object> oneAdd = new HashMap<String, Object>();
			for (String property:showPropertyArray){
				oneAdd.put(property, getTer(one, property));
			}
			resultList.add(oneAdd);
		}
		return resultList;
	}

	/**
	 * 根据定义的属性，返回对应的值，去除多余字段
	 * @param entity    实体对象
	 * @param showPropertyArray    传入的自定义字段    String[] pro = new String[]{"id","email","nickname"};
	 * @param <E>
	 * @return  返回map类型
	 */
	public static <E> Object reloadEntityPropertyValue(E entity,String[] showPropertyArray){
			Map<String, Object> oneAdd = new HashMap<String, Object>();
			for (String property:showPropertyArray){
				oneAdd.put(property, getTer(entity, property));
			}
		return oneAdd;
	}

	/**
	 * 获取对应字段的值
	 * @param <E>
	 * @param entity
	 * @param methodName
	 * @return
	 */
	private static <E> Object invokeReturn(E entity,String methodName){
		return invoke(entity, methodName, null, null) ;
	}
	@SuppressWarnings("unchecked")
	private static <E> Object invoke(E entity,String methodName,Class[] valueTypes,Object[] values){
		try{
			return entity.getClass().getMethod(methodName, null==valueTypes?new Class[]{}:valueTypes).invoke(entity, null==values?new Object[]{}:values);
		}catch(Exception e){
			//e.printStackTrace();
			return null ;
		}
	}
	/**
	 * 修改首字母为大写
	 * @param str
	 * @return
	 */
	private static String toUpperFirst(String str){
		return isEmpty(str)?str:str.replaceFirst(str.substring(0,1), str.substring(0,1).toUpperCase()) ;
	}
	/**
	 * 是否为空
	 * @param str
	 * @return
	 */
	private static boolean isEmpty(String str){
		return null==str||"".equals(str.trim()) ;
	}


}

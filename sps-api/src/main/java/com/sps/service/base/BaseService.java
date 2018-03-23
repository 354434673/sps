package com.sps.service.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseService {

    public abstract String get(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String find(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String query(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String queryByPage(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String count(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String countByEntity(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String save(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String update(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String updateByCond(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String delete(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String deleteByEntity(HttpServletRequest request, HttpServletResponse response) throws Exception;


    public abstract String deleteByCond(HttpServletRequest request, HttpServletResponse response) throws Exception;

}

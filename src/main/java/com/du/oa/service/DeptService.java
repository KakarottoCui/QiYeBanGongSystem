package com.du.oa.service;

import java.util.List;

import com.du.oa.bean.Dept;

public interface DeptService {
    public String getAllDeptJson(int page , int count);
    String deptListForUserAdd();
    String addDept(String deptName);
    String modifyDept(String id , String deptName);
    String deleteDept(String id);
    List<Dept> getAllDept();
}

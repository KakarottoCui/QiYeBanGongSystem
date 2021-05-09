package com.du.oa.service;

import java.util.List;

import com.du.oa.bean.ShowRole;

public interface RoleService {
	List<ShowRole> getAllShowRole();
	String roleListForUserAdd();
	String getAllShowRoleJson(int page , int count);
	String addRole(String roleName , String englisgName);
	String setRole(int id , String tips , String roles);
	String deleteRole(int id);
	String addRelation(int roleid , String menus);
}

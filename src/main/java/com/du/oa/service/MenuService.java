package com.du.oa.service;

import java.util.List;

import com.du.oa.bean.Menu;

public interface MenuService {
	List<Menu> getUserMenu();
	String menuTreeData();
}

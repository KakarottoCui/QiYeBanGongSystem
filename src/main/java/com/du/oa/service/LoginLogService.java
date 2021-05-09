package com.du.oa.service;

import java.util.List;

import com.du.oa.bean.LoginLog;
import com.du.oa.bean.ShowLog;


public interface LoginLogService {
	
	public List<LoginLog> getAllLoginLog();

	public List<ShowLog> getAllShowLoginLog();
	
	public String deleteALLLoginLog();
	
	public String getShowLogJson(int page, int count);
	
}

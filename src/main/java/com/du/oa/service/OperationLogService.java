package com.du.oa.service;

import java.util.List;

import com.du.oa.bean.OperationLog;
import com.du.oa.bean.ShowLog;


public interface OperationLogService {
	
	public List<OperationLog> getAllOperationLog();

	public List<ShowLog> getAllShowLog();
	
	public String deleteALLLog();
	
	public String getShowLogJson(int page , int count);
	
	
}

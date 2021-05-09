package com.du.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.du.oa.bean.OperationLog;
import com.du.oa.bean.ShowLog;
import com.du.oa.constant.Constant;
import com.du.oa.dao.OperationLogMapper;
import com.du.oa.service.OperationLogService;
import com.du.oa.utils.BeanUtil;
import com.du.oa.utils.JqgridUtil;

@Service
public class OperationLogServiceImpl implements OperationLogService {
	@Autowired
	private OperationLogMapper mapper;
	@Autowired
	private BeanUtil beanUtil;
	@Autowired
	private JqgridUtil jqgridUtil;

	@Override
	public List<OperationLog> getAllOperationLog() {
		return mapper.selectList(new EntityWrapper<OperationLog>().orderBy("createtime" , false));
	}

	@Override
	public List<ShowLog> getAllShowLog() {
		return beanUtil.operationLogListToShowLogList(getAllOperationLog());
	}

	@Override
	public String deleteALLLog() {
		int result = mapper.delete(null);
		if (result > 0) {
			return Constant.OPERATION_SUCCESS_CODE;
		} else {
			return Constant.ERROR_DELETE_LOGINLOG_FAIL;
		}
	}



	@Override
	public String getShowLogJson(int page, int count) {
		List<ShowLog> all = getAllShowLog();
		int toIndex = count * page;
		if (all.size() < toIndex) {
			toIndex = all.size();
		}
		List<ShowLog> list = all.subList(count * (page - 1), toIndex);
		return jqgridUtil.getJson(list, page + "", all.size() , count);
	}

}

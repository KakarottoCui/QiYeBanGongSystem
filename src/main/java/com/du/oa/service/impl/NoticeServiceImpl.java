package com.du.oa.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.du.oa.bean.Notice;
import com.du.oa.bean.ShowNotice;
import com.du.oa.constant.state.NoticeType;
import com.du.oa.dao.NoticeMapper;
import com.du.oa.service.NoticeService;
import com.du.oa.utils.BeanUtil;
import com.du.oa.utils.Userinfo;
@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private BeanUtil beanUtil;
	
	@Override
	public List<Notice> getAllNotice() {
		return noticeMapper.selectList(null);
	}
	
	

	@Override
	public int sendSystemNotice(String body) {
		
		Notice notice = new Notice();
		notice.setBody(body);
		notice.setCreatetime(new Date());
		notice.setSenduserid(Userinfo.getUser().getId());
		notice.setType(NoticeType.System.getName());

		return noticeMapper.insert(notice);
	}

	@Override
	public int sendConmonNotice(String body, String recive) {
		
		return 0;
	}

	@Override
	public List<ShowNotice> getAllShowNotice() {
		List<Notice> list = this.getIndexNotice();
		List<ShowNotice> showList = new ArrayList<ShowNotice>();
		for(Notice notice : list){
			showList.add(beanUtil.toShowNotice(notice));
		}
		return showList;
	}



	@Override
	public List<Notice> getIndexNotice() {
		return noticeMapper.selectList(new EntityWrapper<Notice>().orderBy("createtime" , false).last("limit 0,15"));
	}



}

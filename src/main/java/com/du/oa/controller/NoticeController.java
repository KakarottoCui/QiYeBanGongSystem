package com.du.oa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.du.oa.annotation.BizLog;
import com.du.oa.bean.Notice;
import com.du.oa.constant.Constant;
import com.du.oa.service.NoticeService;
import com.google.gson.Gson;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private Gson gson;
	
	@ResponseBody
	@RequestMapping(value="/noticelist" , method={RequestMethod.POST})
	public String noticeList(){
		 List<Notice> list = noticeService.getIndexNotice();
		 return gson.toJson(list);
	}
	@BizLog("添加通知")
	@ResponseBody
	@RequestMapping(value="/addnotice" , method={RequestMethod.POST})
	public String addNotice(HttpServletRequest request){
		String messagetype = request.getParameter("messagetype");
		String body = request.getParameter("body");
		int result = Constant.RESULT_DEFAULT_ADD_NOTICE;
		if ("1".endsWith(messagetype)) {
			String recive = request.getParameter("recive");	
			result = noticeService.sendConmonNotice(body, recive);
		}else{
			result = noticeService.sendSystemNotice(body);
		}
		
		return String.valueOf(result) ;
	}
	
	
}

package com.du.oa.service;

import java.util.List;

import com.du.oa.bean.Memo;

public interface MemoService {
	String addMemo(String title , String text , String time);
	List<Memo> getUserMemoList();
	String deleteMemo(int id);
}

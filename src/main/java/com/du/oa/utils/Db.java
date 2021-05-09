package com.du.oa.utils;

public class Db {
	public static <T> T getMapper(Class<T> clazz){
		return (T)SpringContextHolder.getBean(clazz);
	}
}

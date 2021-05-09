package com.du.oa.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 系统的一些属性
 */
@Component
public class LinProperties {
	public static final String PREFIX = "oa";
	/**
	 * 验证码开关
	 */
	@Value("${oa.kaptchaswich}")
	private boolean kptchaswich = false;

	public boolean isKptchaswich() {
		return kptchaswich;
	}

	public void setKptchaswich(boolean kptchaswich) {
		this.kptchaswich = kptchaswich;
	}


	
	
	
}

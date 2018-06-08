package com.khidi.common.utils;

import java.math.BigDecimal;

/**
 * 常量
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月15日 下午1:23:52
 */
public class Constant {
	/** 超级管理员ID */
	public static final String SUPER_ADMIN = "f8a3fdcf-f9b2-4fdf-bd3f-aa3a4cab251b";

	/**
	 * 菜单类型
	 * 
	 * @author chenshun
	 * @email sunlightcs@gmail.com
	 * @date 2016年11月15日 下午1:24:29
	 */
    public enum MenuType {
        /**
         * 目录
         */
    	CATALOG(new BigDecimal(0)),
        /**
         * 菜单
         */
        MENU(new BigDecimal(1)),
        /**
         * 按钮
         */
        BUTTON(new BigDecimal(2));

        private BigDecimal value;

        private MenuType(BigDecimal value) {
            this.value = value;
        }

        public BigDecimal getValue() {
            return value;
        }
    }
}

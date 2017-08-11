package com.framework.common.constant;

/**
 * 基本常量类
 * 
 * @version 1.0
 * @author xxp
 */
public class BaseConstant {

	/**
	 * 是否
	 * 
	 * @version 1.0
	 * @author xxp
	 */
	public static enum YNEnum {
		/**
		 * 是
		 */
		YES("1", "是"),
		
		/**
		 * 否
		 */
		NO("0", "否");

		private String name;
		private String code;

		public String getCode() {
			return this.code;
		}

		public String getName() {
			return this.name;
		}

		private YNEnum(String code, String name) {
			this.code = code;
			this.name = name;
		}
	}

	/**
	 * 缓存类型
	 * @version 1.0
	 * @author xxp
	 */
	public static enum CacheTypeEnum {
		/**
		 * Redis
		 */
		Redis("Redis"),
		/**
		 * Ehcache
		 */
		Ehcache("Ehcache");

		private String type;

		private CacheTypeEnum(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}
}

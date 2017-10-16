package com.guang.diablo2.frame;

public class Option {
	private String lable;
	private int value;
	/**
	 * 返回 #{bare_field_comment}
	 * @return the lable
	 */
	public String getLable() {
		return lable;
	}
	
	/**
	 * 设置 #{bare_field_comment}
	 * @param lable the lable to set
	 */
	public void setLable(String lable) {
		this.lable = lable;
	}
	
	/**
	 * 返回 #{bare_field_comment}
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * 设置 #{bare_field_comment}
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return lable;
	}

	/**
	 * @param lable
	 * @param value
	 */
	public Option(String lable, int value) {
		this.lable = lable;
		this.value = value;
	}
	
	/**以str为标签
	 * @param str 逗号分隔字符串
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月5日上午2:58:08
	 * @since 1.0.0
	 */
	public static Option[] getOptionsLable(String str) {
		if (str==null) return null;
		String[] strArray = str.split(",");
		Option[] options = new Option[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			options[i] = new Option(strArray[i], i);
		}
		return options;
	}
	
	/**str作值
	 * @param str 逗号分隔整数
	 * @return
	 * @author zhouchenguang
	 * @date 2017年10月5日上午2:58:57
	 * @since 1.0.0
	 */
	public static Option[] getOptionsValue(String str) {
		if (str==null) return null;
		String[] strArray = str.split(",");
		Option[] options = new Option[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			options[i] = new Option(i+"",Integer.parseInt(strArray[i]));
		}
		return options;
	}
}

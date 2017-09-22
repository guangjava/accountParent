package com.guang.keepupwithjava8.stream;

/**
 * @comment // 店铺属性
 * @author zhouchenguang
 * @date 2017年8月11日上午10:59:19
 * @version 1.0.0
 */
public class Property {
	String  name;
    /**
     * // 距离，单位:米
     */
    Integer distance;
    /**
     * // 销量，月售
     */
    Integer sales;
    /**
     * // 价格，这里简单起见就写一个级别代表价格段
     */
    Integer priceLevel;
    public Property(String name, int distance, int sales, int priceLevel) {
        this.name = name;
        this.distance = distance;
        this.sales = sales;
        this.priceLevel = priceLevel;
    }
    // getter setter 省略
	/**
	 * 返回 #{bare_field_comment}
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 #{bare_field_comment}
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 返回 距离，单位:米
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}
	
	/**
	 * 设置 距离，单位:米
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	/**
	 * 返回 销量，月售
	 * @return the sales
	 */
	public Integer getSales() {
		return sales;
	}
	
	/**
	 * 设置 销量，月售
	 * @param sales the sales to set
	 */
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	/**
	 * 返回 价格，这里简单起见就写一个级别代表价格段
	 * @return the priceLevel
	 */
	public Integer getPriceLevel() {
		return priceLevel;
	}
	
	/**
	 * 设置 价格，这里简单起见就写一个级别代表价格段
	 * @param priceLevel the priceLevel to set
	 */
	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}
	
    
}

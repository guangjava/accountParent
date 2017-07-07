package com.guang.webtest.service;

import com.guang.webtest.domain.CityLocations;
import com.guang.webtest.enums.Locale;

/**
 * @comment ip寻址服务
 * @author zhouchenguang
 * @date 2017年4月26日下午2:26:24
 * @version 1.0.0
 */
public interface GeoIPService {
	/**从csv文件中添加ipv4记录
	 * @param fileName
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年4月26日下午2:26:38
	 * @since 1.0.0
	 */
	public void addCityBlockIPv4(String fileName);
	/**从csv文件添加城市信息
	 * @param fileName
	 * @param locale
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年4月26日下午2:27:07
	 * @since 1.0.0
	 */
	public void addCityLocation(String fileName,Locale locale);
	/**根据ip获取城市
	 * @param ipv4
	 * @param locale
	 * @return
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年4月26日下午2:27:29
	 * @since 1.0.0
	 */
	public CityLocations getLocationIPv4(String ipv4,Locale locale);
}

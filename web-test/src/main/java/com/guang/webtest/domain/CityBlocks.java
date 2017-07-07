package com.guang.webtest.domain;

import java.io.Serializable;
/**
 * ip地址信息
 * @author zhouchenguang
 *
 */
public class CityBlocks implements Serializable {
	private static final long serialVersionUID = -1695302917811753497L;
	private String network;
      private int mask;
      private long geonameId;
      private long registeredCountryGeonameId;
      private long representedCountryGeonameId;
      private char isAnonymousProxy;
      private char isSatelliteProvider;
      private String postalCode;
      private String latitude;
      private String longitude;
      private long accuracyRadius;
    
    /**
     * @return 二进制ip，位数为掩码位数
     * @exception
     * @author zhouchenguang
     * @date 2017年4月26日下午4:03:55
     * @since 1.0.0
     */
    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
    /**
     * @return 掩码位数
     * @exception
     * @author zhouchenguang
     * @date 2017年4月26日下午4:04:41
     * @since 1.0.0
     */
    public int getMask() {
        return mask;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }
    /**
     * @return 地区id
     * @exception
     * @author zhouchenguang
     * @date 2017年4月26日下午4:04:53
     * @since 1.0.0
     */
    public long getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(long geonameId) {
        this.geonameId = geonameId;
    }
    /**
     * @return 注册国家id
     * @exception
     * @author zhouchenguang
     * @date 2017年4月26日下午4:05:07
     * @since 1.0.0
     */
    public long getRegisteredCountryGeonameId() {
        return registeredCountryGeonameId;
    }

    public void setRegisteredCountryGeonameId(long registeredCountryGeonameId) {
        this.registeredCountryGeonameId = registeredCountryGeonameId;
    }
    public long getRepresentedCountryGeonameId() {
        return representedCountryGeonameId;
    }

    public void setRepresentedCountryGeonameId(long representedCountryGeonameId) {
        this.representedCountryGeonameId = representedCountryGeonameId;
    }
    public char getIsAnonymousProxy() {
        return isAnonymousProxy;
    }

    public void setIsAnonymousProxy(char isAnonymousProxy) {
        this.isAnonymousProxy = isAnonymousProxy;
    }
    public char getIsSatelliteProvider() {
        return isSatelliteProvider;
    }

    public void setIsSatelliteProvider(char isSatelliteProvider) {
        this.isSatelliteProvider = isSatelliteProvider;
    }
    /**
     * @return 邮政编码
     * @exception
     * @author zhouchenguang
     * @date 2017年4月26日下午4:05:22
     * @since 1.0.0
     */
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    /**
     * @return 纬度
     * @exception
     * @author zhouchenguang
     * @date 2017年4月26日下午4:05:35
     * @since 1.0.0
     */
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    /**
     * @return 经度
     * @exception 
     * @author zhouchenguang
     * @date 2017年4月26日下午4:05:55
     * @since 1.0.0
     */
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    /**
     * @return 精度半径
     * @exception
     * @author zhouchenguang
     * @date 2017年4月26日下午4:06:06
     * @since 1.0.0
     */
    public long getAccuracyRadius() {
        return accuracyRadius;
    }

    public void setAccuracyRadius(long accuracyRadius) {
        this.accuracyRadius = accuracyRadius;
    }
    
    
}

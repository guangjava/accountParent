package com.guang.webtest.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guang.webtest.dao.CityBlocksIPv4Dao;
import com.guang.webtest.domain.CityBlocks;
import com.guang.webtest.domain.CityLocations;
import com.guang.webtest.enums.Locale;
import com.guang.webtest.service.GeoIPService;

@Service("geoIpService")
public class GeoIPServiceImpl implements GeoIPService{
	private static final Logger logger = LoggerFactory.getLogger(GeoIPServiceImpl.class);
	@Autowired
	private CityBlocksIPv4Dao ipv4Dao;
	@Transactional
	@Override
	public void addCityBlockIPv4(String fileName) {
		File file = new File(fileName);
		try {
			Reader reader = new FileReader(file);
			//csv解析
			CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
			for (CSVRecord csvRecord : parser) {
				if (csvRecord.getRecordNumber() < 624876) {//52323
					continue;
				}
				CityBlocks cityBlocks = parseCityBlocks(csvRecord);
				ipv4Dao.insert(cityBlocks);
				logger.info(csvRecord.getRecordNumber()+"====>"+cityBlocks.getNetwork());
			}
			parser.close();
		} catch (FileNotFoundException e) {
			logger.error("no file found",e);
		} catch (IOException e) {
			logger.error("csv parser fail",e);
		} catch (Exception e) {
			logger.error("parse object fail",e);
		} 
	}

	@Override
	public void addCityLocation(String fileName, Locale locale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CityLocations getLocationIPv4(String ipv4, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	/**解析ip成二进制格式
	 * @param csvRecord
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年4月26日下午3:22:46
	 * @since 1.0.0
	 */
	private Map<String, String> parseNetwork(String network) throws Exception{
		Map<String, String> map = new HashMap<>();
		//1.0.0.0/24
		String[] networkList = network.split("/");
		String[] ip = networkList[0].split("\\.");
		StringBuilder sb = new StringBuilder();
		//转换成二进制ip
		for (String nm : ip) {
			String binaryString = Integer.toBinaryString(Integer.parseInt(nm));
			for (int i = 8; i > binaryString.length(); i--) {
				sb.append('0');
			}
			sb.append(binaryString);
		}
		String subip = sb.substring(0, Integer.parseInt(networkList[1]));
		map.put("subip", subip);
		map.put("mask", networkList[1]);
		return map;
	}
	
	/**将csv一行记录转换成对象
	 * @param csvRecord
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年4月26日下午4:21:26
	 * @since 1.0.0
	 */
	private CityBlocks parseCityBlocks(CSVRecord csvRecord) throws Exception{
		String network = csvRecord.get(CityBlockConstant.network);
		Map<String, String> ip = parseNetwork(network);
		CityBlocks cityBlocks = new CityBlocks();
		cityBlocks.setNetwork(ip.get("subip"));
		cityBlocks.setMask(Integer.parseInt(ip.get("mask")));
		String geoname_id = csvRecord.get(CityBlockConstant.geoname_id);
		if (geoname_id!=null && !"".equals(geoname_id.trim())) {
			cityBlocks.setGeonameId(Long.parseLong(geoname_id));
		}
		String registered_country_geoname_id = csvRecord.get(CityBlockConstant.registered_country_geoname_id);
		if (registered_country_geoname_id!=null && !"".equals(registered_country_geoname_id.trim())) {
			cityBlocks.setRegisteredCountryGeonameId(Long.parseLong(registered_country_geoname_id));
		}
		String represented_country_geoname_id = csvRecord.get(CityBlockConstant.represented_country_geoname_id);
		if (represented_country_geoname_id!=null && !"".equals(represented_country_geoname_id.trim())) {
			cityBlocks.setRepresentedCountryGeonameId(Long.parseLong(represented_country_geoname_id));
		}
		String is_anonymous_proxy = csvRecord.get(CityBlockConstant.is_anonymous_proxy);
		if (is_anonymous_proxy!=null && !"".equals(is_anonymous_proxy.trim())) {
			cityBlocks.setIsAnonymousProxy(is_anonymous_proxy.charAt(0));
		}
		String is_satellite_provider = csvRecord.get(CityBlockConstant.is_satellite_provider);
		if (is_satellite_provider!=null && !"".equals(is_satellite_provider.trim())) {
			cityBlocks.setIsSatelliteProvider(is_satellite_provider.charAt(0));
		}
		cityBlocks.setPostalCode(csvRecord.get(CityBlockConstant.postal_code));
		cityBlocks.setLatitude(csvRecord.get(CityBlockConstant.latitude));
		cityBlocks.setLongitude(csvRecord.get(CityBlockConstant.longitude));
		String accuracy_radius = csvRecord.get(CityBlockConstant.accuracy_radius);
		if (accuracy_radius!=null && !"".equals(accuracy_radius.trim())) {
			cityBlocks.setAccuracyRadius(Long.parseLong(accuracy_radius));
		}
		return cityBlocks;
	}
	
	private class CityBlockConstant{
		/**
		 * ip
		 */
		public static final int network = 0;
		/**
		 * 地区代码
		 */
		public static final int geoname_id = 1;
		/**
		 * 注册国家id
		 */
		public static final int registered_country_geoname_id = 2;
		public static final int represented_country_geoname_id = 3;
		public static final int is_anonymous_proxy = 4;
		public static final int is_satellite_provider = 5;
		/**
		 * 邮政编码
		 */
		public static final int postal_code = 6;
		/**
		 * 纬度
		 */
		public static final int latitude = 7;
		/**
		 * 经度
		 */
		public static final int longitude = 8;
		/**
		 * 精度半径
		 */
		public static final int accuracy_radius = 9;
	}
}

package com.guang.webtest.service;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-db.xml"})
public class TestGeoIp {
	private static final Logger logger = LoggerFactory.getLogger(TestGeoIp.class);
	@Autowired
	private GeoIPService geoIpService;
	@Test
	public void testAddCityBlocks(){
		try {
			long time1 = System.currentTimeMillis();
			System.out.println(Calendar.getInstance().getTime());
			geoIpService.addCityBlockIPv4("D:\\GeoLite2-City-CSV_20170404\\GeoLite2-City-Blocks-IPv4.csv");
			System.out.println(Calendar.getInstance().getTime());
			System.out.println(System.currentTimeMillis() - time1);
		} catch (Exception e) {
			logger.error("",e);
		}
	}
}

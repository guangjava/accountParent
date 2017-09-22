package com.account.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.account.spring.security.tool.AntUrlPathMatcher;
import com.account.spring.security.tool.UrlMatcher;

public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	/**
	 * tomcat启动时实例化一次  
	 */
	public MyInvocationSecurityMetadataSource() {
		 loadResourceDefine();    
	}
	
	//tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系  
	private void loadResourceDefine() {
		resourceMap = new HashMap<>();
		Collection<ConfigAttribute> atts = new ArrayList<>();
		ConfigAttribute caStu = new SecurityConfig("ROLE_STU");
		atts.add(caStu);
		ConfigAttribute caTea = new SecurityConfig("ROLE_TEA");
		atts.add(caTea);
		ConfigAttribute caAdm = new SecurityConfig("ROLE_ADM");
		atts.add(caAdm);
		resourceMap.put("/index.jsp", atts);
		Collection<ConfigAttribute> attsno = new ArrayList<>();
		ConfigAttribute cano = new SecurityConfig("ROLE_NO");
		attsno.add(cano);
		resourceMap.put("/other.jsp", attsno);
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation)object).getRequestUrl();
		Iterator<String> iter = resourceMap.keySet().iterator();
		while (iter.hasNext()) {
			String resURL = (String) iter.next();
			if (urlMatcher.pathMatchesUrl(resURL, url)) return resourceMap.get(resURL);
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}

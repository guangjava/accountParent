package com.account.spring.security.tool;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class AntUrlPathMatcher implements UrlMatcher {
	private boolean requiresLowerCaseUrl;  
	private PathMatcher pathMatcher;
	/**
	 * 
	 */
	public AntUrlPathMatcher() {
		this(true);
	}

	/**
	 * @param requiresLowerCaseUrl
	 */
	public AntUrlPathMatcher(boolean requiresLowerCaseUrl) {
		this.requiresLowerCaseUrl = requiresLowerCaseUrl;
		pathMatcher = new AntPathMatcher();
	}

	@Override
	public Object compile(String paramString) {
		if (requiresLowerCaseUrl) return paramString.toLowerCase();
		return paramString;
	}

	@Override
	public boolean pathMatchesUrl(Object path, String url) {
		if ("/**".equals(path) || "**".equals(path)) return true;
		return pathMatcher.match((String) path, url);
	}

	@Override
	public String getUniversalMatchPattern() {
		return "/**";
	}

	@Override
	public boolean requiresLowerCaseUrl() {
		return requiresLowerCaseUrl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getName()+"[requiresLowerCase="
				+requiresLowerCaseUrl+"]";
	}

	/**
	 * 设置 #{bare_field_comment}
	 * @param requiresLowerCaseUrl the requiresLowerCaseUrl to set
	 */
	public void setRequiresLowerCaseUrl(boolean requiresLowerCaseUrl) {
		this.requiresLowerCaseUrl = requiresLowerCaseUrl;
	}
	

}

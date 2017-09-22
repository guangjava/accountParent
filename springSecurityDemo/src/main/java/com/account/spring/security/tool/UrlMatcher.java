package com.account.spring.security.tool;

public interface UrlMatcher {
	Object compile(String paramString);  
    boolean pathMatchesUrl(Object path, String url);  
    String getUniversalMatchPattern();   
    boolean requiresLowerCaseUrl();  
}

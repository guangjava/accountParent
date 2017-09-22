package com.account.spring.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.account.spring.security.dao.IAdminDao;
import com.account.spring.security.dao.IStudentDao;
import com.account.spring.security.dao.ITeacherDao;
import com.account.spring.security.entity.Admin;
import com.account.spring.security.entity.Student;
import com.account.spring.security.entity.Teacher;
import com.account.spring.security.tool.MD5;

public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private static final String USERNAME = "username";  
    private static final String PASSWORD = "password";  
    @Resource 
    private IStudentDao studentdao;  
    @Resource 
    private ITeacherDao teacherdao;  
    @Resource 
    private IAdminDao admindao;  
	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (!request.getMethod().equals("POST")) throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		String username = obtainUsername(request);
        String password = obtainPassword(request);
        String roletype = request.getParameter("roletype");
        username = username.trim();
        String encPass = MD5.encodePassword(password, null);
        if (roletype!=null && !"".equals(roletype)) {
			if ("student".equals(roletype)) {
				Student stu = studentdao.findById(username);
				//通过session把用户对象设置到session中  
				request.getSession().setAttribute("session_user", stu);
				//将角色标志在username上  
				username = "stu"+username;
				if (stu==null || !encPass.equals(stu.getPassword())) {
					BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配");
					throw exception;
				}
			}else if ("teacher".equals(roletype)) {
				Teacher tea = teacherdao.findById(username);
				//通过session把用户对象设置到session中  
				request.getSession().setAttribute("session_user", tea);
				//将角色标志在username上  
				username = "tea"+username;
				if (tea == null || !tea.getPassword().equals(encPass)) {  
					BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配");  
					throw exception;  
				}  
			}else if("admin".equals(roletype)){  
				Admin adm = admindao.findById(username);  

				//通过session把用户对象设置到session中  
				request.getSession().setAttribute("session_user", adm);  

				//将角色标志在username上  
				username = "adm"+username;  
				if (adm == null || !encPass.equals(adm.getPassword())) {  
					BadCredentialsException exception = new BadCredentialsException("用户名或密码不匹配");  
					throw exception;  
				}  
			}else{  
				BadCredentialsException exception = new BadCredentialsException("系统错误：没有对应的角色！");  
				throw exception;  
			}  
        }
        //实现验证  
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        //允许设置用户详细属性  
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#obtainPassword(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return obj==null ? "" : obj.toString();
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#obtainUsername(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return obj==null ? "" : obj.toString();
	}

}

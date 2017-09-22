package com.account.spring.security;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.account.spring.security.dao.IAdminDao;
import com.account.spring.security.dao.IStudentDao;
import com.account.spring.security.dao.ITeacherDao;
import com.account.spring.security.entity.Admin;
import com.account.spring.security.entity.Student;
import com.account.spring.security.entity.Teacher;

public class MyUserDetailServiceImpl implements UserDetailsService {
	@Resource 
	private IStudentDao studentdao;  
	@Resource 
	private ITeacherDao teacherdao;  
	@Resource 
	private IAdminDao admindao;  
	//登陆验证时，通过username获取用户的所有权限信息，  
	//并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用  
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority> auths = new ArrayList<>();
		String roletype = username.substring(0,3);
		username = username.substring(3);
		String password = "";
		if ("stu".equals(roletype)) {
			Student stu = studentdao.findById(username);
			password = stu.getPassword();
			auths.add(new SimpleGrantedAuthority("ROLE_STU"));
		}else if("tea".equals(roletype)){  
			Teacher tea = teacherdao.findById(username);  
			password = tea.getPassword();  
			auths.add(new SimpleGrantedAuthority("ROLE_TEA"));  
		}else if("adm".equals(roletype)){  
			Admin adm = admindao.findById(username);  
			password = adm.getPassword();  
			auths.add(new SimpleGrantedAuthority("ROLE_ADM"));  
		}  

		User user = new User(username, password, true, true, true, true, auths);   
		return user;  
	}

}

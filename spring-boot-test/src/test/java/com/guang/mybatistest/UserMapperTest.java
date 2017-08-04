package com.guang.mybatistest;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.guang.core.mybatistest.Application;
import com.guang.core.mybatistest.HelloController;
import com.guang.core.mybatistest.entity.UserEntity;
import com.guang.core.mybatistest.entity.UserSexEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={Application.class})
public class UserMapperTest {
	@Autowired
	private com.guang.core.mybatistest.mapper.UserMapper UserMapper;
	private MockMvc monckMvc;
	@Before
	public void setup() {
		monckMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	@Test
	public void testHelloWord() throws Exception{
		monckMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
	}
	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
		UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
		UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

		Assert.assertEquals(3, UserMapper.listAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.listAll();
		System.out.println(users.toString());
	}

	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(3l);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(3l).getNickName())));
	}
}

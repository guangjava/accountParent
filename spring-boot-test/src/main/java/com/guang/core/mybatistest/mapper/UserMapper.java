package com.guang.core.mybatistest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;

import com.guang.core.mybatistest.entity.UserEntity;
import com.guang.core.mybatistest.entity.UserSexEnum;

public interface UserMapper {
	@Select("select * from user_test")
	@Results({
		@Result(property="userSex",column="sex",javaType=UserSexEnum.class),
		@Result(property="nickName",column="user_name")
	})
	List<UserEntity> listAll();
	@Select("select * from user_test where id=#{id}")
	@Results({
		@Result(property="userSex",column="sex",javaType=UserSexEnum.class),
		@Result(property="nickName",column="user_name")
	})
	UserEntity getOne(Long id);
	@Insert("insert into user_test (user_name,sex) values (#{nickName},#{userSex})")
	void insert(UserEntity userEntity);
	@Update("update user_test set user_name=#{nickName} where id=#{id}")
	void update(UserEntity userEntity);
	@Delete("delete from user_test where id=#{id}")
	void delete(Long id);
}

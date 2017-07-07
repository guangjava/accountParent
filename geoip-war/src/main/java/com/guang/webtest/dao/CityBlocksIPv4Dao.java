package com.guang.webtest.dao;

import org.springframework.stereotype.Repository;

import com.guang.webtest.domain.CityBlocks;

@Repository
public interface CityBlocksIPv4Dao {
	public void insert(CityBlocks cityBlocks);
}

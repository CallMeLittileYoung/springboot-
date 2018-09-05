package com.young.tkmapper.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.young.tkmappers.RunTkMapperBoot;
import com.young.tkmappers.entity.TblUserInfo;
import com.young.tkmappers.mapper.TblUserInfoMapper;

@SpringBootTest(classes= {RunTkMapperBoot.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIdsMapper {
	
	@Autowired
	private TblUserInfoMapper userInfoMapper;
	
	@Test
	public void test1() {
		
		String ids="1,4,6,8,10";
		List<TblUserInfo> selectByIds = userInfoMapper.selectByIds(ids);
		for (TblUserInfo tblUserInfo : selectByIds) {
			System.out.println(tblUserInfo);
		}
	}
}

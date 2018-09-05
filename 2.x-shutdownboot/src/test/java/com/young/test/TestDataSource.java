package com.young.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.young.shutdown.RunShutDownBoot;
import com.young.shutdown.entity.TblUserInfo;
import com.young.shutdown.mapper.TblUserInfoMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {RunShutDownBoot.class})
public class TestDataSource {

	@Autowired
	private TblUserInfoMapper tblUserInfoMapper;
	
	@Test
	public void test1() throws Exception {
		
		List<TblUserInfo> selectAllTblUserInfo = tblUserInfoMapper.selectAllTblUserInfo();
		for (TblUserInfo tblUserInfo : selectAllTblUserInfo) {
			System.err.println(tblUserInfo);
		}
	}
	
}

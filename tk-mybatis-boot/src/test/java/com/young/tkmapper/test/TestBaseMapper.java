package com.young.tkmapper.test;

import java.util.Date;

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
public class TestBaseMapper {
	
	@Autowired
	private TblUserInfoMapper userInfoMapper;
	
	@Test
	public void testInsert() {
		TblUserInfo info=new TblUserInfo();
					info.setAddress("天河南育蕾小区二街604");
					info.setBirthday(new Date());
					info.setUserName("天河区吴彦祖");
					info.setCreateTime(new Date());
					info.setEmail("769660100@qq.com");
					info.setPassWord("1234456");
					info.setUserStatu('0');
					info.setTelNum("110");
					userInfoMapper.insertSelective(info);
		
	}
	@Test
	public void testUpdate() {
		TblUserInfo info=new TblUserInfo();
					info.setAddress("天河南育蕾小区二街604");
					info.setBirthday(new Date());
					info.setUserName("天河区吴彦祖");
					info.setCreateTime(new Date());
					info.setEmail("769660100@qq.com");
					info.setPassWord("1234456");
					info.setUserStatu('0');
					info.setTelNum("110");
					userInfoMapper.updateByPrimaryKeySelective(info);
		
	}
	@Test
	public void testExist() {
		TblUserInfo info=new TblUserInfo();
					info.setId(10);
					info.setAddress("六运小区");
					boolean existsWithPrimaryKey = userInfoMapper.existsWithPrimaryKey(info);
					System.out.println(existsWithPrimaryKey);
	}
}

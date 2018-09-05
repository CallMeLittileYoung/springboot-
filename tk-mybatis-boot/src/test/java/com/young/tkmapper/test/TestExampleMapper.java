package com.young.tkmapper.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.young.tkmappers.RunTkMapperBoot;
import com.young.tkmappers.entity.TblUserInfo;
import com.young.tkmappers.mapper.TblUserInfoMapper;

import tk.mybatis.mapper.entity.Example;

@SpringBootTest(classes= {RunTkMapperBoot.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestExampleMapper {
	
	@Autowired
	private TblUserInfoMapper userInfoMapper;
	@Test
	public void test1() {
		Example example=new Example(TblUserInfo.class);
				example.createCriteria()
				       .andLessThan("createTime", new Date());
	   List<TblUserInfo> selectByExample = userInfoMapper.selectByExample(example);
	   selectByExample.forEach((TblUserInfo info)->System.out.println(info));
	}
	
	@Test
	public void test2() {
		Example example=new Example(TblUserInfo.class);
				example.createCriteria()
				       .andLike("address", "%区");
	   List<TblUserInfo> selectByExample = userInfoMapper.selectByExample(example);
	   selectByExample.forEach((TblUserInfo info)->System.out.println(info));
	}
}

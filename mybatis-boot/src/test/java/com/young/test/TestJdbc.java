package com.young.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lyd.boot.RunBoot;
import com.lyd.boot.annot.Table;
import com.lyd.boot.mapper.UserMapper;
import com.mysql.jdbc.Driver;

@SpringBootTest(classes= {RunBoot.class})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestJdbc {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testMain() throws SQLException {
		 
		 System.out.println(dataSource);
		  Driver driver=new Driver();
		  
		  Properties info=new Properties();
		  
		  Connection connection = driver.connect("jdbc:mysql://127.0.0.1:3306/springboot?useUnicode=true&characterEncoding=utf8",info);
		  
		  Statement createStatement = connection.createStatement();
		   
		   String sql="SELECT * FROM tb_user ";
		   
		   ResultSet executeQuery = createStatement.executeQuery(sql);
		   
		   while(executeQuery.next()) {
			   
			   
			   String string = executeQuery.getString("account");
			   
			   
			   System.out.println(string);
		   }
	}
	
	@Test
	public void test3() {
		
		try {
			Class<? extends UserMapper> clz= UserMapper.class;
			
			Table table = clz.getAnnotation(Table.class);
			
			 InvocationHandler invocationHandler = Proxy.getInvocationHandler(table);
			    
			Field declaredField = invocationHandler.getClass().getDeclaredField("memberValues");
			
			declaredField.setAccessible(true);
		    @SuppressWarnings("unchecked")
			Map<String,String> content = (Map<String, String>) declaredField.get(invocationHandler);
		    String string = content.get("tableName");
		    
		    System.err.println(string);
		    
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	@Autowired
	private UserMapper mapper;
	@Test
	public void test4() {
		
		System.err.println(mapper);
	}
}

package com.young.test;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.young.jpa.RunJpaBoot;
import com.young.jpa.enity.TblUserInfo;
import com.young.jpa.repository.TblUserInfoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {RunJpaBoot.class})
public class UserRepositoryTest {
	
	@Autowired
	private TblUserInfoRepository tblUserInfoRepository;
	
	@Test
	public void test1() {
		
		long count = tblUserInfoRepository.count();
		System.err.println(count);
		
	}
	//增
	@Test
	public void test2() {
		TblUserInfo tblUserInfo=new TblUserInfo();
					tblUserInfo.setAddress("富力盈隆广场");
					tblUserInfo.setBirthday(new Date());
					tblUserInfo.setCreateTime(new Date());
					tblUserInfo.setEmail("15720600157@qq.com");
					tblUserInfo.setPassWord("lyd100702");
					tblUserInfo.setUpdateTime(new Date());
					tblUserInfo.setUserStatu('0');
					tblUserInfo.setTelNum("15720600157");
					tblUserInfo.setUserName("LLLL");
		 tblUserInfoRepository.save(tblUserInfo);
	}
	//改   只能先查出来再修改吗？  感觉不是很方便呐
	@Test
	public void test3() {
		Optional<TblUserInfo> findById = tblUserInfoRepository.findById(6l);
		TblUserInfo tblUserInfo = findById.get();
					System.err.println(tblUserInfo);
				    tblUserInfo.setUserName("小年轻");
				    tblUserInfo.setUpdateTime(new Date());
		 tblUserInfoRepository.save(tblUserInfo);
	}
	//删除
	@Test
	public void test4() {
		
		tblUserInfoRepository.deleteById(7L);
	}
	//简单的全部查询
	@Test
	public void test5() {
		List<TblUserInfo> findAll = tblUserInfoRepository.findAll();
		for (TblUserInfo tblUserInfo : findAll) {
			System.out.println(tblUserInfo);
		}
	}
	//条件查询  这个Example 对于非String类型字段  简直像废物一样 ,只能进行精确匹配    不是很好用讲道理
	@Test
	public void test6() {
		TblUserInfo tblUserInfo=new TblUserInfo();
	    tblUserInfo.setUserName("小");
        //定制条件查询        	    
	    ExampleMatcher matcher=ExampleMatcher.matching()
	    		               //模糊查询
	    		               .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.contains());
	    		               //.withMatcher("birthday", ExampleMatcher.PropertySpecifiers);
		Example<TblUserInfo> example=Example.of(tblUserInfo, matcher);
		List<TblUserInfo> findAll = tblUserInfoRepository.findAll(example);
		
		for (TblUserInfo tblUserInfo2 : findAll) {
			
			System.err.println(tblUserInfo2);
			
		}
	}
	@Test
	public void  test7() {
		
		Specification<TblUserInfo> spec=new Specification<TblUserInfo>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4368467900182552775L;
			@Override
			public Predicate toPredicate(Root<TblUserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.lessThan(root.get("createTime").as(Date.class),new Date());
			}
		};
		List<TblUserInfo> findAll = tblUserInfoRepository.findAll(spec, new Sort(Direction.DESC, "createTime"));
		for (TblUserInfo tblUserInfo : findAll) {
			System.err.println(tblUserInfo);
		}
	}
	/*public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		for (int i = 0; i <10; i++) {
			list.add(i+"");
		}
		System.err.println(list.size());
		for (int i = 0; i <list.size(); i++) {
			System.err.println(list.get(i));
			if(i==8) {
				list.remove(i);
				i=i-1;
			}
			
		}
	}*/
	@Value("${young.name}")
	private String name;
    
	@Test
	public void test8() {
		System.err.println(name);
	}
}

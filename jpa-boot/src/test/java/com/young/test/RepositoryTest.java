package com.young.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.young.jpa.RunJpaBoot;
import com.young.jpa.enity.Area;
import com.young.jpa.repository.AreaRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {RunJpaBoot.class})
public class RepositoryTest {
	@Autowired
	private DataSource dataSource;
	@Test
	public void testDataSource() {
		System.err.println(dataSource);
	}
	//开始测试Jpa
	@Autowired
	private AreaRepository areaRepository;
	
	@Test
	public void testArea() {
		long count = areaRepository.count();
		System.err.println(count);
	}
	//未加索引之前  287
	@Test
	public void testArea2() {
		Area area=new Area();
			 area.setProvince("广");
		Specification<Area> specification=new Specification<Area>() {
			private static final long serialVersionUID = -6366666445873348138L;

			@Override
			public Predicate toPredicate(Root<Area> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				
				return criteriaBuilder.like(root.get("province").as(String.class), area.getProvince()+"%");
			}
		};
		long s=System.currentTimeMillis();
		List<Area> findAll = areaRepository.findAll(specification);
		long m=System.currentTimeMillis();
		for (Area area2 : findAll) {
			System.out.println(area2);
		}
		System.err.println(m-s);
	}
	@Test
	public void testArea3() {
		Area area=new Area();
			 area.setProvince("广"); 
			 Page<Area> findAll = areaRepository.findAll(new QPageRequest(1, 10));
			 List<Area> content = findAll.getContent();
			 for (Area area2 : content) {
				System.err.println(area2);
			}
	}
}

package com.young.es.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.young.el.RunElBoot;
import com.young.el.document.LocationDocument;
import com.young.el.mapper.TblLocationMapper;
import com.young.el.youngrepository.LocationRepository;


@SpringBootTest(classes= {RunElBoot.class})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class TestLocation {
	@Autowired
	private TblLocationMapper tblLocationMapper;
	
	
/*	@Autowired(required=false)
	private ElasticsearchTemplate template;*/
	@Autowired
	private LocationRepository locationRepository;
	
	
	@Test
	public void test1() {
		
		List<LocationDocument> locations = tblLocationMapper.selectPositionsByCityNameAndCountyName("广州市", "天河区");
		locationRepository.saveAll(locations);
	}
	@Test
	public void test2() {
		Iterable<LocationDocument> findAll = locationRepository.findAll();
		for (LocationDocument locationDocument : findAll) {
			System.out.println(locationDocument);
		}
	}
	@Test
	public void test3() {
		Optional<LocationDocument> findById = locationRepository.findById(274404L);
		System.out.println(findById.get());
		
	}
	@Test//274405  274404
	public void test4() {
		List<Long> ids=new ArrayList<>();
		ids.add(274404L);
		ids.add(274405L);
		Iterable<LocationDocument> findAllById = locationRepository.findAllById(ids);
		findAllById.forEach(System.out::println);
	}
	@Test
	public void test5() {
		Page<LocationDocument> findAll = locationRepository.findAll(PageRequest.of(0, 10));
		findAll.forEach(System.out::println);
	}
	//修改
	@Test
	public void test6() {
		List<Long> ids=new ArrayList<>();
		ids.add(274404L);
		ids.add(274405L);
		Iterable<LocationDocument> findAllById = locationRepository.findAllById(ids);
		findAllById.forEach((LocationDocument l)->l.setVillageName("叫我小年轻"));
		findAllById.forEach(System.out::println);
		locationRepository.saveAll(findAllById);
		
	}
	@Test
	public void test7() {
		locationRepository.deleteById(274405L);
		//boolean existsById = locationRepository.existsById(274404L);
		//System.out.println(existsById);
		Optional<LocationDocument> findById = locationRepository.findById(274405L);
		System.out.println(findById.isPresent());
	}
	@Test
	public void test8() {
		List<LocationDocument> findByCountyName = locationRepository.findByCountyName("天河区", PageRequest.of(0, 10));
		findByCountyName.forEach(System.out::println);
	}
	
}

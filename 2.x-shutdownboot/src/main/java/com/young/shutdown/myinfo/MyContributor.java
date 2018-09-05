package com.young.shutdown.myinfo;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.info.InfoContributor;

@Component
public class MyContributor implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
			builder.withDetail("young",Collections.singletonMap("lyd", "小年轻"));
	}

}

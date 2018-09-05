package com.lyd.boot.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author        Young
 * @description   该注解用于为每个接口配置表明
 * @date          2018年7月26日 下午5:43:39 
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	
	String  tableName() default "";
}

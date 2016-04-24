/**
 * File Name：CityController.java
 *
 * Copyright Defonds Corporation 2015 
 * All Rights Reserved
 *
 */
package com.defonds.bdp.city.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.defonds.bdp.city.bean.City;
import com.defonds.bdp.city.service.CityService;

/**
 * 
 * Project Name：bdp
 * Type Name：CityController
 * Type Description：
 * Author：Defonds
 * Create Date：2015-08-27
 * @version 
 * 
 */
@Controller
@RequestMapping("/city")
public class CityController {
	private final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CityController.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	/**
	 * provinceCities(这里用一句话描述这个方法的作用)
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 * @param   name
	 * @param  @return    设定文件
	 * @return String    DOM对象
	 * @Exception 异常对象
	 * @since  CodingExample　Ver(编码范例查看) 1.0.0
	 */ 
	@RequestMapping("/province/cities")
	@ResponseBody
	public Object provinceCities() {
		
		List<City> list = new ArrayList<City>();
		City city1 = new City();
		city1.setId("126");
		city1.setCity("济南市");
		city1.setCityCode("4510");
		city1.setCityJb("省级");
		city1.setCityName("济南市");
		city1.setProvince("山东省");
		
		list.add(city1);
		
		City city2 = new City();
		city2.setId("127");
		city2.setCity("济南市");
		city2.setCityCode("4510");
		city2.setCityJb("县级");
		city2.setCityName("商河县");
		city2.setProvince("山东省");
		
		list.add(city2);
		
		return list;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public Integer create() {
		try {
			this.cityService.insertCity();
			return 1;
		} catch (Exception e) {
			logger.error(e);
		}
		return 0;
		
	}
}

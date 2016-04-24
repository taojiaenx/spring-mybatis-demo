/**
 * File Name：CityService.java
 *
 * Copyright Defonds Corporation 2015
 * All Rights Reserved
 *
 */
package com.defonds.bdp.city.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.defonds.bdp.city.bean.City;
import com.defonds.bdp.city.mapper.CityMapper;

/**
 *
 * Project Name：bdp
 * Type Name：CityService
 * Type Description：
 * Author：Defonds
 * Create Date：2015-08-31
 * @version
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
public class CityService {
	private final Log logger = LogFactory.getLog(this.getClass());
	@Autowired
	private CityMapper cityMapper;

	public void insertCity() throws Exception {
		System.out.println("what the fuck");
		City city = new City();
		city.setCityCode("1100");
		city.setCityJb("1");
		city.setProvinceCode("1100");
		city.setCityName("天津市");
		city.setCity("天津市");
		city.setProvince("天津市");
		logger.debug("before insert the first city " + city.getCityCode());
		cityMapper.insertCity(city);
	}
}
